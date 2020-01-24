/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia1;

/**
 * 
 * @author rickc
 */
public class LecturaParametrosComplementario4 {

    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.println("Param 1: " + args[0]);
            System.out.println("Param 2: " + args[1]);
            System.exit(0);
        }
        System.out.println("Parametros vacios, por favor vuelva a intentar!");
    }
}
