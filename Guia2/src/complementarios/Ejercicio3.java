package complementarios;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;

/**
 * Modificar el ejemplo 9 de tal forma que me permita leer el número de
 * empleados de los cuales voy a ingresar el sueldo, además el programa no
 * permitirá leer datos negativos, así que al ingresar un dato negativo me dará
 * un error y me pedirá de nuevo el dato, si el dato sigue siendo negativo no me
 * permitirá ingresar el sueldo de otro empleado hasta que se ingrese el valor
 * positivo del sueldo.
 *
 * @author rickc
 */
public class Ejercicio3 {

    public static void main(String[] args) {
        String leer;
        double sueldo = 0d, mayor = 0, menor = 10000;
        int contador = 0, numeroEmpleados = -1;

        do {
            String input = JOptionPane.showInputDialog(null,
                    "Cuantos empleados necesita analizar?",
                    "Numero Empleados", JOptionPane.QUESTION_MESSAGE);
            try {
                numeroEmpleados = Integer.parseInt(input);
                if (numeroEmpleados <= 0) {
                    JOptionPane.showMessageDialog(null,
                            "Favor ingresar un numero positivo",
                            "Validacion",
                            JOptionPane.WARNING_MESSAGE);
                }
            } catch (HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Favor ingresar solo numeros",
                        "Validacion",
                        JOptionPane.WARNING_MESSAGE);
            }
        } while (numeroEmpleados <= 0); // DO-WHILE ends

        for (int i = 1; i <= numeroEmpleados; i++) {

            do {
                leer = JOptionPane.showInputDialog(
                        "Ingrese el Sueldo del Empleado " + i);
                try {
                    sueldo = Double.parseDouble(leer);
                    if (sueldo <= 0) {
                        JOptionPane.showMessageDialog(null,
                                "Favor ingresar un numero positivo",
                                "Validacion",
                                JOptionPane.WARNING_MESSAGE);
                    }
                } catch (HeadlessException | NumberFormatException e) {
                    JOptionPane.showMessageDialog(null,
                            "Favor ingresar solo numeros",
                            "Validacion",
                            JOptionPane.WARNING_MESSAGE);
                }
            } while (sueldo <= 0); // DO-WHILE ends

            if (sueldo > 300) {
                contador = contador + 1;
            }
            if (sueldo > mayor) {
                mayor = sueldo;
            }
            if (sueldo < menor) {
                menor = sueldo;
            }
        } // FOR ends

        JOptionPane.showMessageDialog(null, " El sueldo Mayor es de $: "
                + mayor + "\nEl sueldo Menor es de $: " + menor + "\n"
                + contador + " Empleados tienen un sueldo mayor de $300");
    }

}
