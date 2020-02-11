/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.utils;

import java.awt.HeadlessException;
import java.util.logging.Logger;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Pattern;
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
        String year = "";
        String isbn;
        String autor;
        String titulo;
        String nPaginas;
        String editorial;
        String uDiponibles;
        String periodicidad;
        Calendar myCalendar = Calendar.getInstance();

        //Validar Titulo 
        do {
            titulo = JOptionPane.showInputDialog(
                    "Ingrese el titulo del material: ");
            LOGGER.warning(titulo);
        } while (null == titulo || titulo.equals(""));

        // Validar editorial
        do {
            editorial = JOptionPane.showInputDialog(
                    "Ingrese la editorial de "
                    + tipoMaterialEscrito.getDescripcion() + " : ");
        } while (null == editorial || editorial.equals(""));

        // Validar Año/Fecha Públicacion
        boolean fechaCorrecta = false;
        do {

            try {
                String regexAno = "(?:[0-9][0-9])?[0-9][0-9]$";
                String regexFecha = "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9][0-9])?[0-9][0-9]$";
                Pattern pattern = Pattern.compile(regexAno);

                year = JOptionPane.showInputDialog("Ingrese "
                        + (tipoMaterialEscrito.equals(Material.LIBRO)
                        ? "el año"
                        : "la fecha (en formato dd/mm/aaaa)")
                        + " de publicacion: ");

                if (tipoMaterialEscrito.equals(Material.LIBRO)) {
                    if (!pattern.matcher(year).matches()) {
                        JOptionPane.showMessageDialog(null,
                                "Ingresar el año de publicación correctamente ",
                                "Formato Fecha",
                                JOptionPane.WARNING_MESSAGE);
                    } else {
                        fechaCorrecta = true;
                    }
                } else {
                    pattern = Pattern.compile(regexFecha);
                    if (!pattern.matcher(year).matches()) {
                        JOptionPane.showMessageDialog(null,
                                "Ingresar fecha de publicación en formato dia/mes/año ",
                                "Formato Fecha",
                                JOptionPane.WARNING_MESSAGE);
                    } else {
                        fechaCorrecta = true;
                    }
                }

            } catch (HeadlessException e) {
                JOptionPane.showMessageDialog(null,
                        "Formato incorrecto, intente de nuevo! ",
                        "Formato Fecha",
                        JOptionPane.WARNING_MESSAGE);
            }
        } while (!fechaCorrecta);

        // Validar Unidades Disponibles
        int unidades = -1;
        do {
            uDiponibles = JOptionPane.showInputDialog(
                    "Ingrese el numero de unidades disponibles: ");
            try {
                unidades = Integer.parseInt(uDiponibles);

                if (unidades <= 0) {
                    JOptionPane.showMessageDialog(null,
                            "Favor Ingresar Solo Números positivos! ",
                            "Formato Numero",
                            JOptionPane.WARNING_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null,
                        "Favor Ingresar Solo Números. ",
                        "Formato Numero",
                        JOptionPane.WARNING_MESSAGE);
            }
        } while (unidades <= 0);

        String[] dateChunks = year.split("/");

        if (tipoMaterialEscrito.equals(Material.LIBRO)) {
            //Validar autor
            do {
                autor = JOptionPane.showInputDialog("Ingrese el autor del libro: ");
            } while (null == autor || autor.equals(""));

            // Validar # Paginas
            int paginas = -1;
            do {

                nPaginas = JOptionPane.showInputDialog("Ingrese el número de páginas: ");
                try {
                    paginas = Integer.parseInt(nPaginas);

                    if (paginas <= 0) {
                        JOptionPane.showMessageDialog(null,
                                "Favor Ingresar Solo Números positivos! ",
                                "Formato Numero",
                                JOptionPane.WARNING_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null,
                            "Favor Ingresar Solo Números. ",
                            "Formato Numero",
                            JOptionPane.WARNING_MESSAGE);
                }
            } while (paginas <= 0);

            // Validar codigo ISBN
            do {
                isbn = JOptionPane.showInputDialog("Ingrese el codigo ISBN: ");
            } while (null == isbn || isbn.equals(""));

            myCalendar.set(Integer.parseInt(dateChunks[0]), 0, 1);

            Libro nuevoLibro = new Libro();
            nuevoLibro.setTitulo(titulo);
            nuevoLibro.setAutor(autor);
            nuevoLibro.setNumeroPaginas(Integer.parseInt(nPaginas));
            nuevoLibro.setEditorial(editorial);
            nuevoLibro.setIsbn(isbn);
            nuevoLibro.setFechaPublicacion(myCalendar);
            nuevoLibro.setUnidadesDisponibles(Integer.parseInt(uDiponibles));

            Mediateca.agregarLibro(nuevoLibro);
            return (T) nuevoLibro;

        } else {

            // Validar Periodicidad
            int meses = -1;
            do {

                periodicidad = JOptionPane.showInputDialog(
                        "Ingrese la periodicidad de la revista (número de meses): ");

                try {
                    meses = Integer.parseInt(periodicidad);

                    if (meses <= 0) {
                        JOptionPane.showMessageDialog(null,
                                "Favor Ingresar Solo Números positivos! ",
                                "Formato Numero",
                                JOptionPane.WARNING_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null,
                            "Favor Ingresar Solo Números. ",
                            "Formato Numero",
                            JOptionPane.WARNING_MESSAGE);
                }
            } while (meses <= 0);

            myCalendar.set(Integer.parseInt(dateChunks[2]),
                    (Integer.parseInt(dateChunks[1]) - 1),
                    Integer.parseInt(dateChunks[0]));

            Revista nuevaRevista = new Revista();
            nuevaRevista.setTitulo(titulo);
            nuevaRevista.setEditorial(editorial);
            nuevaRevista.setFechaPublicacion(myCalendar);
            nuevaRevista.setPeriodicidad(Integer.parseInt(periodicidad));

            Mediateca.agregarRevista(nuevaRevista);
            return (T) nuevaRevista;
        }
    }

    public static void buscarPorCodigo() {
        String tipoMaterial = buildGUI(Arrays.asList(Material.values()).subList(0, 2),
                "Que tipo de material desea buscar: ");

        // Regresar a menu principal si usuario presiona X
        if (tipoMaterial.equals(OpcionMenu.CERRAR.name())) {
            return;
        }

        if (tipoMaterial.equals(Material.ESCRITO.name())) {

            String codigo = JOptionPane.showInputDialog(
                    "Ingrese el codigo del material escrito a buscar: ");
            try {
                Libro libroEncontrado = Mediateca.buscarMaterialEscrito(codigo);
                if (libroEncontrado == null) {
                    JOptionPane.showMessageDialog(null, "Material Escrito no encontrado!");
                } else {
                    libroEncontrado.mostrarMaterial();
                }
            } catch (ClassCastException cce) {
                Revista revistaEncontrada = Mediateca.buscarMaterialEscrito(codigo);
                if (revistaEncontrada == null) {
                    JOptionPane.showMessageDialog(null, "Revista no encontrado!");
                } else {
                    revistaEncontrada.mostrarMaterial();
                }
            }
        } else {
            String codigo = JOptionPane.showInputDialog(
                    "Ingrese el codigo del material audiovisual a buscar: ");

            try {
                AudioCD cdEncontrado = Mediateca.buscarMaterialAudioVisual(codigo);
                if (cdEncontrado == null) {
                    JOptionPane.showMessageDialog(null, "Audio CD no encontrado!");
                } else {
                    cdEncontrado.mostrarMaterial();
                }
            } catch (ClassCastException e) {
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

        String titulo;
        String genero;
        String duracion;
        String uDisponibles;

        //Validar Titulo 
        do {
            titulo = JOptionPane.showInputDialog(
                    "Ingrese el titulo del "
                    + tipoMaterialAudiovisual.getDescripcion() + " : ");
        } while (null == titulo || titulo.equals(""));

        do {
            genero = JOptionPane.showInputDialog(
                    "Ingrese el genero del material: ");
        } while (null == genero || genero.equals(""));

        // Validar duracion
        int length = -1;
        do {
            duracion = JOptionPane.showInputDialog(
                    "Ingrese la duracion del material (en minutos): ");
            try {
                length = Integer.parseInt(duracion);

                if (length <= 0) {
                    JOptionPane.showMessageDialog(null,
                            "Favor Ingresar Solo Números positivos! ",
                            "Formato Numero",
                            JOptionPane.WARNING_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null,
                        "Favor Ingresar Solo Números. ",
                        "Formato Numero",
                        JOptionPane.WARNING_MESSAGE);
            }
        } while (length <= 0);

        // Unidades disponibles
        int units = -1;
        do {
            uDisponibles = JOptionPane.showInputDialog(
                    "Ingrese el numero de unidades disponibles: ");
            try {
                units = Integer.parseInt(uDisponibles);

                if (units <= 0) {
                    JOptionPane.showMessageDialog(null,
                            "Favor Ingresar Solo Números positivos! ",
                            "Formato Numero",
                            JOptionPane.WARNING_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null,
                        "Favor Ingresar Solo Números. ",
                        "Formato Numero",
                        JOptionPane.WARNING_MESSAGE);
            }
        } while (units <= 0);

        if (tipoMaterialAudiovisual.equals(Material.CD)) {
            String artista;
            String nCanciones;

            do {
                artista = JOptionPane.showInputDialog(
                        "Ingrese el artista del CD: ");
            } while (null == artista || artista.equals(""));

            // Validar numero de canciones
            int songs = -1;
            do {

                nCanciones = JOptionPane.showInputDialog(
                        "Ingrese el numero de canciones del CD: ");

                try {
                    songs = Integer.parseInt(nCanciones);

                    if (songs <= 0) {
                        JOptionPane.showMessageDialog(null,
                                "Favor Ingresar Solo Números positivos! ",
                                "Formato Numero",
                                JOptionPane.WARNING_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null,
                            "Favor Ingresar Solo Números. ",
                            "Formato Numero",
                            JOptionPane.WARNING_MESSAGE);
                }
            } while (songs <= 0);

            AudioCD cd = new AudioCD();
            cd.setTitulo(titulo);
            cd.setArtista(artista);
            cd.setGenero(genero);
            cd.setDuracion(Integer.parseInt(duracion));
            cd.setNumeroCanciones(Integer.parseInt(nCanciones));
            cd.setUnidadesDisponibles(Integer.parseInt(uDisponibles));

            Mediateca.agregarAudioCD(cd);
            return (T) cd;
        } else {
            String director;
            do {
                director = JOptionPane.showInputDialog(
                        "Ingrese el director del DVD: ");
            } while (null == director || director.equals(""));

            DVD dvd = new DVD();
            dvd.setTitulo(titulo);
            dvd.setDirector(director);
            dvd.setDuracion(Integer.parseInt(duracion));
            dvd.setGenero(genero);
            dvd.setUnidadesDisponibles(Integer.parseInt(uDisponibles));

            Mediateca.agregarDVD(dvd);
            return (T) dvd;
        }
    }

    public static void borrarPorCodigo() {
        String codigo = JOptionPane.showInputDialog("Ingrese el codigo del material a borrar: ");
        // Regresar a menu principal si usuario presiona X
        if (null == codigo) {
            return;
        }
        if (Mediateca.borrar(codigo)) {
            JOptionPane.showMessageDialog(null, "Material borrado con éxito!");
        } else {
            JOptionPane.showMessageDialog(null, "El material no se pudo encontar! Vuelva a intentar.");
        }
    }

    public static void modificarMaterial() {

        String tipoMaterial = buildGUI(Arrays.asList(Material.values()).subList(0, 2),
                "Que tipo de material desea modificar: ");

        LOGGER.info(tipoMaterial);

        if (tipoMaterial.equals(Material.ESCRITO.name())) {

            String codLibro;
            do {
                codLibro = JOptionPane.showInputDialog(
                        "Ingrese el codigo del Material: ");
            } while (null == codLibro || codLibro.equals(""));

            try {
                Libro libroEncontrado = Mediateca.buscarMaterialEscrito(codLibro);

                if (null != libroEncontrado) {
                    JOptionPane.showMessageDialog(null, "Libro Encontrado! "
                            + "\nPor Favor Modifique los valores deseados.");
                    Mediateca.modificarLibro(libroEncontrado);
                } else {
                    JOptionPane.showMessageDialog(null, "Material no encontrado! "
                            + "\nIntente de nuevo.");
                }
            } catch (ClassCastException e) {
                Revista revistaEncontrada = Mediateca.buscarMaterialEscrito(codLibro);
                if (null != revistaEncontrada) {
                    JOptionPane.showMessageDialog(null, "Revista Encontrada! "
                            + "\nPor Favor Modifique los valores deseados.");
                    Mediateca.modificarRevista(revistaEncontrada);
                } else {
                    JOptionPane.showMessageDialog(null, "Revista no encontrado! "
                            + "\nIntente de nuevo.");
                }
            }

        } else if (tipoMaterial.equals(Material.AUDIOVISUAL.name())) {

            String codCD;
            do {
                codCD = JOptionPane.showInputDialog("Ingrese el codigo del material: ");
                if (null == codCD) {
                    return;
                }
            } while (codCD.equals(""));

            try {
                AudioCD cdEncontrado = Mediateca.buscarMaterialAudioVisual(codCD);
                if (null != cdEncontrado) {
                    JOptionPane.showMessageDialog(null, "Audio CD Encontrado! "
                            + "\nPor Favor Modifique los valores deseados.");
                    Mediateca.modificarAudioCD(cdEncontrado);
                } else {
                    JOptionPane.showMessageDialog(null, "Material no encontrado! "
                            + "\nIntente de nuevo.");
                }
            } catch (java.lang.ClassCastException cce) {
                DVD dvdEncontrado = Mediateca.buscarMaterialAudioVisual(codCD);
                if (null != dvdEncontrado) {
                    JOptionPane.showMessageDialog(null, "DVD Encontrada! "
                            + "\nPor Favor Modifique los valores deseados.");
                    Mediateca.modificarDVD(dvdEncontrado);
                } else {
                    JOptionPane.showMessageDialog(null, "DVD no encontrado! "
                            + "\nIntente de nuevo.");
                }
            }

        }
    }

    public static void agregar() {
        String tipoMaterial = Utils.buildGUI(
                Arrays.asList(Material.values()).subList(0, 2),
                "Que tipo de material desea agregar?");

        LOGGER.info(tipoMaterial);

        if (tipoMaterial.equals(Material.ESCRITO.name())) {
            String materialEscrito = Utils.buildGUI(
                    Arrays.asList(Material.values()).subList(2, 4),
                    "Que tipo de material escrito desea agregar: ");

            // Regresar a menu principal si usuario presiona X
            if (materialEscrito.equals(OpcionMenu.CERRAR.name())) {
                return;
            }

            LOGGER.info(materialEscrito);

            if (materialEscrito.equals(Material.LIBRO.name())) {
                Utils.agregarMaterialEscrito(Material.LIBRO);
            } else {
                Utils.agregarMaterialEscrito(Material.REVISTA);
            }

        } else if (tipoMaterial.equals(Material.AUDIOVISUAL.name())) {
            String materialAudiovisual = Utils.buildGUI(
                    Arrays.asList(Material.values()).subList(4, Material.values().length),
                    "Que tipo de material audiovisual desea agregar: ");

            // Regresar a menu principal si usuario presiona X
            if (materialAudiovisual.equals(OpcionMenu.CERRAR.name())) {
                return;
            }

            LOGGER.info(materialAudiovisual);

            if (materialAudiovisual.equals(Material.CD.name())) {
                Utils.agregarMaterialAudioVisual(Material.CD);
            } else {
                Utils.agregarMaterialAudioVisual(Material.DVD);
            }
        }
    }
}
