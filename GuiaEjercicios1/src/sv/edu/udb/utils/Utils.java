/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.utils;

import java.util.logging.Logger;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import sv.edu.udb.ejercicio3.AudioCD;
import sv.edu.udb.ejercicio3.DVD;
import sv.edu.udb.ejercicio3.Libro;
import sv.edu.udb.ejercicio3.MaterialAudiovisual;
import sv.edu.udb.ejercicio3.MaterialEscrito;
import sv.edu.udb.ejercicio3.Revista;
import sv.edu.udb.ejercicio3.marshalling.Mediateca;

/**
 *
 * @author rickc
 */
public class Utils {

    private static final Logger LOGGER = Logger.getLogger(Utils.class.toGenericString());

    public static String buildGUI(List options, String message) {
        JOptionPane optionPane = new JOptionPane(
                new JLabel((null != message) ? message
                        : "Por favor seleccione una opcion: \n",
                        JLabel.CENTER),
                JOptionPane.QUESTION_MESSAGE,
                JOptionPane.YES_NO_OPTION,
                null,
                options.toArray(),
                options.get(0));
        JDialog dialog = optionPane.createDialog("Menu - Java Avanzado 2020");
        dialog.setModal(true);
        dialog.setVisible(true);

        return (null == optionPane.getValue()) ? OpcionMenu.CERRAR.toString()
                : optionPane.getValue().toString();
    }

    public static <T extends MaterialEscrito> T agregarMaterialEscrito(Material tipoMaterialEscrito) {
        String isbn;
        String autor;
        String nPaginas;
        String periodicidad;
        Calendar myCalendar = Calendar.getInstance();

        //Propiedades comunes en material escritos
        String titulo = JOptionPane.showInputDialog(
                "Ingrese el titulo del libro: ");
        String editorial = JOptionPane.showInputDialog(
                "Ingrese la editorial de "
                + tipoMaterialEscrito.getDescripcion() + " : ");
        String year = JOptionPane.showInputDialog("Ingrese "
                + (tipoMaterialEscrito.equals(Material.LIBRO)
                ? "el año"
                : "la fecha")
                + " de publicacion: ");
        String uDiponibles = JOptionPane.showInputDialog(
                "Ingrese el numero de unidades disponibles: ");

        if (tipoMaterialEscrito.equals(Material.LIBRO)) {
            autor = JOptionPane.showInputDialog("Ingrese el autor del libro: ");
            nPaginas = JOptionPane.showInputDialog("Ingrese el número de páginas: ");
            isbn = JOptionPane.showInputDialog("Ingrese el codigo ISBN: ");

            myCalendar.set(Integer.parseInt(year), 0, 1);

            Libro nuevoLibro = new Libro();
            nuevoLibro.setTitulo(titulo);
            nuevoLibro.setAutor(autor);
            nuevoLibro.setNumeroPaginas(Integer.parseInt(nPaginas));
            nuevoLibro.setEditorial(editorial);
            nuevoLibro.setIsbn(isbn);
            nuevoLibro.setFechaPublicacion(myCalendar);
            nuevoLibro.setUnidadesDisponibles(Integer.parseInt(uDiponibles));

            return (T) nuevoLibro;

        } else {
            periodicidad = JOptionPane.showInputDialog(
                    "Ingrese la periodicidad de la revista: ");

            myCalendar.set(Integer.parseInt(year), 2, 10);

            Revista nuevaRevista = new Revista();
            nuevaRevista.setTitulo(titulo);
            nuevaRevista.setEditorial(editorial);
            nuevaRevista.setFechaPublicacion(myCalendar);
            nuevaRevista.setPeriodicidad(Integer.parseInt(periodicidad));

            return (T) nuevaRevista;
        }
    }

    public static void buscarPorCodigo() {
        String tipoMaterial = buildGUI(Arrays.asList(Material.values()).subList(0, 2),
                "Que tipo de material desea buscar: ");

        if (tipoMaterial.equals(Material.ESCRITO.name())) {
            String materialEscrito = Utils.buildGUI(
                    Arrays.asList(Material.values()).subList(2, 4),
                    "Que tipo de material escrito desea buscar: ");

            String codigo = JOptionPane.showInputDialog(
                    "Ingrese el codigo del material escrito a buscar: ");

            if (materialEscrito.equals(Material.LIBRO.name())) {
                Libro libroEncontrado = Mediateca.buscarMaterialEscrito(codigo);
                if (libroEncontrado == null) {
                    JOptionPane.showMessageDialog(null, "Libro no encontrado!");
                } else {
                    libroEncontrado.mostrarMaterial();
                }
            } else {
                Revista revistaEncontrada = Mediateca.buscarMaterialEscrito(codigo);
                if (revistaEncontrada == null) {
                    JOptionPane.showMessageDialog(null, "Revista no encontrado!");
                } else {
                    revistaEncontrada.mostrarMaterial();
                }

            }
        } else {
            String materialEscrito = Utils.buildGUI(
                    Arrays.asList(Material.values()).subList(4, Material.values().length),
                    "Que tipo de material audiovisual desea buscar: ");
            String codigo = JOptionPane.showInputDialog(
                    "Ingrese el codigo del material audiovisual a buscar: ");
            if (materialEscrito.equals(Material.CD.name())) {
                AudioCD cdEncontrado = Mediateca.buscarMaterialAudioVisual(codigo);
                if (cdEncontrado == null) {
                    JOptionPane.showMessageDialog(null, "Audio CD no encontrado!");
                } else {
                    cdEncontrado.mostrarMaterial();
                }

            } else {
                DVD dvdEncontrado = Mediateca.buscarMaterialAudioVisual(codigo);
                if (dvdEncontrado == null) {
                    JOptionPane.showMessageDialog(null, "DVD no encontrado!");
                } else {
                    dvdEncontrado.mostrarMaterial();
                }

            }
        }
        LOGGER.info(tipoMaterial);
    }

