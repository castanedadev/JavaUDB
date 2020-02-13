/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.nulos;

import java.sql.ResultSet;
import java.sql.SQLException;
import sv.edu.udb.utils.Conexion;

/**
 *
 * @author usuario
 */
public class InsertarNulos {

    public static void main(String[] args) throws SQLException {
        Conexion con = new Conexion();
        String sql = "insert into empleados values(9,' ','Castaneda',null)";

        con.setQuery(sql);
        sql = "select nombres from empleados ";
        ResultSet rs;

        con.setRs(sql);
        rs = con.getRs();

        String nombre;

        while (rs.next()) {
            nombre = rs.getString(1);

            if (nombre == null) {
                System.out.println("Nombre 'Null': " + nombre);
            } else if (nombre.equals("")) {
                System.out.println("Nombre Vacio: " + nombre);
            } else {
                System.out.println("Nombre Con Datos: " + nombre);
            }

        }

        con.cerrarConexion();
    }
}
