/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.auxiliares;

import sv.edu.udb.escritura.Pantalla;

/**
 *
 * @author usuario
 */
public class MandaPantalla {

    public static void main(String[] args) {
        Pantalla primera = new Pantalla();
        primera.conSalto("Esto es un renglon CON salto de linea");
        primera.conSalto("Esta lineatambien tiene salto");
        primera.sinSalto("Linea Continua");
        primera.sinSalto("Linea Continua");
        primera.conSalto("Esta linea si tiene salto!");
        primera.sinSalto("Termina sin salto");
        System.out.println(" Se termina el uso de funciones");
    }
}
