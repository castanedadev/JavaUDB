/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.ejercicio2;

import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author rickc
 */
public class Utils {

    private static final Logger LOGGER = Logger.getLogger(Utils.class.toGenericString());

    public static void validarString(String inputMessage) {
        String valor;
        do {
            valor = JOptionPane.showInputDialog(inputMessage);
        } while (null == valor || valor.equals(""));
    }

    public static void validarNumeroDecimal(String inputMessage) {
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

    }
}
