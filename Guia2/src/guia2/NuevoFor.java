/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia2;

/**
 *
 * @author rickc
 */
public class NuevoFor {

    public static void main(String[] args) {
        int Numero[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        int Suma = 0;
        
        for (int indice = 0; indice < 10; indice++) {
            Suma = Suma + Numero[indice];
        }
        System.out.println("Total con for clasico " + Suma);
        Suma = 0;
        System.out.println("Suma reinicializada vale " + Suma);
       
        for (int valor : Numero) {
            Suma += valor;
        }
        System.out.println("Total con for mejorado " + Suma);
    }

}
