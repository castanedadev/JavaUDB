/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Rick
 */
public class Conexion {

    private Connection conexion = null;
    private Statement s = null;
    private ResultSet rs = null;
    private String query = "";

    public Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/guia7_java?characterEncoding=latin1&useConfigs=maxPerformance", "root", "This#is#4#MySQL");
            s = conexion.createStatement();

            System.out.println("Conexion Exitosa");

        } catch (Exception e1) {
            System.out.println("ERROR:No encuentro el driver de la BD:"
                    + e1.getMessage());
        }
    }

    public ResultSet getResultSet() {
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
