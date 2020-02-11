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
        sb.append("\n       DVD [");
        sb.append(" codigo=").append(super.getCodigo());
        sb.append(", titulo=").append(super.getTitulo());
        sb.append(", director=").append(this.getDirector());
        sb.append(", duracion=").append(this.getDuracion());
        sb.append(", genero=").append(this.getGenero());
        sb.append(", unidadesDisponibles=").append(super.getUnidadesDisponibles());
        sb.append(" ]");
        return sb.toString();
    }

    @Override
    public void mostrarMaterial() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== DVD ===");
        sb.append("\nCodigo : ").append(super.getCodigo());
        sb.append("\nTitulo : ").append(super.getTitulo());
        sb.append("\nDirector : ").append(this.getDirector());
        sb.append("\nDuración : ").append(super.getDuracion());
        sb.append("\nGénero : ").append(super.getGenero());
        sb.append("\nUnidades Disponibles : ").append(super.getUnidadesDisponibles());

        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
