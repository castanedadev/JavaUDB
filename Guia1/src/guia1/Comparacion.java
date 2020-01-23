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
public class Comparacion {

    public static void main(String[] args) {
        String firstNumber = "", secondNumber = "", result;
        int number1, number2;

        firstNumber = JOptionPane.showInputDialog("Enter the 1st number");
        secondNumber = JOptionPane.showInputDialog("Enter the 2nd number");

        number1 = Integer.parseInt(firstNumber);
        number2 = Integer.parseInt(secondNumber);
        result = "";
        if (number1 == number2) {
            result = result + number1 + " == " + number2;
        }
        if (number1 != number2) {
            result = result + number1 + "!=" + number2;
        }
        if (number1 < number2) {
            result = result + "\n" + number1 + "<" + number2;
        }
        if (number1 > number2) {
            result = result + "\n" + number1 + ">" + number2;
        }
        if (number1 <= number2) {
            result = result + "\n" + number1 + "<=" + number2;
        }
        if (number1 >= number2) {
            result = result + "\n" + number1 + ">=" + number2;
        }

        JOptionPane.showConfirmDialog(
                null,
                result,
                "Resultado de la comparación",
                JOptionPane.INFORMATION_MESSAGE);
        
        System.exit(0);

    }
}
