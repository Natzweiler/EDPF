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
    
    public void listarInOrder() {
        listarInOrderRecursivo(this.raiz);
        System.out.println(); 
    }

    private void listarInOrderRecursivo(NodoBST actual) {
        
        if (actual == null) {
            return;
        }
        listarInOrderRecursivo(actual.izquierda);
        System.out.println(actual.estudiante.toString());
        listarInOrderRecursivo(actual.derecha);
    }

    public Estudiante buscar(int matricula) {
        return buscarRecursivo(this.raiz, matricula);
    }

    private Estudiante buscarRecursivo(NodoBST actual, int matriculaBuscada) {
       
        if (actual == null) {
            return null; 
        }

        if (matriculaBuscada == actual.estudiante.getMatricula()) {
            return actual.estudiante;
        }

        if (matriculaBuscada < actual.estudiante.getMatricula()) {
            return buscarRecursivo(actual.izquierda, matriculaBuscada);
        } else {
            return buscarRecursivo(actual.derecha, matriculaBuscada);
        }
    }
}