/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.desarrollo;

import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class Empleado {

    private String nombre;
    private String apellido;

    public void mostrardatos() {
        JOptionPane.showConfirmDialog(null, nombre + " " + apellido);
    }

    public void ingresodatos() {
        nombre = JOptionPane.showInputDialog("Ingrese el Nombre");
        apellido = JOptionPane.showInputDialog("Ingrese el Apellido");
    }
}

class Profesor extends Empleado {

    int sueldo;

    public void mostrar2() {
        mostrardatos();//Metodo heredado
        JOptionPane.showMessageDialog(null, sueldo);
    }

    public void ingreso2() {
        ingresodatos();//Metodo heredado
        String s = JOptionPane.showInputDialog("Ingrese el sueldo");
        sueldo = Integer.parseInt(s);
    }
}
