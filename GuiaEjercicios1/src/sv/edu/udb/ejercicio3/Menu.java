/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.ejercicio3;

import java.io.FileNotFoundException;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.xml.bind.JAXBException;
import sv.edu.udb.ejercicio3.marshalling.Mediateca;
import sv.edu.udb.utils.Utils;
import sv.edu.udb.utils.Material;
import sv.edu.udb.utils.OpcionMenu;

/**
 *
 * @author rickc
 */
public class Menu {

    private static final Logger LOGGER = Logger.getLogger(Menu.class.toGenericString());

    public static void main(String[] args) throws JAXBException, FileNotFoundException {
        Mediateca mediateca = new Mediateca();
        List<Libro> libros = new ArrayList();
        List<Revista> revistas = new ArrayList();
        List<AudioCD> cds = new ArrayList();
        List<DVD> dvds = new ArrayList();

        List<String> optionList = new ArrayList<>();
        optionList.add(OpcionMenu.AGREGAR.getDescripcion());
        optionList.add(OpcionMenu.MODIFICAR.getDescripcion());
        optionList.add(OpcionMenu.LISTAR.getDescripcion());
        optionList.add(OpcionMenu.BORRAR.getDescripcion());
        optionList.add(OpcionMenu.BUSCAR.getDescripcion());
        optionList.add(OpcionMenu.SALIR.getDescripcion());

        // Leer archivo existente ?
        if ((args.length > 0) && Boolean.parseBoolean(args[0])) {
            LOGGER.info("Leyendo archivo...");
            mediateca.unmarshall();
            LOGGER.info("Mediateca cargada!");
        }

        // Iterar indefinidamente hasta que usuario seleccione: SALIR
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

            LOGGER.info(opcionSeleccionada.getDescripcion());
            
            switch (opcionSeleccionada) {
                case AGREGAR:
                    String tipoMaterial = Utils.buildGUI(
                            Arrays.asList(Material.values()).subList(0, 2),
                            "Que tipo de material desea agregar?");

                    LOGGER.info(tipoMaterial);

                    if (tipoMaterial.equals(Material.ESCRITO.name())) {
                        String materialEscrito = Utils.buildGUI(
                                Arrays.asList(Material.values()).subList(2, 4),
                                "Que tipo de material escrito desea agregar: ");

                        LOGGER.info(materialEscrito);

                        if (materialEscrito.equals(Material.LIBRO.name())) {
                            libros.add(Utils.agregarMaterialEscrito(Material.LIBRO));
                        } else {
                            revistas.add(Utils.agregarMaterialEscrito(Material.REVISTA));
                        }

                    } else if (tipoMaterial.equals(Material.AUDIOVISUAL.name())) {
                        String materialAudiovisual = Utils.buildGUI(
                                Arrays.asList(Material.values()).subList(4, Material.values().length),
                                "Que tipo de material audiovisual desea agregar: ");

                        LOGGER.info(materialAudiovisual);

                        if (materialAudiovisual.equals(Material.CD.name())) {
                            cds.add(Utils.agregarMaterialAudioVisual(Material.CD));
                        } else {
                            dvds.add(Utils.agregarMaterialAudioVisual(Material.DVD));
                        }
                    }

                    // Si la lista no esta vacia escribir material a xml
                    mediateca.setRevistas(revistas);
                    mediateca.setLibros(libros);
                    mediateca.setAudioCDs(cds);
                    mediateca.setDvds(dvds);
                    mediateca.setNombre("Pinacoteca UDB");

                    mediateca.persist();
                    LOGGER.info("Mediateca actualizada con el nuevo material! ");
                    break;
                case MODIFICAR:
                    Utils.modificarMaterial();
                    break;
                case LISTAR:
                    LOGGER.info(mediateca.toString());
                    break;
                case BORRAR:
                    Utils.borrarPorCodigo();
                    break;
                case BUSCAR:
                    Utils.buscarPorCodigo();
                    break;
                case SALIR:
                    System.exit(0);
                    break;
                case CERRAR:
                    LOGGER.warning("Opcion no requerida!");
                    break;
                default:
                    throw new AssertionError();
            }

        } while (true);
    }
}
