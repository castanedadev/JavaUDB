/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.complementarios;

import sv.edu.udb.complementarios.calculadorabasica.CalculadoraBasica;
import sv.edu.udb.complementarios.calculadoraavanzada.CalculadoraAvanzada;

/**
 *
 * @author rickc
 */
public class Ejercicio2_InstanciarCalculadoras {

    public static void main(String[] args) {
        System.out.println("--- Calculadora Basica ---");
        System.out.println("Suma: " + CalculadoraBasica.sumar(20, 5));
        System.out.println("Resta: " + CalculadoraBasica.restar(12, 6));
        System.out.println("Multiplicacion: " + CalculadoraBasica.multiplicar(4, 4));
        System.out.println("Division: " + CalculadoraBasica.dividir(525.60, 4));

        System.out.println("--- Calculadora Avanzada ---");
        System.out.println("Potencia: " + CalculadoraAvanzada.potencia(2, 5));
        System.out.println("Opuesto: " + CalculadoraAvanzada.opuesto(10));
        System.out.println("Factorial: " + CalculadoraAvanzada.factorial(5));
    }
}
