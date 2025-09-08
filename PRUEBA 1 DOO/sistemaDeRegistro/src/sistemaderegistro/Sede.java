/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaderegistro;

/**
 *
 * @author Duoc
 */
public class Sede {
    private String nombre;
    private String comuna;
    private int numero;

    public Sede(String nombre, String comuna, int numero) {
        this.nombre = nombre;
        this.comuna = comuna;
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Sede{" + "nombre=" + nombre + ", numero=" + numero + '}';
    }
    
    
    
}
