/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.ejercicio2.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

/**
 *
 * @author rickc
 */
public abstract class Conexion {

    private static final Logger LOGGER = Logger.getLogger(Conexion.class.toGenericString());
    private static Connection conexion = null;
    private static Statement statement = null;
    private static ResultSet resultset = null;

    public static void crearConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            if (null == conexion) {
                conexion = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3308/pp1", "root", "");
                statement = conexion.createStatement();
            }

            LOGGER.info("Conexion exitosa a la base de datos");
        } catch (ClassNotFoundException cnfe) {
            LOGGER.warning("No se ha encontrad el driver de la BD");
            LOGGER.warning(cnfe.getMessage());
        } catch (SQLException sqle) {
            LOGGER.warning(sqle.getMessage());
        }
    }

    public ResultSet getResultSet() {
        return resultset;
    }

    public static void executeQuery(String sql) {
        try {
            Conexion.resultset = statement.executeQuery(sql);
        } catch (SQLException sqle) {
            LOGGER.severe("Fallo en SQL");
            LOGGER.severe(sqle.getMessage());
        }
    }

    public static void executeUpdate(String sql) throws SQLException {
        Conexion.statement.executeUpdate(sql);
    }

    public static void cerrarConexion() throws SQLException {
        conexion.close();
    }
}
