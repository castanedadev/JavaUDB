/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.ejercicio3;

import javax.swing.JOptionPane;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rickc
 */
@XmlRootElement(name = "AudioCD")
public class AudioCD extends MaterialAudiovisual {

    private String artista;
    private int numeroCanciones;
    public static int historicoUnidades = 0;

    public AudioCD() {
        historicoUnidades++;
        super.setCodigo(generarCodigo());
    }

    @XmlElement
    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    @XmlElement
    public int getNumeroCanciones() {
        return numeroCanciones;
    }

    public void setNumeroCanciones(int numeroCanciones) {
        this.numeroCanciones = numeroCanciones;
    }

    //título, artista, género, duración, número de canciones y unidades disponibles. - 
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n       AudioCD [")
                .append(" Codigo : ")
                .append(super.getCodigo())
                .append(", titulo=")
                .append(super.getTitulo())
                .append(", artista=")
                .append(this.getArtista())
                .append(", genero=")
                .append(super.getGenero())
                .append(", duracion=")
                .append(super.getDuracion())
                .append(", numeroCanciones=")
                .append(this.getNumeroCanciones())
                .append(", unidadesDisponibles=")
                .append(super.getUnidadesDisponibles())
                .append(" ]");
        return sb.toString();
    }

    @Override
    public final String generarCodigo() {        
        String padded = String.format("%05d", historicoUnidades);
        return ("CDA" + padded);
    }

    @Override
    public void mostrarMaterial() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== AudioCD ===")
                .append("\nCodigo : ")
                .append(super.getCodigo())
                .append("\nTitulo : ")
                .append(super.getTitulo())
                .append("\nArtista : ")
                .append(artista)
                .append("\nGénero : ")
                .append(super.getGenero())
                .append("\nDuración : ")
                .append(super.getDuracion())
                .append("\nNúmero de Canciones : ")
                .append(numeroCanciones)
                .append("\nUnidades Disponibles : ")
                .append(super.getUnidadesDisponibles());

        JOptionPane.showMessageDialog(null, sb.toString());
    }

}
