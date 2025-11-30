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
public class NodoBST {
    
    public Estudiante estudiante;
    NodoBST izquierda;
    NodoBST derecha;

    public NodoBST(Estudiante estudiante, NodoBST izquierda, NodoBST derecha) {
        this.estudiante = estudiante;
        this.izquierda = izquierda;
        this.derecha = derecha;
    }

    NodoBST(Estudiante nuevoEstudiante) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
}
