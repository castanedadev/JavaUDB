/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.desarrollo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 *
 * @author rickc
 */
public class EjemploLista {

    public static void main(String[] args) {
        ArrayList<String> listaPersona = new ArrayList();

        listaPersona.add("Marie Curie");
        listaPersona.add("Benjamin Franklin");
        listaPersona.add("Marco Antonio");
        listaPersona.add(1, "Juan Murillo");
        
        System.out.println("USO DE ARRAYLIST");
        System.out.println("Contenido de listaPersona: " + listaPersona + "\n");
       
        int pos = listaPersona.indexOf("Benjamin Franklin");

        System.out.println("El indice de Benjamin Franklin es: " + pos);
        
        boolean check = listaPersona.isEmpty();
        System.out.println("Verificando si ArrayList está vacío: " + check);
        
        int size = listaPersona.size();
        System.out.println("El tamaño de listaPersona es: " + size);
       
        boolean elemento = listaPersona.contains("Marco Antonio");
        System.out.println("Verificando si 'Marco Antonio' está incluido en listaPersona: "
                + elemento);
       
        String item = listaPersona.get(0);
        System.out.println("El elemento con indice 0 es: " + item);

        //Recuperando elementos del ArrayList
        //Usando FOR
        System.out.println("\nRecuperando elementos del ArrayList con FOR");
        for (int i = 0; i < listaPersona.size(); i++) {
            System.out.println("Indice: " + i + " - Elemento: "
                    + listaPersona.get(i));
        }
        //Segunda forma: Usando FOREACH
        System.out.println("\nRecuperando elementos del ArrayList con FOREACH");
        for (String persona : listaPersona) {
            System.out.println("Elemento: " + persona);
        }
        
        //Tercera forma: Usando ITERATOR
        System.out.println("\nRecuperando elementos del ArrayList con ITERATOR");
        for (Iterator<String> it = listaPersona.iterator(); it.hasNext();) {
            System.out.println("Elemento: " + it.next());
        }
       
        listaPersona.set(1, "Nikola Tesla");
        System.out.println("\nArrayList después de reemplazo: " + listaPersona);
        
        listaPersona.remove(0);
        System.out.println("\nArrayList después de eliminar elemento 0: " + listaPersona);

        String[] simpleArray = listaPersona.toArray(new String[listaPersona.size()]);
        System.out.println("\nEl objeto Array creado es: " + Arrays.toString(simpleArray));
    }

}
