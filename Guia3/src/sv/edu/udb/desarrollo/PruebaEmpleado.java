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
public class PruebaEmpleado {

    public static void main(String[] args) {
        Empleado emp = new Empleado();
        Profesor pro = new Profesor();

        JOptionPane.showMessageDialog(null, "clase -> empleado");
        emp.ingresodatos();
        emp.mostrardatos();

        JOptionPane.showMessageDialog(null, "clase -> profesor");
        pro.ingreso2();
        pro.mostrar2();
    }
}
