/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Estructuras.ListaEnlazadaSimple;

/**
 *
 * @author Gael
 */
public class Curso {
    
    private String nombre;
    private String codigo;
    private ListaEnlazadaSimple inscritos;
    
    public Curso(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.inscritos = new ListaEnlazadaSimple();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public ListaEnlazadaSimple getInscritos() {
        return inscritos;
    }

    public void setInscritos(ListaEnlazadaSimple inscritos) {
        this.inscritos = inscritos;
    }
 
    public void inscribirEstudiante(Estudiante e) {
        if (!inscritos.existe(e.getMatricula())) {
            inscritos.agregar(e);
            System.out.println("" + e.nombre + " inscrito en " + this.nombre);
        } else {
            System.out.println("" + e.nombre + " ya estaba inscrito en " + this.nombre);
        }
    }

    @Override
    public String toString() {
        return "Curso{" + "nombre=" + nombre + ", codigo=" + codigo + ", inscritos=" + inscritos + '}';
    }
    

    

    
}
