/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.ejercicio2;

import java.sql.SQLException;
import sv.edu.udb.ejercicio2.entities.Developer;

/**
 *
 * @author rickc
 */
public class MisProgramitasSV {

    public static void main(String... args) throws SQLException {
        Developer dev = new Developer();
        System.out.println(dev.agregarEmpleado());
    }
}
