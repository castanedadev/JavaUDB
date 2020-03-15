/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.desarrollo;

import java.sql.*;

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
            conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Guia6?characterEncoding=latin1&useConfigs=maxPerformance", "root", "This#is#4#MySQL");
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

    public int setQuery(String sql) throws SQLException {
        return this.s.executeUpdate(sql);
    }

    public void cerrarConexion() throws SQLException {
        conexion.close();
    }
}
