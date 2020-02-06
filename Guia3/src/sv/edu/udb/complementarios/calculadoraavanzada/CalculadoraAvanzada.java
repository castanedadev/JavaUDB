/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.complementarios.calculadoraavanzada;

/**
 *
 * @author rickc
 */
public class CalculadoraAvanzada {

    public static double potencia(double op1, double op2) {
        return Math.pow(op2, op2);
    }

    public static double opuesto(double op1) {
        return op1 * -1;
    }

    public static double factorial(double op1) {
        int i = 1;
        long factorial = 1;
        while (i <= op1) {
            factorial *= i;
            i++;
        }
        return factorial;
    }

}
