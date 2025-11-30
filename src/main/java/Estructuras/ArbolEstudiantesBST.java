/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import Modelo.Estudiante;

/**
 *
 * @author Gael
 */
public class ArbolEstudiantesBST {
    NodoBST raiz;

    public ArbolEstudiantesBST() {
        this.raiz = null;
    }

    // 1. MÉTODO PÚBLICO: El que llamarás desde el Main
    public void insertar(Estudiante nuevoEstudiante) {
        this.raiz = insertarRecursivo(this.raiz, nuevoEstudiante);
    }

    
    private NodoBST insertarRecursivo(NodoBST actual, Estudiante nuevoEstudiante) {
        
        if (actual == null) {
            return new NodoBST(nuevoEstudiante);
        }
 
        if (nuevoEstudiante.matricula < actual.estudiante.matricula) {
            actual.izquierda = insertarRecursivo(actual.izquierda, nuevoEstudiante);
        } else if (nuevoEstudiante.matricula > actual.estudiante.matricula) {
            actual.derecha = insertarRecursivo(actual.derecha, nuevoEstudiante);
        } else {
            System.out.println("Error: La matrícula " + nuevoEstudiante.matricula + " ya existe.");
        }

        return actual; 
    }
}