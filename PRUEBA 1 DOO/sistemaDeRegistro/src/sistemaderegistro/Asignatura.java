/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaderegistro;

/**
 *
 * @author Duoc
 */
public class Asignatura {
    private String nombre;
    private int codigo;
    private double nota1,nota2,nota3;

    public Asignatura(String nombre, int codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public Asignatura(double nota1, double nota2, double nota3) {
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double getNota3() {
        return nota3;
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }
    public double calcularNotaPresentacion() {
        return (nota1 * 0.40) + (nota2 * 0.40) + (nota3 * 0.20);
    }

    public boolean estaEximido() {
        return calcularNotaPresentacion() >= 5.5;
    }

    public String calcularNotaFinal(double notaExamen) {
        double notaPresentacion = calcularNotaPresentacion();
        double notaFinal = (notaPresentacion * 0.70) + (notaExamen * 0.30);

        if (notaFinal >= 4.5) {
            return String.format("Nota final: %.2f → APROBADO", notaFinal);
        } else {
            return String.format("Nota final: %.2f → REPROBADO", notaFinal);
        }
    }

    @Override
    public String toString() {
        return nombre + " (Código: " + codigo + ")";
    }
}
