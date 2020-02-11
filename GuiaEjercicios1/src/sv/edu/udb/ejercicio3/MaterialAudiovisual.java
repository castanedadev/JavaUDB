/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.ejercicio3;

/**
 *
 * @author rickc
 */
public abstract class MaterialAudiovisual extends Material {

    public abstract String generarCodigo();

    public abstract void mostrarMaterial();
    
    private String genero;
    private int duracion;

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
}
