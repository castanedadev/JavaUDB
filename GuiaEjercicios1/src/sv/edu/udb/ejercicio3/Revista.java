/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.ejercicio3;

import java.util.Calendar;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rickc
 */
@XmlRootElement(name = "Revista")
public class Revista extends MaterialEscrito {

    private int periodicidad;
    public static int historicoUnidades = 0;

    public Revista() {
        historicoUnidades++;
        String padded = String.format("%05d", historicoUnidades);
        super.setCodigo("REV" + padded);
    }

    @XmlElement
    public int getPeriodicidad() {
        return periodicidad;
    }

    public void setPeriodicidad(int periodicidad) {
        this.periodicidad = periodicidad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n       Revista [");
        sb.append(" codigo=").append(super.getCodigo());
        sb.append(", titulo=").append(super.getTitulo());
        sb.append(", editorial=").append(super.getEditorial());
        sb.append(", periodicidad=").append(this.periodicidad);
        sb.append(", anoPublicacion=");
        sb.append(super.getFechaPublicacion().get(Calendar.MONTH) + 1);
        sb.append("/");
        sb.append(super.getFechaPublicacion().get(Calendar.DATE));
        sb.append("/");
        sb.append(super.getFechaPublicacion().get(Calendar.YEAR));
        sb.append(", unidadesDisponibles=").append(super.getUnidadesDisponibles());
        sb.append(" ]");
        return sb.toString();
    }

}
