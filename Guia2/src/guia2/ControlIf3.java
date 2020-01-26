/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia2;

import javax.swing.JOptionPane;

/**
 *
 * @author rickc
 */
public class ControlIf3 {

    public static void main(String[] args) {
        int result = JOptionPane.showConfirmDialog(null, "Reemplazar seleccion existente?");
        System.out.println("El numero devuelto es: " + result);
        
        if(result == JOptionPane.YES_OPTION) {
            System.out.println("Yes!");
        } else if (result == JOptionPane.NO_OPTION) {
            System.out.println("No!!");
        } else if (result == JOptionPane.CANCEL_OPTION) {
            System.out.println("Cancel!");
        } else if (result == JOptionPane.CLOSED_OPTION) {
            System.out.println("Closed!");
        }
    }
}
