/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author Gael
 */
public class Pila {
    private NodoPila tope; 
    private int tamano;

    public Pila() {
        this.tope = null;
        this.tamano = 0;
    }

    public void push(String accion) {
        NodoPila nuevoNodo = new NodoPila(accion);
        
        if (tope == null) {
            tope = nuevoNodo;
        } else {
            nuevoNodo.siguiente = tope;
            tope = nuevoNodo;
        }
        tamano++;
    }

    public void mostrarHistorial() {
        if (tope == null) {
            System.out.println("   (El historial está vacío)");
            return;
        }

        System.out.println("--- Historial ---");
        NodoPila actual = tope;
        while (actual != null) {
            System.out.println(" -> " + actual.accion);
            actual = actual.siguiente;
        }
    }
}
