/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.desarrollo;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Rick
 */
public class Ejercicio1 extends JFrame {
    public Ejercicio1() {
        JLabel lblHelloW = new JLabel("Hola");
        add(lblHelloW);
        
        this.setSize(200,200);
        this.setTitle("JFrame - Ejercicio I");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        
    }
    public static void main(String[] args) {
        new Ejercicio1();
    }
}
