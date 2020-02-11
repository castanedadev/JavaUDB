/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.ejercicio3;

import java.util.Calendar;
import javax.swing.JOptionPane;
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
        super.setCodigo(generarCodigo());
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
        sb.append("\n       Revista [")
                .append(" codigo=")
                .append(super.getCodigo())
                .append(", titulo=")
                .append(super.getTitulo())
                .append(", editorial=")
                .append(super.getEditorial())
                .append(", periodicidad=")
                .append(this.getPeriodicidad())
                .append(", anoPublicacion=")
                .append(super.getFechaPublicacion().get(Calendar.MONTH) + 1)
                .append("/")
                .append(super.getFechaPublicacion().get(Calendar.DATE))
                .append("/")
                .append(super.getFechaPublicacion().get(Calendar.YEAR))
                .append(", unidadesDisponibles=")
                .append(super.getUnidadesDisponibles())
                .append(" ]");
        return sb.toString();
    }

    @Override
    public final String generarCodigo() {
        String padded = String.format("%05d", historicoUnidades);
        return ("REV" + padded);
    }

    @Override
    public void mostrarMaterial() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Revista ===")
                .append("\nCodigo : ")
                .append(super.getCodigo())
                .append("\nTitulo : ")
                .append(super.getTitulo())
                .append("\nEditorial : ")
                .append(super.getEditorial())
                .append("\nPeriodicidad : ")
                .append(this.getPeriodicidad())
                .append("\n Fecha de Publicacion : ")
                .append(super.getFechaPublicacion().get(Calendar.MONTH) + 1)
                .append("/")
                .append(super.getFechaPublicacion().get(Calendar.DATE))
                .append("/")
                .append(super.getFechaPublicacion().get(Calendar.YEAR))
                .append("\nUnidades Disponibles : ")
                .append(super.getUnidadesDisponibles())
                .append("");

        JOptionPane.showMessageDialog(null, sb.toString());
    }

}
