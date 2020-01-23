/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia1;

import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class LecturaConsola {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String name = "";
        int age;
        
        System.out.println("Enter your name: ");
        name = reader.next();
        System.out.println("Enter your age: ");
        age = reader.nextInt();
        
        System.out.println("Name:" + name + " Age: " + age);
    }    
}
