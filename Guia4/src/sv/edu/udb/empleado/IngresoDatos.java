/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.empleado;

import java.sql.Statement;
import static java.lang.Boolean.TRUE;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import sv.edu.udb.utils.MatchTelephone;

/**
 *
 * @author usuario
 */
public class IngresoDatos {

    private int id;
    private String ids;
    private String nombre;
    private String apellido;
    private String telefono;

    private Connection connection;
    private ResultSet rs;
    private Statement s;

    public IngresoDatos() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/guia4?characterEncoding=latin1&useConfigs=maxPerformance", "root", "");

            s = (Statement) connection.createStatement();
            ingreso();
            s.executeUpdate("Insert into Empleados values("
                    + id + ",\"" + nombre + "\",\""
                    + apellido + "\",\"" + telefono + "\")"
            );
            JOptionPane.showMessageDialog(null, "Persona Ingresada Correctamente");
        } catch (ClassNotFoundException el) {
            System.out.println("ERROR:No encuentro el driver de la BD");
            System.exit(0);
        } catch (SQLException sql) {
            System.out.println("Fallo en SQL!");
            System.exit(0);
        }
    }

    public final void ingreso() {
        ids = JOptionPane.showInputDialog("Ingrese el ID");
        id = Integer.parseInt(ids);
        nombre = JOptionPane.showInputDialog("Ingrese el Nombre");
        apellido = JOptionPane.showInputDialog("Ingrese el Apellido");
        telefono = JOptionPane.showInputDialog("Ingrese su Telefono");
        do {
            if (MatchTelephone.comparePhone(telefono) == TRUE) {
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Numero de Telefono invalido");
                telefono = JOptionPane.showInputDialog("Ingrese su Telefono");
            }
        } while (TRUE);
    }

}
