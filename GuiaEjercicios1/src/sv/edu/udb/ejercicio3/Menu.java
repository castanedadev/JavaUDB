/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.ejercicio3;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.xml.bind.JAXBException;
import sv.edu.udb.ejercicio3.marshalling.Mediateca;
import sv.edu.udb.utils.Utils;
import sv.edu.udb.utils.Material;

/**
 *
 * @author rickc
 */
public class Menu {

    private enum OpcionMenu {
        AGREGAR("Agregar material"),
        MODIFICAR("Modificar material"),
        LISTAR("Listar materiales disponibles"),
        BORRAR("Borrar material"),
        BUSCAR("Buscar material"),
        SALIR("Salir"),
        CERRAR("Cerrar");

        private final String descripcion;

        private OpcionMenu(String descripcion) {
            this.descripcion = descripcion;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public OpcionMenu getOption(String desc) {
            if (desc.equals(AGREGAR.getDescripcion())) {
                return AGREGAR;
            } else {
                return BORRAR;
            }
        }

    }

    public static void main(String[] args) throws JAXBException, FileNotFoundException {
        List<Libro> libros = new ArrayList();
        List<Revista> revistas = new ArrayList();
        List<AudioCD> cds = new ArrayList();
        List<DVD> dvds = new ArrayList();
        int opcionMenu = 0;

        Mediateca mediateca = new Mediateca();
        List<String> optionList = new ArrayList<>();
        optionList.add(OpcionMenu.AGREGAR.getDescripcion());
        optionList.add(OpcionMenu.MODIFICAR.getDescripcion());
        optionList.add(OpcionMenu.LISTAR.getDescripcion());
        optionList.add(OpcionMenu.BORRAR.getDescripcion());
        optionList.add(OpcionMenu.BUSCAR.getDescripcion());
        optionList.add(OpcionMenu.SALIR.getDescripcion());

        System.out.println("" + (null != args));
        if (null != args && Boolean.getBoolean(args[0])) {
            System.out.println("Leyendo archivo...");
            mediateca.unmarshall();
            System.out.println("Mediateca cargada!");
        }

        do {

            String opcion = Utils.buildGUI(optionList, null);
            //optionList.addAll(Arrays.asList(args));
            OpcionMenu opcionSeleccionada = OpcionMenu.CERRAR;

            for (OpcionMenu option : OpcionMenu.values()) {
                if (option.getDescripcion().equals(opcion)) {
                    opcionSeleccionada = option;
                    break;
                }
            }

            switch (opcionSeleccionada) {
                case AGREGAR:
                    String tipoMaterial = Utils.buildGUI(
                            Arrays.asList(Material.values()).subList(0, 2),
                             "Que tipo de material desea agregar?");

                    Material materialSeleccionado = null;
                    for (Material material : Material.values()) {
                        if (material.name().equals(tipoMaterial)) {
                            materialSeleccionado = material;
                            break;
                        }
                    }

                    System.out.println("Material Seleccionado => " + materialSeleccionado);

                    if (materialSeleccionado.equals(Material.ESCRITO)) {
                        String materialEscrito = Utils.buildGUI(
                                Arrays.asList(Material.values()).subList(2, 4),
                                 "Que tipo de material escrito desea agregar: ");
                    } else if (materialSeleccionado.equals(Material.AUDIOVISUAL)) {
                        String materialAudiovisual = Utils.buildGUI(
                                Arrays.asList(Material.values()).subList(4, Material.values().length),
                                 "Que tipo de material audiovisual desea agregar: ");
                    }
                    break;
                case MODIFICAR:
                    break;
                case LISTAR:
                    System.out.println(mediateca.toString());
                    break;
                case BORRAR:
                    break;
                case BUSCAR:
                    break;
                case SALIR:
                    System.exit(0);
                    break;
                default:
                    throw new AssertionError();
            }
            System.out.println("Selected => " + opcion);
        } while (true);

//        Calendar year = Calendar.getInstance();
//        year.set(2001, 0, 1);
//
//        Libro l1 = new Libro();
//        l1.setTitulo("Holy Bible");
//        l1.setAutor("Jesus Christ");
//        l1.setNumeroPaginas(1500);
//        l1.setEditorial("Any in the world!");
//        l1.setIsbn("GFA-523-TXi");
//        l1.setFechaPublicacion(year);
//        l1.setUnidadesDisponibles(100);
//
//        Libro l2 = new Libro();
//        l2.setTitulo("Holy Bible");
//        l2.setAutor("Jesus Christ");
//        l2.setNumeroPaginas(1500);
//        l2.setEditorial("Any in the world!");
//        l2.setIsbn("GFA-523-TXi");
//        l2.setFechaPublicacion(year);
//        l1.setUnidadesDisponibles(50);
//        libros.add(l1);
//        libros.add(l2);
//
//        Revista r1 = new Revista();
//        r1.setTitulo("Mag 1");
//        r1.setEditorial("ESE");
//        r1.setPeriodicidad(12);
//        r1.setFechaPublicacion(year);
//        r1.setUnidadesDisponibles(5);
//
//        Revista r2 = new Revista();
//        r2.setTitulo("Mag 25");
//        r2.setEditorial("ESE v2");
//        r2.setPeriodicidad(6);
//        r2.setFechaPublicacion(year);
//        r2.setUnidadesDisponibles(6);
//        revistas.add(r1);
//        revistas.add(r2);
//
//        AudioCD cd1 = new AudioCD();
//        cd1.setTitulo("Physical");
//        cd1.setArtista("Dua Lipa");
//        cd1.setDuracion(120);
//        cd1.setGenero("Pop");
//        cd1.setNumeroCanciones(12);
//        cd1.setUnidadesDisponibles(500);
//
//        AudioCD cd2 = new AudioCD();
//        cd2.setTitulo("Physical");
//        cd2.setArtista("Dua Lipa");
//        cd2.setDuracion(120);
//        cd2.setGenero("Rock");
//        cd2.setNumeroCanciones(7);
//        cd2.setUnidadesDisponibles(10);
//
//        AudioCD cd3 = new AudioCD();
//        cd3.setTitulo("Teest");
//        cd3.setArtista("Dua My Love");
//        cd3.setDuracion(5);
//        cd3.setGenero("ABCD");
//        cd3.setNumeroCanciones(7);
//        cd3.setUnidadesDisponibles(10);
//        cds.add(cd1);
//        cds.add(cd2);
//        cds.add(cd3);
//
//        DVD dvd1 = new DVD();
//        dvd1.setTitulo("Scarface");
//        dvd1.setDirector("Al Pacino");
//        dvd1.setDuracion(120);
//        dvd1.setGenero("War");
//        dvd1.setUnidadesDisponibles(7);
//        dvds.add(dvd1);
//
//        //mediateca = new Mediateca();
//        mediateca.setRevistas(revistas);
//        mediateca.setLibros(libros);
//        mediateca.setAudioCDs(cds);
//        mediateca.setDvds(dvds);
//        mediateca.setNombre("Pinacoteca UDB");
//
//        mediateca.persist();
//        System.exit(0);
    }
}
