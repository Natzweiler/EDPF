/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author Gael
 */
public class NodoPila {
    String accion;     
    NodoPila siguiente; 

    public NodoPila(String accion) {
        this.accion = accion;
        this.siguiente = null;
    }
}
