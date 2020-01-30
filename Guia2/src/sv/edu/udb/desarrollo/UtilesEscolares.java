/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.desarrollo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author rickc
 */
public class UtilesEscolares {

    public static void main(String[] args) {
        HashMap<Integer, String> hmap;
        hmap = new HashMap<>();

        hmap.put(12, "Crayolas");
        hmap.put(2, "Lápices");
        hmap.put(7, "Borradores");
        hmap.put(49, "Colores");
        hmap.put(3, "Boligrafos");
        
        System.out.println("Contenido de HashMap: ");

        Iterator iterador = hmap.entrySet().iterator();
        while (iterador.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterador.next();
            System.out.println("Clave: " + mentry.getKey() 
                    + " - Valor: " + mentry.getValue());
        }
        
        // Alternativa iteracion anterior 
        //for (Map.Entry mentry : hmap.entrySet()) 

        String var = hmap.get(2);
        System.out.println("\nValor asociado a clave 2: " + var);        
        hmap.remove(3);
        System.out.println("\nHashMap después de eliminar elemento con clave 3:");
        
        Set set2 = hmap.entrySet();
        Iterator iterador2 = set2.iterator();
        while (iterador2.hasNext()) {
            Map.Entry mentry2 = (Map.Entry) iterador2.next();
            System.out.println("Clave: " + mentry2.getKey() + " - Valor: " + mentry2.getValue());
        }
    }
}
