/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.ejercicio3;

import java.util.Calendar;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author rickc
 */
public class MaterialEscrito extends Material {

    private String editorial;
    private Calendar fechaPublicacion;

    @XmlElement
    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    @XmlElement
    public Calendar getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Calendar fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
}
