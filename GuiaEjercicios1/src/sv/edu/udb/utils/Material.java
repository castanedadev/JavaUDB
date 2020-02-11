/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.utils;

/**
 *
 * @author rickc
 */
public enum Material {
    AUDIOVISUAL("Material AudioVisual"),
    ESCRITO("Material Escrito"),
    LIBRO("Libro"),
    REVISTA("Revista"),
    CD("CD"),
    DVD("DVD");

    private Material(String descripcion) {
        this.descripcion = descripcion;
    }

    private String descripcion;

    public String getDescripcion() {
        return descripcion;
    }

}
