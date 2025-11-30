/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Gael
 */
public class Calificacion {
 
    private Curso curso;
    private double nota;
    
    public Calificacion(Curso curso, double nota){
    
        this.curso = curso;
        this.nota = nota;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Calificacion{" + "curso=" + curso + ", nota=" + nota + '}';
    }
    
}
