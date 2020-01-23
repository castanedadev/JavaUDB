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
public class Complementario2 {
    
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String name = "", surname = "", degree = "";
        int age;
        
        System.out.println("Ingrese sus nombres: ");
        name = reader.nextLine();
        System.out.println("Ingrese sus apellidos: ");
        surname = reader.nextLine();
        System.out.println("Ingrese su edad: ");
        age = reader.nextInt();
        
        reader.nextLine(); // clean buffer
        
        System.out.println("Ingrese su carrera: ");
        degree = reader.nextLine();
        
        StringBuilder sb = new StringBuilder("\nInformacion recolectada es la siguiente");
        sb.append("\nNombre: ").append(name)
                .append("\nApellido: ").append(surname)
                .append("\nEdad: ").append(age)
                .append("\nCarrera: ").append(degree);
        
        System.out.println(sb.toString());
        
    }
}
