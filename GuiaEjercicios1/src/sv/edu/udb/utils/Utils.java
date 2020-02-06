/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.utils;

import java.util.List;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author rickc
 */
public class Utils {

    public static String buildGUI(List options, String message) {
        JOptionPane optionPane = new JOptionPane(
                new JLabel((null != message) ? message : "Por favor seleccione una opcion: \n", JLabel.CENTER),
                JOptionPane.QUESTION_MESSAGE,
                JOptionPane.YES_NO_OPTION,
                null,
                options.toArray(),
                options.get(0));
        JDialog dialog = optionPane.createDialog("Menu - Java Avanzado 2020");
        dialog.setModal(true);
        dialog.setVisible(true);

        return optionPane.getValue().toString();
    }

//    public static String crearMaterialMenu() {
//        
//
//        JOptionPane optionPane = new JOptionPane(
//                new JLabel("Por favor seleccione una opcion: \n", JLabel.CENTER),
//                JOptionPane.QUESTION_MESSAGE,
//                JOptionPane.YES_NO_OPTION,
//                null,
//                opcionesTipoMaterial,
//                opcionesTipoMaterial[0]);
//        JDialog dialog = optionPane.createDialog("Mediateca - Agregar Material");
//        dialog.setModal(true);
//        dialog.setVisible(true);
//
//        return optionPane.getValue().toString();
//    }
}
