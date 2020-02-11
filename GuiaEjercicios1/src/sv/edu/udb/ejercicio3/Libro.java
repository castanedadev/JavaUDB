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
@XmlRootElement(name = "Libro")
public class Libro extends MaterialEscrito {

    private String autor;
    private int numeroPaginas;
    private String isbn;

    public static int historicoUnidades = 0;

    public Libro() {
        historicoUnidades++;
        super.setCodigo(generarCodigo());
    }

    @XmlElement
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @XmlElement
    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    @XmlElement
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n       Libro [")
                .append(" codigo=")
                .append(super.getCodigo())
                .append(",  autor=")
                .append(this.getAutor())
                .append(", titulo=")
                .append(super.getTitulo())
                .append(", autor=")
                .append(this.getAutor())
                .append(", unidadesDisponibles=")
                .append(super.getUnidadesDisponibles())
                .append(", numeroPaginas=")
                .append(this.getNumeroPaginas())
                .append(", editorial=")
                .append(super.getEditorial())
                .append(", isbn=")
                .append(this.getIsbn())
                .append(", anoPublicacion=")
                .append(super.getFechaPublicacion().get(Calendar.YEAR))
                .append(" ]");
        return sb.toString();
    }

    @Override
    public final String generarCodigo() {
        String padded = String.format("%05d", historicoUnidades);
        return ("LIB" + padded);
    }

    @Override
    public void mostrarMaterial() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Libro ===")
                .append("\nCodigo : ")
                .append(super.getCodigo())
                .append("\nTitulo : ")
                .append(super.getTitulo())
                .append("\nAutor : ")
                .append(this.getAutor())
                .append("\nNúmero de Páginas : ")
                .append(this.getNumeroPaginas())
                .append("\nEditorial : ")
                .append(super.getEditorial())
                .append("\nISBN: ")
                .append(this.getIsbn())
                .append("\nAño de Publicación : ")
                .append(super.getFechaPublicacion().get(Calendar.YEAR))
                .append("\nUnidades Disponibles : ")
                .append(super.getUnidadesDisponibles())
                .append("");

        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
