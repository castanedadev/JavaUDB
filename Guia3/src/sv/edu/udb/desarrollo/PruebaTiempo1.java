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
public class PruebaTiempo1 {

    public static void main(String[] args) {
        Tiempo1 time = new Tiempo1();
        String salida = "La hora universal inicial es: "
                + time.aStringUniversal() + "\nLa hora estandar inicial es: "
                + time.aStringEstandar();
        time.establecerHora(13, 27, 6);

        salida += "\nLa hora universal despues de establecerHora es: "
                + time.aStringUniversal() + "\nLa hora estandar despues de "
                + "establecerHora es: " + time.aStringEstandar();
        
        time.establecerHora(96, 96, 96);
        salida += "\nDespues de intentar ajustes validos: "
                + "\nHora Universal: " + time.aStringUniversal() 
                + "\nHora Estandar: " + time.aStringEstandar();
        
        JOptionPane.showMessageDialog(null, salida, 
                "Prueba de la clase Tiempo1", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
