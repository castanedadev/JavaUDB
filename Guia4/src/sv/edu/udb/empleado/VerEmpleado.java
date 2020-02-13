/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.empleado;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author usuario
 */
public class VerEmpleado {

    public VerEmpleado() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3308/Guia4?characterEncoding=latin1&useConfigs=maxPerformance", "root", "");

            Statement s = (Statement) conexion.createStatement();
            ResultSet rs = s.executeQuery("select * from empleados");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt(1)
                        + "\nNombre: " + rs.getString(2)
                        + "\nApellidos: " + rs.getString(3)
                        + "\nTelefono: " + rs.getString(4));
                System.out.println("==================================");
            }
            conexion.close();
        } catch (ClassNotFoundException el) {
            System.out.println("Fallo encontrando el driver!");
        } catch (SQLException sql) {
            System.out.println("Fallo en SQL!");
        }
    }

    public static void main(String[] args) {
        new VerEmpleado();
    }

}
