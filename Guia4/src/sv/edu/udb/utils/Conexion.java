/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author usuario
 */
public class Conexion {

    private Connection conexion = null;
    private Statement s = null;
    private ResultSet rs = null;
    private String ingresoempleados = "";

    public Conexion() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3308/Guia4?characterEncoding=latin1&useConfigs=maxPerformance", "root", "");
            s = conexion.createStatement();

            System.out.println("Conexion Exitosa");

        } catch (ClassNotFoundException e1) {
            System.out.println("ERROR:No encuentro el driver de la BD:"
                    + e1.getMessage());
        }
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(String sql) {
        try {

            this.rs = s.executeQuery(sql);

        } catch (SQLException e2) {
            System.out.println("ERROR:Fallo en SQL: " + e2.getMessage());
        }
    }

    public void setQuery(String sql) throws SQLException {
        this.s.executeUpdate(sql);
    }

    public void cerrarConexion() throws SQLException {
        conexion.close();
    }
}
