/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia1;

import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class SumaEnteros {

    public static void main(String[] args) {
        String firstNumber = "", secondNumber = "";
        int number1 = -1, number2 = -1, sum;

        // Verify negative numbers
        do {
            firstNumber = JOptionPane.showInputDialog("Enter the 1st number");
            number1 = Integer.parseInt(firstNumber);

            if (number1 < 0) {
                JOptionPane.showMessageDialog(
                        null,
                        "Numero no permitido por ser negativo. Intente de nuevo!",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE);
            }
        } while (number1 < 0);

        do {
            secondNumber = JOptionPane.showInputDialog("Enter the 2nd number");
            number2 = Integer.parseInt(secondNumber);
            if (number2 < 0) {
                JOptionPane.showMessageDialog(
                        null,
                        "Numero no permitido por ser negativo. Intente de nuevo!",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE);
            }
        } while (number2 < 0);

        sum = number1 + number2;

        JOptionPane.showMessageDialog(null, "Sum is:" + sum, "Resultado", JOptionPane.PLAIN_MESSAGE);

        System.exit(0);
    }
}