    public static <T extends MaterialAudiovisual> T agregarMaterialAudioVisual(Material tipoMaterialAudiovisual) {

        //Propiedades comunes en material escritos
        String titulo = JOptionPane.showInputDialog(
                "Ingrese el titulo del "
                + tipoMaterialAudiovisual.getDescripcion() + " : ");
        String genero = JOptionPane.showInputDialog(
                "Ingrese el genero del material: ");
        String duracion = JOptionPane.showInputDialog(
                "Ingrese la duracion del material: ");
        String uDiponibles = JOptionPane.showInputDialog(
                "Ingrese el numero de unidades disponibles: ");

        if (tipoMaterialAudiovisual.equals(Material.CD)) {
            String artista = JOptionPane.showInputDialog(
                    "Ingrese el artista del CD: ");
            String nCanciones = JOptionPane.showInputDialog(
                    "Ingrese el numero de canciones del CD: ");

            AudioCD cd = new AudioCD();
            cd.setTitulo(titulo);
            cd.setArtista(artista);
            cd.setGenero(genero);
            cd.setDuracion(Integer.parseInt(duracion));
            cd.setNumeroCanciones(Integer.parseInt(nCanciones));
            cd.setUnidadesDisponibles(Integer.parseInt(uDiponibles));

            return (T) cd;
        } else {
            String director = JOptionPane.showInputDialog(
                    "Ingrese el director del DVD: ");

            DVD dvd = new DVD();
            dvd.setTitulo(titulo);
            dvd.setDirector(director);
            dvd.setDuracion(Integer.parseInt(duracion));
            dvd.setGenero(genero);
            dvd.setUnidadesDisponibles(Integer.parseInt(uDiponibles));

            return (T) dvd;
        }
    }

    public static void borrarPorCodigo() {
        String codigo = JOptionPane.showInputDialog("Ingrese el codigo del material a borrar: ");
        if (Mediateca.borrar(codigo)) {
            JOptionPane.showMessageDialog(null, "Material borrado con éxito!");
        } else {
            JOptionPane.showMessageDialog(null, "Se encontro un problema borrando el material! Vuelva a intentar.");
        }
    }

    public static void modificarMaterial() {

        String tipoMaterial = buildGUI(Arrays.asList(Material.values()).subList(0, 2),
                "Que tipo de material desea modificar: ");

        LOGGER.info(tipoMaterial);

        if (tipoMaterial.equals(Material.ESCRITO.name())) {
            String materialEscrito = Utils.buildGUI(
                    Arrays.asList(Material.values()).subList(2, 4),
                    "Que tipo de material escrito desea modificar: ");

            LOGGER.info(materialEscrito);

            if (materialEscrito.equals(Material.LIBRO.name())) {
                String codLibro = JOptionPane.showInputDialog(
                        "Ingrese el codigo del Libro: ");
                Libro libroEncontrado = Mediateca.buscarMaterialEscrito(codLibro);
                if (null != libroEncontrado) {
                    JOptionPane.showMessageDialog(null, "Libro Encontrado! "
                            + "\nPor Favor Modifique los valores deseados.");
                    Mediateca.modificarLibro(libroEncontrado);
                } else {
                    JOptionPane.showMessageDialog(null, "Libro no encontrado! "
                            + "\nSi desea modificar otro material intente de nuevo.");
                }

            } else {
                String codRevista = JOptionPane.showInputDialog(
                        "Ingrese el codigo de la Revista: ");
                Revista revistaEncontrada = Mediateca.buscarMaterialEscrito(codRevista);
                if (null != revistaEncontrada) {
                    JOptionPane.showMessageDialog(null, "tRevista Encontrada! "
                            + "\nPor Favor Modifique los valores deseados.");
                    Mediateca.modificarRevista(revistaEncontrada);
                } else {
                    JOptionPane.showMessageDialog(null, "Revista no encontrado! "
                            + "\nSi desea modificar otro material intente de nuevo.");
                }
            }

        } else if (tipoMaterial.equals(Material.AUDIOVISUAL.name())) {
            String materialAudiovisual = Utils.buildGUI(
                    Arrays.asList(Material.values()).subList(4, Material.values().length),
                    "Que tipo de material audiovisual desea modificar: ");

            LOGGER.info(materialAudiovisual);

            if (materialAudiovisual.equals(Material.CD.name())) {
                String codCD = JOptionPane.showInputDialog("Ingrese el codigo del CD: ");
            } else {
                String codDVD = JOptionPane.showInputDialog("Ingrese el codigo del DVD: ");
            }
        }
    }

}
