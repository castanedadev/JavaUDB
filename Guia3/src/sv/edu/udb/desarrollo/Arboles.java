/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.desarrollo;

/**
 *
 * @author usuario
 */
public class Arboles {

    public Arboles() {
        System.out.println("A generic tree!");
    }

    public Arboles(String type) {
        System.out.println("A tree type: " + type);
    }

    public Arboles(int height) {
        System.out.println("A tree of " + height + "ft heigth");
    }

    public Arboles(String type, int height) {
        System.out.println("A tree of type " + type + " and " + height + "ft of heigth!");
    }
    
    public static void main(String[] args) {
        new Arboles();
        new Arboles("Cypress");
        new Arboles(100);
        new Arboles("Coconut", 26);
    }
}
