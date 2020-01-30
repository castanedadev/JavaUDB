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
public class Complementario3 {

    public static void main(String[] args) {
        String name = "", surname = "", degree = "";
        int age;

        name = JOptionPane.showInputDialog("Ingrese sus nombres: ");
        surname = JOptionPane.showInputDialog("Ingrese sus apellidos: ");
        age = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su edad: "));
        degree = JOptionPane.showInputDialog("Ingrese su carrera");

        StringBuilder sb = new StringBuilder();
        sb.append("\nNombre: ").append(name)
                .append("\nApellido: ").append(surname)
                .append("\nEdad: ").append(age)
                .append("\nCarrera: ").append(degree);

        JOptionPane.showMessageDialog(null,
                sb.toString(), 
                "Informacion recolectada es la siguiente",
                JOptionPane.PLAIN_MESSAGE);

    }
}
