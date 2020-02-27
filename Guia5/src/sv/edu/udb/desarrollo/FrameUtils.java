/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.desarrollo;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Rick
 */
public class FrameUtils {

    public static ImageIcon getScaledImage(Image srcImg, int w, int h) {
        Image resizedImage = srcImg.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }
    
     public static double sumar(double op1, double op2) {
        return op1 + op2;
    }

    public static double restar(double op1, double op2) {
        return op1 - op2;
    }

    public static double multiplicar(double op1, double op2) {
        return op1 * op2;
    }

    public static double dividir(double op1, double op2) {
        return op1 / op2;
    }
}
