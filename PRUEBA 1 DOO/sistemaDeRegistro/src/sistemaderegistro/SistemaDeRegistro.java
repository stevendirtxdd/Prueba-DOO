/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemaderegistro;

import java.util.Scanner;

/**
 *
 * @author Duoc
 */
public class SistemaDeRegistro {
    static Alumno[] alumnos = new Alumno[100];
    static Docente[] docentes = new Docente[50];
    static Asignatura[] asignaturas = new Asignatura[100];
    static int contadorAlumnos = 0;
    static int contadorDocentes = 0;
    static int contadorAsignaturas = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.print("""
                             === SISTEMA DE REGISTRO DE ASIGNATURAS ===
                             1. Ingresar Estudiante
                             2. Ingresar Docente
                             3. Ingresar Asignatura
                             4. Calcular Resultados
                             5. Mostrar Notas
                             6. Ver notas
                             7. Buscar estudiante
                             8. Salir
                             Seleccione una opcion: """);

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> ingresarEstudiante(sc);
                case 2 -> ingresarDocente(sc);
                case 3 -> ingresarAsignatura(sc);
                case 4 -> calcularResultados(sc);
                case 6 ->mostrarNotas() ;
                case 7 -> buscarEstudiante();
                case 8 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción inválida. Intente nuevamente.");
            }

            System.out.println();
        } while (opcion != 8);
    }

    
    
    static void ingresarEstudiante(Scanner sc) {
        if (contadorAlumnos >= alumnos.length) {
            System.out.println("No se pueden agregar más estudiantes.");
            return;
        }
        System.out.println("--- INGRESO DE ESTUDIANTE ---");
        System.out.print("Ingrese RUT del estudiante: ");
        String rut = sc.nextLine();
        if (rut.isEmpty()) {
            System.out.println("El RUT no puede estar vacío.");
            return;
        }
        System.out.print("Ingrese nombre del estudiante: ");
        String nombre = sc.nextLine();
        if (nombre.isEmpty()) {
            System.out.println("El nombre no puede estar vacio.");
            return;
        }
        System.out.print("Ingrese fecha de nacimiento (AAAA-MM-DD): ");
        String fechaNacimiento = sc.nextLine();
        if (fechaNacimiento.isEmpty()) {
            System.out.println("La fecha de nacimiento no puede estar vacio.");
            return;
        }
        System.out.print("Ingrese edad del estudiante: ");
        int edad = sc.nextInt();
        sc.nextLine();

        if (edad < 18 || edad >= 100) {
            System.out.println("Edad invalida.");
            return;
        }

        alumnos[contadorAlumnos++] = new Alumno(rut, nombre, fechaNacimiento, edad);
        System.out.println("Estudiante registrado: " + alumnos[contadorAlumnos - 1]);
    }

    
    
    static void ingresarDocente(Scanner sc) {
        if (contadorDocentes >= docentes.length) {
            System.out.println("No se pueden agregar mas docentes.");
            return;
        }

        System.out.println("--- INGRESO DE DOCENTE ---");
        System.out.print("Ingrese RUT del docente: ");
        String rut = sc.nextLine();
        if (rut.isEmpty()) {
            System.out.println("El RUT no puede estar vacío.");
            return;
        }
        System.out.print("Ingrese numero de docente: ");
        int numeroDocente = sc.nextInt();
        sc.nextLine();
        System.out.print("Ingrese nombre del docente: ");
        String nombre = sc.nextLine();
        if (nombre.isEmpty()) {
            System.out.println("El nombre no puede estar vacío.");
            return;
        }
        System.out.print("Ingrese fecha de ingreso (AAAA-MM-DD): ");
        String fechaIngreso = sc.nextLine();
        System.out.print("Ingrese sede del profesor: ");
        String sede = sc.nextLine();

        docentes[contadorDocentes++] = new Docente(rut, numeroDocente, nombre, fechaIngreso, sede);
        System.out.println("Docente registrado: " + docentes[contadorDocentes - 1]);
    }

    
   static void ingresarAsignatura(Scanner sc) {
        if (contadorAsignaturas >= asignaturas.length) {
            System.out.println("No se pueden agregar más asignaturas.");
            return;
        }
        if (contadorAlumnos == 0 || contadorDocentes == 0) {
            System.out.println("Debe ingresar al menos un estudiante y un docente primero.");
            return;
        }

        System.out.println("--- INGRESO DE ASIGNATURA ---");
        System.out.print("Ingrese nombre de la asignatura: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese código de la asignatura (numero): ");
        int codigo = sc.nextInt();
        sc.nextLine();

        System.out.print("Ingrese nota1: ");
        double n1 = sc.nextDouble();
        System.out.print("Ingrese nota2: ");
        double n2 = sc.nextDouble();
        System.out.print("Ingrese nota3: ");
        double n3 = sc.nextDouble();
        sc.nextLine();

        Asignatura asignatura = new Asignatura(nombre, codigo);
        asignatura.setNota1(n1);
        asignatura.setNota2(n2);
        asignatura.setNota3(n3);

        asignaturas[contadorAsignaturas++] = asignatura;
        System.out.println("Asignatura registrada: " + asignatura.getNombre());
    } 
    static void mostrarNotas(Scanner sc) {
    if (contadorAsignaturas == 0) {
        System.out.println("No hay asignaturas registradas.");
        return;
    }

    System.out.println("--- LECTURA DE NOTAS INGRESADAS ---");
    // Aquí mostramos todas las asignaturas y sus notas
    for (int i = 0; i < contadorAsignaturas; i++) {
        Asignatura asignatura = asignaturas[i];
        System.out.println("Asignatura: " + asignatura.getNombre());
        System.out.println("Nota 1: " + asignatura.getNota1() + " Nota 2: " + asignatura.getNota2() + " Nota 3: " + asignatura.getNota3());
    }
}
    static void buscarEstudiante(Scanner sc) {
        if (contadorAlumnos == 0) {
            System.out.println("No hay alumnos registrados.");
            return;
        }

        System.out.println("--- BUSCAR ALUMNO ---");
        System.out.print("Ingrese el nombre o código del alumno: ");
        String input = sc.nextLine();

        // Buscamos el alumno por nombre o código
        boolean encontrado = false;
        for (int i = 0; i < contadorAlumnos; i++) {
            Alumno alumno = alumnos[i];
            // Comprobamos si el input coincide con el nombre o el código del alumno
            if (alumno.getNombre().equalsIgnoreCase(input) || String.valueOf(alumno.getCodigo()).equals(input)) {
                alumno.mostrarInformacion();
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Alumno no encontrado.");
        }
    }
    
    
    static void calcularResultados(Scanner sc) {
        if (contadorAsignaturas == 0) {
            System.out.println("No hay asignaturas registradas.");
            return;
        }

        for (int i = 0; i < contadorAsignaturas; i++) {
            Asignatura a = asignaturas[i];
            double presentacion = a.calcularNotaPresentacion();
            System.out.println("\nAsignatura: " + a.getNombre());
            System.out.printf("Nota de presentacion: %.2f\n", presentacion);

            if (a.estaEximido()) {
                System.out.println("Estado: EXIMIDO");
            } else {
                System.out.print("Ingrese nota de examen: ");
                double examen = sc.nextDouble();
                sc.nextLine();
                System.out.println(a.calcularNotaFinal(examen));
            }
        }
    }

    private static void buscarEstudiante() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void mostrarNotas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}