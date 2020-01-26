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
public class Switch1 {

    public static void main(String[] args) {
        int a = 1;
        int b = 1;
        char op = '+';// Puede cambiar el operador aritmético…
        System.out.print("El resultado es : ");
        switch (op) {
            case '+':
                System.out.println(a + b);
                break;
            case '-':
                System.out.println(a - b);
                break;
            case '*':
                System.out.println(a * b);
                break;
            case '/':
                System.out.println(a / b);
                break;
            default:
                System.out.println("Error");
                break;
        }
    }
}
