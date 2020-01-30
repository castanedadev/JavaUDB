package sv.edu.udb.complementarios;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 * En una tienda se realizan diferentes descuentos a sus clientes al momento de
 * cancelar en caja. Cuando se dispone a cancelar tiene la oportunidad de sacar
 * una bolita y dependiendo del color de la misma se le puede aplicar un
 * determinado descuento. Si la bolita es roja, se le aplica un 10% de descuento
 * sobre la compra; si la bola es verde, se le aplica un 5% de descuento y si la
 * bolita es blanca, no tiene descuento y se le da las gracias por participar.
 *
 * @author rickc
 */
public class Ejercicio2 {

    enum Color {
        RED, GREEN, WHITE;
    }
    static Color[] bolitas = Color.values();

    public static void main(String[] args) {
        float total = Float.valueOf(JOptionPane.showInputDialog(null,
                "Ingrese el total: ", "Realizar Cobro",
                JOptionPane.QUESTION_MESSAGE));

        float descuento = 0; // blanca por defecto - sin descuento        
        String[] options = {"Si, por favor!", "No, gracias."};

        // 0=yes, 1=no, 2=cancel
        int input = JOptionPane.showOptionDialog(
                null, "Aplicar descuento", "Sacar Bolita?",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]);

        if (input == 0) {
            Color bolitaSeleccionada = sacarBolita();

            switch (bolitaSeleccionada) {
                case RED:
                    descuento = 0.10f;
                    break;
                case GREEN:
                    descuento = 0.05f;
                    break;
                case WHITE:
                    descuento = 0.00f;
                    JOptionPane.showMessageDialog(null,
                            "Gracias por participar! \nSu bolita no tenia"
                            + " descuento en su compra.");
                    break;
                default:
                    System.out.println("Esa bolita es desconocida!");
            }
        }

        JOptionPane.showMessageDialog(null,
                "Hola, su total sin descuento es: $" + total
                + "\nSe le aplicara un descuento de: "
                + (descuento * 100) + "%"
                + "\nSu nuevo total es: $" + ((1 - descuento) * total),
                "Resultado", JOptionPane.INFORMATION_MESSAGE);

    }

    /**
     * Genera un numero random y devuelve el color del enum segun index.
     *
     * @return Color basado en index.
     */
    private static Color sacarBolita() {
        int randomIndex = new Random().nextInt(bolitas.length);
        return bolitas[randomIndex];
    }
}
