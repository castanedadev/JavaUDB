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
import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
import sv.edu.udb.ejercicio3.MaterialAudiovisual;
import sv.edu.udb.ejercicio3.MaterialEscrito;
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

    private static List<Libro> libros = new ArrayList();
    private static List<Revista> revistas = new ArrayList();
    private static List<AudioCD> audioCDs = new ArrayList();
    private static List<DVD> dvds = new ArrayList();

    private static final Logger LOGGER = Logger.getLogger(Mediateca.class.toGenericString());

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
        Mediateca.libros = libros;
    }

    @XmlElementWrapper(name = "Revistas")
    @XmlElement(name = "Revista")
    public List<Revista> getRevistas() {
        return revistas;
    }

    public void setRevistas(List<Revista> revistas) {
        Mediateca.revistas = revistas;
    }

    @XmlElementWrapper(name = "AudioCDs")
    @XmlElement(name = "AudioCD")
    public List<AudioCD> getAudioCDs() {
        return audioCDs;
    }

    public void setAudioCDs(List<AudioCD> audioCDs) {
        Mediateca.audioCDs = audioCDs;
    }

    @XmlElementWrapper(name = "DVDs")
    @XmlElement(name = "DVD")
    public List<DVD> getDvds() {
        return dvds;
    }

    public void setDvds(List<DVD> dvds) {
        Mediateca.dvds = dvds;
    }

    public static void agregarLibro(Libro libro) {
        try {
            if (libros == null) {
                libros = new ArrayList<>();
            }
            libros.add(libro);

        } catch (Exception e) {
        }
    }

    public static void agregarRevista(Revista revista) {
        try {
            if (revista == null) {
                revistas = new ArrayList<>();
            }
            revistas.add(revista);

        } catch (Exception e) {
        }
    }

    public static void agregarAudioCD(AudioCD cd) {
        try {
            if (cd == null) {
                audioCDs = new ArrayList<>();
            }
            audioCDs.add(cd);

        } catch (Exception e) {
        }
    }

    public static void agregarDVD(DVD dvd) {
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

        Mediateca.libros = mediateca.getLibros();
        Mediateca.revistas = mediateca.getRevistas();
        Mediateca.audioCDs = mediateca.getAudioCDs();
        Mediateca.dvds = mediateca.getDvds();
    }

    public static <T extends MaterialEscrito> T buscarMaterialEscrito(String codigo) {
        for (Libro libro : libros) {
            if (libro.getCodigo().equals(codigo)) {
                LOGGER.info("Libro encontrado");
                return (T) libro;
            }
        }
        for (Revista revista : revistas) {
            if (revista.getCodigo().equals(codigo)) {
                LOGGER.info("Revista encontrado");
                return (T) revista;
            }
        }

        return null;
    }

    public static <T extends MaterialAudiovisual> T buscarMaterialAudioVisual(String codigo) {
        for (AudioCD cd : audioCDs) {
            if (cd.getCodigo().equals(codigo)) {
                LOGGER.info("CD encontrado");
                return (T) cd;
            }
        }
        for (DVD dvd : dvds) {
            if (dvd.getCodigo().equals(codigo)) {
                LOGGER.info("DVD encontrado");
                return (T) dvd;
            }
        }

        return null;
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

    public static boolean borrar(String codigo) {
        for (Libro libro : libros) {
            if (libro.getCodigo().equals(codigo)) {
                return libros.remove(libro);
            }
        }
        for (Revista revista : revistas) {
            if (revista.getCodigo().equals(codigo)) {
                return revistas.remove(revista);
            }
        }

        for (AudioCD audioCD : audioCDs) {
            if (audioCD.getCodigo().equals(codigo)) {
                return audioCDs.remove(audioCD);
            }
        }

        for (DVD dvd : dvds) {
            if (dvd.getCodigo().equals(codigo)) {
                return dvds.remove(dvd);
            }
        }

        return false;
    }

    public static boolean modificarLibro(Libro book) {

        //Propiedades comunes en material escritos
        String titulo = JOptionPane.showInputDialog(
                "Ingrese el titulo del libro: ", book.getTitulo());

        String autor = JOptionPane.showInputDialog(
                "Ingrese el autor del libro: ", book.getAutor());

        String nPaginas = JOptionPane.showInputDialog(
                "Ingrese el número de páginas: ", book.getNumeroPaginas());
        String editorial = JOptionPane.showInputDialog(
                "Ingrese la editorial del libro: ", book.getEditorial());
        String year = JOptionPane.showInputDialog(
                "Ingrese el año de publicacion: ",
                book.getFechaPublicacion().get(Calendar.YEAR));
        String uDiponibles = JOptionPane.showInputDialog(
                "Ingrese el numero de unidades disponibles: ",
                book.getUnidadesDisponibles());
        String isbn = JOptionPane.showInputDialog("Ingrese el codigo ISBN: ",
                book.getIsbn());

        //myCalendar.set(Integer.parseInt(year), 0, 1);
        Libro nuevoLibro = new Libro();
        nuevoLibro.setTitulo(titulo);
        nuevoLibro.setAutor(autor);
        nuevoLibro.setNumeroPaginas(Integer.parseInt(nPaginas));
        nuevoLibro.setEditorial(editorial);
        nuevoLibro.setIsbn(isbn);
        //nuevoLibro.setFechaPublicacion(myCalendar);
        nuevoLibro.setUnidadesDisponibles(Integer.parseInt(uDiponibles));

        return true;
    }

    public static boolean modificarRevista(Revista revista) {
        //Propiedades comunes en material escritos
        String titulo = JOptionPane.showInputDialog(
                "Ingrese el titulo del libro: ", revista.getTitulo());

        String editorial = JOptionPane.showInputDialog(
                "Ingrese la editorial del libro: ", revista.getEditorial());

        String periodicidad = JOptionPane.showInputDialog(
                "Ingrese la periodicidad de la revista: ", revista.getPeriodicidad());

        String year = JOptionPane.showInputDialog(
                "Ingrese la fecha de publicacion: ",
                revista.getFechaPublicacion().get(Calendar.YEAR));
        String uDiponibles = JOptionPane.showInputDialog(
                "Ingrese el numero de unidades disponibles: ");

        //myCalendar.set(Integer.parseInt(year), 0, 1);
        revista.setTitulo(titulo);
        revista.setEditorial(editorial);
        revista.setPeriodicidad(Integer.parseInt(periodicidad));
        //nuevoLibro.setFechaPublicacion(myCalendar);
        revista.setUnidadesDisponibles(Integer.parseInt(uDiponibles));

        return true;
    }

    public static boolean modificarAudioCD(AudioCD cd) {
        return true;
    }

    public static boolean modificadDVD(DVD dvd) {
        return true;
    }
}
