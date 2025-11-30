/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Main;

import Estructuras.ArbolEstudiantesBST;
import Estructuras.ArregloDinamico;
import Estructuras.Pila;
import Modelo.Curso;
import Modelo.Estudiante;
import java.util.Scanner;

/**
 *
 * @author Gael
 */
public class EDPF {

    static ArbolEstudiantesBST arbol = new ArbolEstudiantesBST();
    static ArregloDinamico<Curso> listaCursos = new ArregloDinamico<>(); 
    static Pila historial = new Pila();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = 0;
        precargarDatos();

        do {
            System.out.println("\n========================================");
            System.out.println("      SISTEMA DE GESTIÓN ESCOLAR");
            System.out.println("========================================");
            System.out.println("1. GESTIÓN DE ESTUDIANTES");
            System.out.println("   1.1 Registrar estudiante");
            System.out.println("   1.2 Buscar estudiante");
            System.out.println("   1.3 Listar estudiantes (Ordenado)");
            System.out.println("2. GESTIÓN DE CURSOS");
            System.out.println("   2.1 Agregar curso");
            System.out.println("   2.2 Listar cursos");
            System.out.println("3. INSCRIPCIONES");
            System.out.println("   3.1 Inscribir estudiante");
            System.out.println("   3.2 Ver inscritos por curso");
            System.out.println("4. CALIFICACIONES");
            System.out.println("   4.1 Asignar calificación");
            System.out.println("   4.2 Ver boleta de estudiante");
            System.out.println("5. HISTORIAL");
            System.out.println("   5.1 Ver historial de acciones");
            System.out.println("6. SALIR");
            System.out.print("\nSeleccione una opción: ");
            
            try {
                String input = sc.nextLine();
                if(input.contains(".")) {
                   opcion = Integer.parseInt(input.split("\\.")[0]);
                } else {
                   opcion = Integer.parseInt(input);
                }
                
                switch (opcion) {
                    case 1: menuEstudiantes(); break;
                    case 2: menuCursos(); break;
                    case 3: menuInscripciones(); break;
                    case 4: menuCalificaciones(); break;
                    case 5: 
                        historial.mostrarHistorial(); 
                        break;
                    case 6: 
                        System.out.println("Saliendo del sistema..."); 
                        break;
                    default: 
                        System.out.println("Opción no válida.");
                }

            } catch (Exception e) {
                System.out.println("Error: Ingrese un número válido. (" + e.getMessage() + ")");
            }

        } while (opcion != 6);
    }

    public static void menuEstudiantes() {
        System.out.println("\n--- ESTUDIANTES ---");
        System.out.println("1. Registrar");
        System.out.println("2. Buscar");
        System.out.println("3. Listar");
        System.out.print("Opción: ");
        int op = Integer.parseInt(sc.nextLine());

        switch (op) {
            case 1: 
                System.out.print("Matrícula (Números): ");
                int mat = Integer.parseInt(sc.nextLine());
                System.out.print("Nombre completo: ");
                String nom = sc.nextLine();
                System.out.print("Teléfono: ");
                String tel = sc.nextLine();
                System.out.print("Email: ");
                String email = sc.nextLine();
                System.out.print("Domicilio: ");
                String dom = sc.nextLine();

                Estudiante nuevo = new Estudiante(nom, mat, tel, email, dom);
                arbol.insertar(nuevo);
                historial.push("Registro: Estudiante " + mat + " (" + nom + ")");
                System.out.println("¡Estudiante registrado con éxito!");
                break;

            case 2: 
                System.out.print("Ingrese matrícula a buscar: ");
                int buscaMat = Integer.parseInt(sc.nextLine());
                Estudiante encontrado = arbol.buscar(buscaMat);
                if (encontrado != null) {
                    System.out.println("--- DATOS ENCONTRADOS ---");
                    System.out.println(encontrado.toString());
                } else {
                    System.out.println("No se encontró estudiante con esa matrícula.");
                }
                break;

            case 3: 
                System.out.println("--- LISTA DE ESTUDIANTES (Ordenada por Matrícula) ---");
                arbol.listarInOrder();
                break;
        }
    }

    public static void menuCursos() {
        System.out.println("\n--- CURSOS ---");
        System.out.println("1. Agregar Curso");
        System.out.println("2. Listar Cursos");
        System.out.print("Opción: ");
        int op = Integer.parseInt(sc.nextLine());

        if (op == 1) {
            System.out.print("Código del curso (ej. MAT101): ");
            String cod = sc.nextLine();
            System.out.print("Nombre de la materia: ");
            String nom = sc.nextLine();
            
            Curso nuevoCurso = new Curso(cod, nom);
            listaCursos.agregar(nuevoCurso);
            historial.push("Curso creado: " + cod + " - " + nom);
            System.out.println("Curso agregado.");
        } else if (op == 2) {
            System.out.println("--- CURSOS DISPONIBLES ---");
            for(int i=0; i<listaCursos.tamano(); i++) {
                System.out.println(listaCursos.obtener(i).toString());
            }
        }
    }

    public static void menuInscripciones() {
        System.out.println("\n--- INSCRIPCIONES ---");
        System.out.println("1. Inscribir alumno");
        System.out.println("2. Ver lista de un curso");
        System.out.print("Opción: ");
        int op = Integer.parseInt(sc.nextLine());

        System.out.print("Ingrese el CÓDIGO del curso: ");
        String codigo = sc.nextLine();
        Curso cursoSeleccionado = buscarCursoPorCodigo(codigo);

        if (cursoSeleccionado == null) {
            System.out.println("Error: Curso no encontrado.");
            return;
        }

        if (op == 1) {
            System.out.print("Ingrese MATRÍCULA del estudiante: ");
            int mat = Integer.parseInt(sc.nextLine());
            Estudiante est = arbol.buscar(mat);

            if (est != null) {
                cursoSeleccionado.inscribirEstudiante(est);
                historial.push("Inscripción: " + mat + " en " + codigo);
            } else {
                System.out.println("Error: Estudiante no encontrado.");
            }
        } else if (op == 2) {
            cursoSeleccionado.getInscritos();
        }
    }

    public static void menuCalificaciones() {
        System.out.println("\n--- CALIFICACIONES ---");
        System.out.println("1. Asignar nota");
        System.out.println("2. Ver boleta de alumno");
        System.out.print("Opción: ");
        int op = Integer.parseInt(sc.nextLine());

        System.out.print("Ingrese MATRÍCULA del estudiante: ");
        int mat = Integer.parseInt(sc.nextLine());
        Estudiante est = arbol.buscar(mat);

        if (est == null) {
            System.out.println("Estudiante no encontrado.");
            return;
        }

        if (op == 1) {
            System.out.print("Ingrese CÓDIGO del curso a calificar: ");
            String codigo = sc.nextLine();
            Curso curso = buscarCursoPorCodigo(codigo);

            if (curso != null) {
                System.out.print("Ingrese la Calificación (ej. 9.5): ");
                double nota = Double.parseDouble(sc.nextLine());
                est.agregarCalificacion(curso, nota);
                historial.push("Calif: " + nota + " a " + est.getNombre() + " en " + codigo);
                System.out.println("Calificación registrada.");
            } else {
                System.out.println("Curso no encontrado.");
            }
        } else if (op == 2) {
            est.mostrarBoleta();
        }
    }

    public static Curso buscarCursoPorCodigo(String codigo) {
        for (int i = 0; i < listaCursos.tamano(); i++) {
            Curso c = listaCursos.obtener(i); 
            if (c.getCodigo().equalsIgnoreCase(codigo)) {
                return c;
            }
        }
        return null;
    }

    public static void precargarDatos() {
        
        Estudiante e1 = new Estudiante("Juan Perez", 253001, "6441001122", "juan@test.com", "Calle 1");
        Estudiante e2 = new Estudiante("Ana Lopez", 200100, "6442003344", "ana@test.com", "Calle 2");
        arbol.insertar(e1);
        arbol.insertar(e2);

        Curso c1 = new Curso("MAT1", "Calculo I");
        Curso c2 = new Curso("PROG1", "Programacion");
        listaCursos.agregar(c1);
        listaCursos.agregar(c2);
        
        
    }
}