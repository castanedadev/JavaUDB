/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.desarrollo;

class Clase {

    static int contador;

    Clase() {
        contador++;
    }
}

/**
 *
 * @author usuario
 */
public class Codigo {

    public static void main(String[] args) {
        Clase uno = new Clase();
        Clase dos = new Clase();
        Clase tres = new Clase();
        Clase cuatro = new Clase();

        System.out.println("Hemos declarado: " + cuatro.contador + " objetos");
    }
}
