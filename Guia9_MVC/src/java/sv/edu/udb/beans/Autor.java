/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.beans;

/**
 *
 * @author Rick
 */
public class Autor {
    private String codigoAutor;
    private String nombreAutor;
    private String nacionalidad;
    
    public Autor() {
        
    }

    public Autor(String codigoAutor, String nombreAutor, String nacionalidad) {
        this.codigoAutor = codigoAutor;
        this.nombreAutor = nombreAutor;
        this.nacionalidad = nacionalidad;
    }

    public String getCodigoAutor() {
        return codigoAutor;
    }

    public Autor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public void setCodigoAutor(String codigoAutor) {
        this.codigoAutor = codigoAutor;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

}
