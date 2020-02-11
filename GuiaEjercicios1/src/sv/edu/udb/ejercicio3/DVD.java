/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.ejercicio3;

import javax.swing.JOptionPane;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author rickc
 */
public class DVD extends MaterialAudiovisual {

    private String director;
    public static int historicoUnidades = 0;

    public DVD() {
        historicoUnidades++;
        super.setCodigo(generarCodigo());
    }

    @XmlElement
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public final String generarCodigo() {
        String padded = String.format("%05d", historicoUnidades);
        return ("DVD" + padded);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n       DVD [")
                .append(" codigo=")
                .append(super.getCodigo())
                .append(", titulo=")
                .append(super.getTitulo())
                .append(", director=")
                .append(this.getDirector())
                .append(", duracion=")
                .append(this.getDuracion())
                .append(", genero=")
                .append(this.getGenero())
                .append(", unidadesDisponibles=")
                .append(super.getUnidadesDisponibles())
                .append(" ]");
        return sb.toString();
    }

    @Override
    public void mostrarMaterial() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== DVD ===")
                .append("\nCodigo : ")
                .append(super.getCodigo())
                .append("\nTitulo : ")
                .append(super.getTitulo())
                .append("\nDirector : ")
                .append(this.getDirector())
                .append("\nDuración : ")
                .append(super.getDuracion())
                .append(" minutos")
                .append("\nGénero : ")
                .append(super.getGenero())
                .append("\nUnidades Disponibles : ")
                .append(super.getUnidadesDisponibles());

        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
