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
@XmlRootElement(name = "Libro")
public class Libro extends MaterialEscrito {

    private String autor;
    private int numeroPaginas;
    private String isbn;

    public static int historicoUnidades = 0;

    public Libro() {
        historicoUnidades++;
        String padded = String.format("%05d", historicoUnidades);
        super.setCodigo("LIB" + padded);
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
        sb.append("\n       Libro [ autor=").append(this.autor);
        sb.append(", codigo=").append(super.getCodigo());
        sb.append(", titulo=").append(super.getTitulo());
        sb.append(", unidadesDisponibles=").append(super.getUnidadesDisponibles());
        sb.append(", numeroPaginas=").append(this.numeroPaginas);
        sb.append(", editorial=").append(super.getEditorial());
        sb.append(", isbn=").append(this.isbn);
        sb.append(", anoPublicacion=").append(super.getFechaPublicacion().get(Calendar.YEAR));
        sb.append(" ]");
        return sb.toString();
    }
}
