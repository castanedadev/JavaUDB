/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia2;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author rickc
 */
public class EjemploCollection {
    public static void main(String[] args) {
        Collection listaMarcasCoche = new ArrayList();
        listaMarcasCoche.add("Audi");
        listaMarcasCoche.add("Prosche");
        listaMarcasCoche.add("Aston Martin");
        listaMarcasCoche.add("Ferrari");
        listaMarcasCoche.add("Mercedes");
        listaMarcasCoche.add("Seat");
        listaMarcasCoche.add("Jeep");
        
        System.out.println("Numero de elementos antes de eliminar => "
                + listaMarcasCoche.size());
        
        System.out.println("Elementos => " + listaMarcasCoche.toString());
        
        listaMarcasCoche.remove("Jeep");
        listaMarcasCoche.remove("Mercedes");
        
        System.out.println("Numero de elementos despues de eliminar" 
                + " Jeep y Mercedes => " + listaMarcasCoche.size());
        
        System.out.println("Elementos => " + listaMarcasCoche.toString());
    }
}
