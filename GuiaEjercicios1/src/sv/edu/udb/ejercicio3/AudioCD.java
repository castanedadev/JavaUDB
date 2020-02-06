/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.ejercicio3;

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
        String padded = String.format("%05d", historicoUnidades);
        super.setCodigo("CDA" + padded);
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
        sb.append("\n       AudioCD [");
        sb.append(" titulo=").append(super.getTitulo());
        sb.append(", artista=").append(artista);
        sb.append(", genero=").append(super.getGenero());
        sb.append(", duracion=").append(super.getDuracion());
        sb.append(", numeroCanciones=").append(numeroCanciones);
        sb.append(", unidadesDisponibles=").append(super.getUnidadesDisponibles());
        sb.append(" ]");
        return sb.toString();
    }

}
