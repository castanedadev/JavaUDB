/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.ejercicio3;

import java.io.FileNotFoundException;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBException;
import sv.edu.udb.ejercicio3.marshalling.Mediateca;
import sv.edu.udb.utils.Utils;
import sv.edu.udb.utils.OpcionMenu;

/**
 *
 * @author rickc
 */
public class Menu {

    private static final Logger LOGGER = Logger.getLogger(Menu.class.toGenericString());

    public static void main(String[] args) throws JAXBException, FileNotFoundException {
        Mediateca mediateca = new Mediateca();

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
                    Utils.agregar();
                    mediateca.setNombre("Pinacoteca UDB");
                    mediateca.persist();
                    break;
                case MODIFICAR:
                    Utils.modificarMaterial();
                    mediateca.persist();
                    break;
                case LISTAR:
                    LOGGER.info(mediateca.toString());
                    break;
                case BORRAR:
                    Utils.borrarPorCodigo();
                    mediateca.persist();
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
