/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.ejercicio2;

import static java.lang.Boolean.FALSE;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import sv.edu.udb.ejercicio2.entities.Employee;

/**
 *
 * @author rickc
 */
public class Utils {

    private static final Logger LOGGER = Logger.getLogger(Utils.class.toGenericString());

    public static String validarStringConPattern(String inputMessage, String expectedPattern) {
        String inputConPattern;
        boolean patternAccepted = false;
        do {
            inputConPattern = validarString(inputMessage);
            Pattern pattern = Pattern.compile(expectedPattern);
            patternAccepted = pattern.matcher(inputConPattern).matches();
            if (!patternAccepted) {
                JOptionPane.showMessageDialog(null,
                        "Favor ingresar el número de documento con formato válido.",
                        "Formato Numero",
                        JOptionPane.WARNING_MESSAGE);
            }
        } while (patternAccepted == FALSE);
        return inputConPattern;
    }

    public static String validarString(String inputMessage) {
        String valor;
        do {
            valor = JOptionPane.showInputDialog(inputMessage);
        } while (null == valor || valor.equals(""));

        return valor;
    }

    public static double validarNumeroDecimal(String inputMessage) {
        double numero = -1d;
        do {
            String valor = JOptionPane.showInputDialog(inputMessage);
            try {
                numero = Double.parseDouble(valor);

                if (numero <= 0d) {
                    JOptionPane.showMessageDialog(null,
                            "Favor ingresar solo números positivos.",
                            "Formato Numero",
                            JOptionPane.WARNING_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null,
                        "Favor ingresar solamente números.",
                        "Formato Numero",
                        JOptionPane.WARNING_MESSAGE);
                LOGGER.warning(ex.getMessage());
            }
        } while (numero <= 0d);

        return numero;
    }

    static void crearMenuPrincipal() throws SQLException {
        do {
            List<String> optionList = new ArrayList<>();
            optionList.add(OpcionMenu.AGREGAR.getDescripcion());
            optionList.add(OpcionMenu.CALCULAR.getDescripcion());
            optionList.add(OpcionMenu.VER.getDescripcion());
            optionList.add(OpcionMenu.SALIR.getDescripcion());

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
                    Employee.agregarEmpleado();
                    break;
                case CALCULAR:
                    Employee.buscarEmpleado();
                    break;
                case VER:
                    break;
                case SALIR:
                    System.exit(0);
                    break;
                case CERRAR:
                    LOGGER.warning("Opcion no requerida.");
                    break;
                default:
                    throw new AssertionError();
            }
        } while (true);

    }

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
}
