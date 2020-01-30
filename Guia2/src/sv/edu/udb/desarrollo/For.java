/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.desarrollo;

import javax.swing.JOptionPane;

/**
 *
 * @author rickc
 */
public class For {

    public static void main(String[] args) {
        int numero;
        int valor;
        String strnumero = JOptionPane.showInputDialog("Ingrese un Numero: ");
        numero = Integer.parseInt(strnumero);
        valor = numero;
        
        for (int i = 1; i < valor; i++) {
            numero = numero * i;
            System.out.println(numero);
        }
        JOptionPane.showMessageDialog(null, "El factorial de " + valor + " es: "
                + numero, "Respuesta", JOptionPane.INFORMATION_MESSAGE);
        System.out.println("El factorial es " + numero);
    }
}
