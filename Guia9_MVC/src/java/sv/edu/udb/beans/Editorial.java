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
public class Editorial {
    private String codigoEditorial;
    private String nombreEditorial;
    private String contacto;
    private String telefono;

    public Editorial() {
    }

    public Editorial(String nombreEditorial) {
        this.nombreEditorial = nombreEditorial;
    }   

    public String getCodigoEditorial() {
        return codigoEditorial;
    }

    public void setCodigoEditorial(String codigoEditorial) {
        this.codigoEditorial = codigoEditorial;
    }

    public String getNombreEditorial() {
        return nombreEditorial;
    }

    public void setNombreEditorial(String nombreEditorial) {
        this.nombreEditorial = nombreEditorial;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
}
