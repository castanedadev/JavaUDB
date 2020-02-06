/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.ejercicio3.marshalling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import sv.edu.udb.ejercicio3.AudioCD;
import sv.edu.udb.ejercicio3.DVD;
import sv.edu.udb.ejercicio3.Libro;
import sv.edu.udb.ejercicio3.Revista;

/**
 *
 * @author rickc
 */
@XmlRootElement(name = "Mediateca")
public class Mediateca {

    private String nombre;
    private String ultimoLibro;
    private String ultimaRevista;
    private String ultimoCD;
    private String ultimoDVD;

    private List<Libro> libros = new ArrayList();
    private List<Revista> revistas = new ArrayList();
    private List<AudioCD> audioCDs = new ArrayList();
    private List<DVD> dvds = new ArrayList();

    @XmlAttribute(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlAttribute(name = "ultimoLibro")
    public String getUltimoLibro() {
        return String.valueOf(Libro.historicoUnidades);
    }

    public void setUltimoLibro(String ultimoLibro) {
        this.ultimoLibro = ultimoLibro;
    }

    @XmlAttribute(name = "ultimaRevista")
    public String getUltimaRevista() {
        return String.valueOf(Revista.historicoUnidades);
    }

    public void setUltimaRevista(String ultimaRevista) {
        this.ultimaRevista = ultimaRevista;
    }

    @XmlAttribute(name = "ultimoCD")
    public String getUltimoCD() {
        return String.valueOf(AudioCD.historicoUnidades);
    }

    public void setUltimoCD(String ultimoCD) {
        this.ultimoCD = ultimoCD;
    }

    @XmlAttribute(name = "ultimoDVD")
    public String getUltimoDVD() {
        return String.valueOf(DVD.historicoUnidades);
    }

    public void setUltimoDVD(String ultimoDVD) {
        this.ultimoDVD = ultimoDVD;
    }

    @XmlElementWrapper(name = "Libros")
    @XmlElement(name = "Libro")
    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    @XmlElementWrapper(name = "Revistas")
    @XmlElement(name = "Revista")
    public List<Revista> getRevistas() {
        return revistas;
    }

    public void setRevistas(List<Revista> revistas) {
        this.revistas = revistas;
    }

    @XmlElementWrapper(name = "AudioCDs")
    @XmlElement(name = "AudioCD")
    public List<AudioCD> getAudioCDs() {
        return audioCDs;
    }

    public void setAudioCDs(List<AudioCD> audioCDs) {
        this.audioCDs = audioCDs;
    }

    @XmlElementWrapper(name = "DVDs")
    @XmlElement(name = "DVD")
    public List<DVD> getDvds() {
        return dvds;
    }

    public void setDvds(List<DVD> dvds) {
        this.dvds = dvds;
    }

    public void agregarLibro(Libro libro) {
        try {
            if (libros == null) {
                libros = new ArrayList<>();
            }
            libros.add(libro);

        } catch (Exception e) {
        }
    }

    public void agregarRevista(Revista revista) {
        try {
            if (revista == null) {
                revistas = new ArrayList<>();
            }
            revistas.add(revista);

        } catch (Exception e) {
        }
    }

    public void agregarAudioCD(AudioCD cd) {
        try {
            if (cd == null) {
                audioCDs = new ArrayList<>();
            }
            audioCDs.add(cd);

        } catch (Exception e) {
        }
    }

    public void agregarDVD(DVD dvd) {
        try {
            if (dvd == null) {
                dvds = new ArrayList<>();
            }
            dvds.add(dvd);

        } catch (Exception e) {
        }
    }

    public void persist() throws JAXBException, FileNotFoundException {
        JAXBContext contextObj = JAXBContext.newInstance(Mediateca.class);

        Marshaller marshallerObj = contextObj.createMarshaller();
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshallerObj.marshal(this, new FileOutputStream("mediateca.xml"));
    }

    public void unmarshall() throws JAXBException, FileNotFoundException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Mediateca.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        InputStream inStream = new FileInputStream("mediateca.xml");
        Mediateca mediateca = (Mediateca) jaxbUnmarshaller.unmarshal(inStream);

        // Seteando valores desde el archivo leido a instancia actual
        this.nombre = mediateca.getNombre();
        this.ultimoLibro = mediateca.ultimoLibro;
        this.ultimaRevista = mediateca.ultimaRevista;
        this.ultimoCD = mediateca.ultimoCD;
        this.ultimoDVD = mediateca.ultimoDVD;
        this.libros = mediateca.getLibros();
        this.revistas = mediateca.getRevistas();
        this.audioCDs = mediateca.getAudioCDs();
        this.dvds = mediateca.getDvds();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Mediateca { \n    Libros {");

        for (Libro libro : libros) {
            sb.append(libro.toString());
        }

        sb.append("\n           }");
        sb.append("\n    Revistas {");

        for (Revista revista : revistas) {
            sb.append(revista.toString());
        }

        sb.append("\n             }");
        sb.append("\n    CDs {");

        for (AudioCD cd : audioCDs) {
            sb.append(cd.toString());
        }

        sb.append("\n       }");
        sb.append("\n    DVDs {").append(dvds);
        sb.append("\n   }");
        return sb.toString();
    }

}
