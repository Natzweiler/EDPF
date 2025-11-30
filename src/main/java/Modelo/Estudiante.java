/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Gael
 */
public class Estudiante {
    
    public String nombre;
    public int matricula;
    public int telefono;
    public int email;
    public int domicilio;
    

    public Estudiante(String nombre, int matricula, int telefono, int email, int domicilio) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.telefono = telefono;
        this.email = email;
        this.domicilio = domicilio;
    }

    public Estudiante() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
   

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getEmail() {
        return email;
    }

    public void setEmail(int email) {
        this.email = email;
    }

    public int getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(int domicilio) {
        this.domicilio = domicilio;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "nombre=" + nombre + ", matricula=" + matricula + ", telefono=" + telefono + ", email=" + email + ", domicilio=" + domicilio + '}';
    }
    
    
    
    
}
