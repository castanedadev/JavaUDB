/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia2;

import java.util.Scanner;

/**
 *
 * @author rickc
 */
public class ControlIf {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int var1, var2;
        System.out.println("Ingrese #1: ");
        var1 = reader.nextInt();
        System.out.println("Ingrese #2: ");
        var2 = reader.nextInt();
        if (var1 == var2) {
            System.out.println("Los numeros ingresados son iguales!");
        } else {
            System.out.println("Los numerosa ingresados no son iguales!");
        }
    }

}
