/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.desarrollo;

import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class Persona {

    private String nombre;
    private String apellido;
    private String edad;

    public Persona() {
        this.nombre = "Ricardo";
        this.apellido = "Castaneda";
        this.edad = "27";
    }

    public Persona(String nombre, String apellido, String edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public void mostrarDatos() {
        System.out.println("Su nombre es: " + nombre);
        System.out.println("Su apellido es: " + apellido);
        System.out.println("Su edad es: " + edad);       
        System.out.println("****************************");
    }

    public void ingresoDatos() {
        nombre = JOptionPane.showInputDialog("Ingrese el nombre: ");
        apellido = JOptionPane.showInputDialog("Ingrese el apellido: ");
        edad = JOptionPane.showInputDialog("Ingrese su edad: ");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Persona person1 = new Persona();
        Persona person2 = new Persona("Claudia", "Gil", "24");
        person1.mostrarDatos();
        person1.ingresoDatos();
        person1.mostrarDatos();
        person2.mostrarDatos();
        person2.apellido = "Hill";
        person2.mostrarDatos();
    }

}
