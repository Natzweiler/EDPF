/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author Gael
 */
public class ArregloDinamico<T> {
    
    private T[] datos;      
    private int contador;
    private int capacidad;

    public ArregloDinamico() {
        this.capacidad = 5;
        this.contador = 0;
        this.datos = (T[]) new Object[capacidad]; 
    }

    public void agregar(T elemento) {
        if (contador == capacidad) {
            crecer();
        }
        datos[contador] = elemento;
        contador++;
    }

    private void crecer() {
        int nuevaCapacidad = capacidad * 2;
        T[] nuevosDatos = (T[]) new Object[nuevaCapacidad];

        for (int i = 0; i < contador; i++) {
            nuevosDatos[i] = datos[i];
        }

        datos = nuevosDatos;
        capacidad = nuevaCapacidad;
    }

    public T obtener(int indice) {
        if (indice < 0 || indice >= contador) {
            return null;
        }
        return datos[indice];
    }
    
    public int tamano() {
        return contador;
    }
}
