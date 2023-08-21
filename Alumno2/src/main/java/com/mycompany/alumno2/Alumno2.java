/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.alumno2;

/**
 *
 * @author hp
 */

import java.util.Scanner;

class Alumno {
    String nombre;
    String apellido;
    int semestre;
    String correo;
    String telefono;
    String cedula;

    public Alumno(String nombre, String apellido, int semestre, String correo, String telefono, String cedula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.semestre = semestre;
        this.correo = correo;
        this.telefono = telefono;
        this.cedula = cedula;
    }
}
public class Alumno2 {
    static final int MAX_ALUMNOS = 100;
    static Alumno[] alumnos = new Alumno[MAX_ALUMNOS];
    static int cantidadAlumnos = 0;

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Opciones:");
            System.out.println("1. Insertar alumno");
            System.out.println("2. Eliminar alumno");
            System.out.println("3. Modificar alumno");
            System.out.println("4. Consultar alumno");
            System.out.println("5. Terminar programa");
            System.out.print("Elija una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    insertarAlumno();
                    break;
                case 2:
                    eliminarAlumno();
                    break;
                case 3:
                    modificarAlumno();
                    break;
                case 4:
                    consultarAlumno();
                    break;
                case 5:
                    System.out.println("Programa terminado.");
                    System.exit(0);
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }

    static void insertarAlumno() {
        if (cantidadAlumnos < MAX_ALUMNOS) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Apellido: ");
            String apellido = scanner.nextLine();
            System.out.print("Semestre: ");
            int semestre = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea pendiente
            System.out.print("Correo: ");
            String correo = scanner.nextLine();
            System.out.print("Teléfono: ");
            String telefono = scanner.nextLine();
            System.out.print("Cédula: ");
            String cedula = scanner.nextLine();

            alumnos[cantidadAlumnos] = new Alumno(nombre, apellido, semestre, correo, telefono, cedula);
            cantidadAlumnos++;
            System.out.println("Alumno insertado correctamente.");
        } else {
            System.out.println("No es posible insertar más alumnos. Límite alcanzado.");
        }
    }

    static void eliminarAlumno() {
        if (cantidadAlumnos > 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese la cédula del alumno a eliminar: ");
            String cedula = scanner.nextLine();

            int indiceEliminar = -1;
            for (int i = 0; i < cantidadAlumnos; i++) {
                if (alumnos[i].cedula.equals(cedula)) {
                    indiceEliminar = i;
                    break;
                }
            }

            if (indiceEliminar != -1) {
                for (int i = indiceEliminar; i < cantidadAlumnos - 1; i++) {
                    alumnos[i] = alumnos[i + 1];
                }
                alumnos[cantidadAlumnos - 1] = null;
                cantidadAlumnos--;
                System.out.println("Alumno eliminado correctamente.");
            } else {
                System.out.println("Alumno no encontrado.");
            }
        } else {
            System.out.println("No hay alumnos para eliminar.");
        }
    }

    static void modificarAlumno() {
        if (cantidadAlumnos > 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese la cédula del alumno a modificar: ");
            String cedula = scanner.nextLine();

            int indiceModificar = -1;
            for (int i = 0; i < cantidadAlumnos; i++) {
                if (alumnos[i].cedula.equals(cedula)) {
                    indiceModificar = i;
                    break;
                }
            }

            if (indiceModificar != -1) {
                System.out.print("Nuevo nombre: ");
                alumnos[indiceModificar].nombre = scanner.nextLine();
                System.out.print("Nuevo apellido: ");
                alumnos[indiceModificar].apellido = scanner.nextLine();
                System.out.print("Nuevo semestre: ");
                alumnos[indiceModificar].semestre = scanner.nextInt();
                scanner.nextLine(); // Consumir la nueva línea pendiente
                System.out.print("Nuevo correo: ");
                alumnos[indiceModificar].correo = scanner.nextLine();
                System.out.print("Nuevo teléfono: ");
                alumnos[indiceModificar].telefono = scanner.nextLine();
                System.out.println("Alumno modificado correctamente.");
            } else {
                System.out.println("Alumno no encontrado.");
            }
        } else {
            System.out.println("No hay alumnos para modificar.");
        }
    }

    static void consultarAlumno() {
        if (cantidadAlumnos > 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese la cédula del alumno a consultar: ");
            String cedula = scanner.nextLine();

            for (int i = 0; i < cantidadAlumnos; i++) {
                if (alumnos[i].cedula.equals(cedula)) {
                    System.out.println("Nombre: " + alumnos[i].nombre);
                    System.out.println("Apellido: " + alumnos[i].apellido);
                    System.out.println("Semestre: " + alumnos[i].semestre);
                    System.out.println("Correo: " + alumnos[i].correo);
                    System.out.println("Teléfono: " + alumnos[i].telefono);
                    System.out.println("Cédula: " + alumnos[i].cedula);
                    return;
                }
            }

            System.out.println("Alumno no encontrado.");
        } else {
            System.out.println("No hay alumnos para consultar.");
        }
    }
}
    

