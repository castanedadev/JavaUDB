/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.desarrollo;

import javax.swing.JOptionPane;

/**
 *
 * @author rickc
 */
public class SentenciaIF {

    public static void main(String[] args) {
        String datos;
        double sueldo, afp = 0, isss, totalre, nsueldo, renta;
        datos = JOptionPane.showInputDialog("Ingrese el sueldo del empleado (a) ");
        sueldo = Double.parseDouble(datos);

        if (sueldo > 300) {
            afp = (sueldo * 0.0625);
        }

        JOptionPane.showMessageDialog(null,
                "Este empleado tiene un sueldo de: $" + sueldo
                +  " y el descuento del AFP es: $" + afp);
        datos = (String) JOptionPane.showInputDialog(null,
                "Ingrese el sexo: \nSi es masculino(M)\nSi es femenino (F)",
                "Sexo del empleado", JOptionPane.QUESTION_MESSAGE, null,
                new Object[]{"M", "F"}, "F");

        if (datos.equals("M")) {
            isss = sueldo * 0.03;
            renta = sueldo * 0.10;
            totalre = afp + isss + renta;
            nsueldo = sueldo - totalre;

            JOptionPane.showMessageDialog(null, "A este empleado de le retiene: $"
                    + isss + " en concepto de ISSS \nAdemas se le retiene: $" + renta
                    + " en concepto de Renta \n\nLo que hace un total de: $" + totalre
                    + "\nY su nuevo sueldo es de: $" + nsueldo);
        }
    }
}
