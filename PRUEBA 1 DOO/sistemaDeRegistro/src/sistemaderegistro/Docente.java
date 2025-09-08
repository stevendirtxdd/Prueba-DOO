/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaderegistro;

/**
 *
 * @author Duoc
 */
public class Docente {
    private String nombre;
    private String rut;
    private String fechaIngreso;
    private String sede;
    private int numeroDocente;
    public Docente(String nombre, int numeroDocente1, String rut, String fechaIngreso, String sede) {
        this.nombre = nombre;
        this.rut = rut;
        this.fechaIngreso = fechaIngreso;
        this.sede = sede;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    @Override
    public String toString() {
        return "Docente{" + "nombre=" + nombre + ", rut=" + rut + ", fechaIngreso=" + fechaIngreso + ", sede=" + sede + '}';
    }
    
    
}
