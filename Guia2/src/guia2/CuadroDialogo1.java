/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia2;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;

/**
 *
 * @author rickc
 */
public class CuadroDialogo1 {

    public static void main(String[] args) {
        while (true) {
            try {
                String nombre = JOptionPane.showInputDialog("Como te llamas?");
                String entrada = JOptionPane.showInputDialog("cuántos años tienes");
                int edad = Integer.parseInt(entrada);
                JOptionPane.showMessageDialog(null,
                        "Hola, " + nombre + ". El año que viene tendrás "
                        + (edad + 1) + "años",
                        "Resultado", JOptionPane.INFORMATION_MESSAGE);

            } catch (HeadlessException | NumberFormatException e) {
                System.out.println("Error en algun dato de entrada");
                JOptionPane.showMessageDialog(null,
                        "Error en algun dato de entrada",
                        "Error", JOptionPane.ERROR_MESSAGE);

                String seleccion = (String) JOptionPane.showInputDialog(
                        null,
                        "Desea Salir",
                        "Seleccione una opcion",
                        JOptionPane.QUESTION_MESSAGE,
                        null, // null para icono defecto
                        new Object[]{"Si", "No"},
                        "si");
                if (seleccion.equals("Si")) {
                    System.exit(0);
                    break;
                }
            }//fin de catch
        }//fin de while
    }
}
