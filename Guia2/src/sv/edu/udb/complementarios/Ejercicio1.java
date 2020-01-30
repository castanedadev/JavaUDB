package sv.edu.udb.complementarios;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;

/**
 * Al ingresar la nota de un alumno, se desea saber si este aprobó o no una
 * materia en el colegio. Para aprobar se necesita una nota mayor o igual a 7.0.
 * Diseñe una aplicación en Java que al ingresar la nota muestre con un mensaje
 * en el cual indique si el alumno aprobó o no. Además, si la nota está entre
 * 6.50 y 6.99, tiene la posibilidad de realizar un examen de suficiencia para
 * aprobar.
 *
 * @author rickc
 */
public class Ejercicio1 {

    public static void main(String[] args) {

        float nota = -1;

        do {
            String notaString = JOptionPane.showInputDialog(null,
                    "Ingrese su nota: ",
                    "Calcular nota alumno",
                    JOptionPane.QUESTION_MESSAGE);
            try {
                nota = Float.parseFloat(notaString);
                if (nota <= 0) {
                    JOptionPane.showMessageDialog(null,
                            "Favor ingresar un numero positivo",
                            "Validacion",
                            JOptionPane.WARNING_MESSAGE);
                }
            } catch (HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Favor ingresar solo numeros",
                        "Validacion",
                        JOptionPane.WARNING_MESSAGE);
            }
        } while (nota <= 0); // DO-WHILE ends

        if (nota >= 7.0) {
            JOptionPane.showMessageDialog(null,
                    "Felicidades, usted ha aprobado!",
                    "Resultado",
                    JOptionPane.INFORMATION_MESSAGE);
        } else if (nota >= 6.50 && nota < 7.0) {
            JOptionPane.showMessageDialog(null,
                    "Hmmm, usted tiene una oportunidad mas!",
                    "Resultado",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Lo sentimos, usted ha reprobado :( !",
                    "Resultado",
                    JOptionPane.ERROR_MESSAGE);
        }

    }
}
