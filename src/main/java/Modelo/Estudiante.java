/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Estructuras.ArregloDinamico;

/**
 *
 * @author Gael
 */
public class Estudiante {
    
    public String nombre;
    public int matricula;
    public String telefono;
    public String email;
    public String domicilio;
    private ArregloDinamico calificaciones;

    public Estudiante(String nombre, int matricula, String telefono, String email, String domicilio) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.telefono = telefono;
        this.email = email;
        this.domicilio = domicilio;
        this.calificaciones = new ArregloDinamico();
    }
    
    public Estudiante() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
    
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "nombre=" + nombre + ", matricula=" + matricula + ", telefono=" + telefono + ", email=" + email + ", domicilio=" + domicilio + '}';
    }
    
    public void agregarCalificacion(Curso curso, double nota) {
    Calificacion nuevaCalif = new Calificacion(curso, nota);
    calificaciones.agregar(nuevaCalif);
    
    }


    public double obtenerPromedio() {
         if (calificaciones.tamano() == 0) return 0.0;
         double suma = 0;
         for (int i = 0; i < calificaciones.tamano(); i++) {
        
         Calificacion c = (Calificacion) calificaciones.obtener(i);
         suma += c.getNota();
        }
        return suma / calificaciones.tamano();
    }


    public void mostrarBoleta() {
        
        System.out.println("Boleta de " + this.nombre + ":");
        for (int i = 0; i < calificaciones.tamano(); i++) {
        System.out.println("   - " + calificaciones.obtener(i).toString());
        }
        System.out.println("   > Promedio General: " + obtenerPromedio());
    }
    
    
}
