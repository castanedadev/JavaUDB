/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.complementarios;

/**
 *
 * @author rickc
 */
public class Estudiante {

    private String nombres;
    private String apellidos;
    private String edad;
    private float examen1;
    private float examen2;
    private float examen3;
    private float notaPromedio;

    /**
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the edad
     */
    public String getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(String edad) {
        this.edad = edad;
    }

    /**
     * @return the examen1
     */
    public float getExamen1() {
        return examen1;
    }

    /**
     * @param examen1 the examen1 to set
     */
    public void setExamen1(float examen1) {
        this.examen1 = examen1;
    }

    /**
     * @return the examen2
     */
    public float getExamen2() {
        return examen2;
    }

    /**
     * @param examen2 the examen2 to set
     */
    public void setExamen2(float examen2) {
        this.examen2 = examen2;
    }

    /**
     * @return the examen3
     */
    public float getExamen3() {
        return examen3;
    }

    /**
     * @param examen3 the examen3 to set
     */
    public void setExamen3(float examen3) {
        this.examen3 = examen3;
    }

    /**
     * @return the notaPromedio
     */
    public float getNotaPromedio() {
        return (this.examen1 + this.examen2 + this.examen3) / 3;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n  Nombres => ").append(nombres);
        sb.append("\n  Apellidos => ").append(apellidos);
        sb.append("\n  Edad => ").append(edad);
        sb.append("\n  Examen1 => ").append(examen1);
        sb.append("\n  Examen2 => ").append(examen2);
        sb.append("\n  Examen3 => ").append(examen3);
        sb.append("\n\n  Nota Promedio => ").append(getNotaPromedio());
        return sb.toString();
    }

}
