/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.notas;

/**
 *
 * @author usuario
 */
public class Principal {

    public static void main(String[] args) {
        Estudiante estudiante = new Estudiante("Walter", "Samuel");
        estudiante.setNota1(8);
        estudiante.setNota2(15);
        estudiante.setNota3(10);
        System.out.println("Notas de " + estudiante.getNombre() + " " + estudiante.getApellido());
        System.out.println("Nota 1: " + estudiante.getNota1());
        System.out.println("Nota 2: " + estudiante.getNota2());
        System.out.println("Nota 3: " + estudiante.getNota3());
    }
}
