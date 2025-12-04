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
public class ListaEnlazadaSimple {
    private NodoLista cabeza; 

    public ListaEnlazadaSimple() {
        this.cabeza = null;
    }

    public void agregar(Estudiante estudiante) {
        NodoLista nuevoNodo = new NodoLista(estudiante);

        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            NodoLista actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
    }

    public void listar() {
        if (cabeza == null) {
            System.out.println("No hay alumnos inscritos");
            return;
        }

        NodoLista actual = cabeza;
        while (actual != null) {
            System.out.println("   -> " + actual.estudiante.toString());
            actual = actual.siguiente;
        }
    }
    
    public boolean existe(int matricula) {
        NodoLista actual = cabeza;
        while (actual != null) {
            if (actual.estudiante.getMatricula() == matricula) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }
}
