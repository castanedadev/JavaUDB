package sv.edu.udb.complementarios;

import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 * Desarrollar una aplicación que utilice un HashMap y en el cual se permita
 * manejar la información de los alumnos de la materia de Java Avanzado, para
 * este caso se necesita tener una lista siendo la llave el “Carnet”, esta
 * aplicación deberá de tener un menú en el cual se tenga como opciones las que
 * se detallan a continuación:
 *
 * <ul>
 * <li>Ingreso de estudiante</li>
 * <li>Ver estudiante</li>
 * <li>Buscar Estudiante</li>
 * <li>Salir</li>
 * </ul>
 *
 * @author rickc
 */
public class Ejercicio4 {

    private enum OpcionMenu {
        INGRESAR_ESTUDIANTE,
        VER_ESTUDIANTE,
        BUSCAR_ESTUDIANTE,
        SALIR,
        CERRAR_MENU
    }

    public static void main(String[] args) {
        int opcionMenu = -1;
        float examen1 = -1f, examen2 = -1f, examen3 = -1f;
        OpcionMenu opcionSeleccionada = OpcionMenu.SALIR;

        // Creando Hashmap para guardar estudiantes
        Map<String, Estudiante> estudiantes = new HashMap<>();
        //Generando opciones de mediante una lista
        List<String> optionList = new ArrayList<>() {
            {
                add("Ingreso de estudiante");
                add("Ver estudiante");
                add("Buscar Estudiante");
                add("Salir");
            }
        };

        do {
            opcionMenu = JOptionPane.showOptionDialog(
                    null,
                    "En esta seccion hay " + estudiantes.size() + " estudiantes."
                    + "\n\nPor favor seleccione una opcion: \n",
                    "Menu - Java Avanzado 2020",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    optionList.toArray(),
                    optionList.get(0));
            if (opcionMenu == -1) {
                opcionSeleccionada = OpcionMenu.values()[4];
            } else {
                opcionSeleccionada = OpcionMenu.values()[opcionMenu];
            }

            System.out.println("Accion a ejecutar: " + opcionSeleccionada);
            switch (opcionSeleccionada) {
                case BUSCAR_ESTUDIANTE:
                    String carnetBusqueda = JOptionPane.showInputDialog(null,
                            "Ingrese Carnet de Estudiante: ",
                            "Busqueda", JOptionPane.QUESTION_MESSAGE)
                            .toUpperCase();

                    if (estudiantes.containsKey(carnetBusqueda)) {
                        JOptionPane.showMessageDialog(null,
                                "El Estudiante si esta inscrito en esta materia!",
                                "Encontrado", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "No se encontro ningun estudiante bajo "
                                + "ese numero de carnet!!", "No encontrado",
                                JOptionPane.WARNING_MESSAGE);
                    }
                    break;
                case INGRESAR_ESTUDIANTE:
                    String carnet = JOptionPane.showInputDialog("Ingrese Carnet: ");
                    String nombres = JOptionPane.showInputDialog("Ingrese Nombres: ");
                    String apellidos = JOptionPane.showInputDialog("Ingrese Apellidos: ");
                    String edad = JOptionPane.showInputDialog("Ingrese Edad: ");

                    //Validaciones notas positivas y no mayor a 10
                    do {

                        try {
                            examen1 = Float.parseFloat(JOptionPane.showInputDialog("Ingrese Nota 1: "));
                            if (examen1 < 0 || examen1 > 10) {
                                JOptionPane.showMessageDialog(null,
                                        "Favor ingresar un numero valido",
                                        "Validacion",
                                        JOptionPane.WARNING_MESSAGE);
                            }
                        } catch (HeadlessException | NumberFormatException e) {
                            JOptionPane.showMessageDialog(null,
                                    "Favor ingresar solo numeros",
                                    "Validacion",
                                    JOptionPane.WARNING_MESSAGE);
                        }
                    } while (examen1 < 0 || examen1 > 10);

                    do {
                        try {
                            examen2 = Float.parseFloat(JOptionPane.showInputDialog("Ingrese Nota 2: "));
                            if (examen2 < 0 || examen2 > 10) {
                                JOptionPane.showMessageDialog(null,
                                        "Favor ingresar un numero valido",
                                        "Validacion",
                                        JOptionPane.WARNING_MESSAGE);
                            }
                        } catch (HeadlessException | NumberFormatException e) {
                            JOptionPane.showMessageDialog(null,
                                    "Favor ingresar solo numeros",
                                    "Validacion",
                                    JOptionPane.WARNING_MESSAGE);
                        }
                    } while (examen2 < 0 || examen2 > 10);

                    do {
                        try {
                            examen3 = Float.parseFloat(JOptionPane.showInputDialog("Ingrese Nota 3: "));
                            if (examen3 < 0 || examen3 > 10) {
                                JOptionPane.showMessageDialog(null,
                                        "Favor ingresar un numero valido",
                                        "Validacion",
                                        JOptionPane.WARNING_MESSAGE);
                            }
                        } catch (HeadlessException | NumberFormatException e) {
                            JOptionPane.showMessageDialog(null,
                                    "Favor ingresar solo numeros",
                                    "Validacion",
                                    JOptionPane.WARNING_MESSAGE);
                        }
                    } while (examen3 < 0 || examen3 > 10);

                    //Intanciando clase Estudiante para nuevo registro
                    Estudiante nuevoEstudiante = new Estudiante();
                    nuevoEstudiante.setNombres(nombres);
                    nuevoEstudiante.setApellidos(apellidos);
                    nuevoEstudiante.setEdad(edad);
                    nuevoEstudiante.setExamen1(examen1);
                    nuevoEstudiante.setExamen2(examen2);
                    nuevoEstudiante.setExamen3(examen3);

                    estudiantes.put(carnet.toUpperCase(), nuevoEstudiante);

                    JOptionPane.showMessageDialog(null,
                            "Estudiante con carnet: " + carnet.toUpperCase()
                            + " ha sido ingresado!");
                    break;
                case VER_ESTUDIANTE:
                    String verCarnet = JOptionPane.showInputDialog(null,
                            "Ingrese Carnet de Estudiante: ",
                            "Busqueda", JOptionPane.QUESTION_MESSAGE)
                            .toUpperCase();

                    if (estudiantes.containsKey(verCarnet)) {
                        Estudiante verEstudiante = estudiantes.get(verCarnet);
                        JOptionPane.showMessageDialog(null,
                                "Datos del estudiante: \n"
                                + "\n  Carnet => " + verCarnet
                                + verEstudiante.toString(),
                                "Ver Estudiante - " + verCarnet,
                                JOptionPane.INFORMATION_MESSAGE
                        );
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Estudiante no encontrado en esta seccion",
                                "Advertencia", JOptionPane.WARNING_MESSAGE);
                    }
                    break;

                case SALIR:
                    int confirmaSalir = JOptionPane.showConfirmDialog(
                            null, "Esta seguro que desea salir?");
                    if (confirmaSalir == 0) {
                        System.out.println("Saliendo...");
                        System.exit(0);
                    }
                    break;
                case CERRAR_MENU:
                    System.out.println("Cerrando menu...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion no definida!");
            }
        } while (true); // DO-WHILE ends
    }
}
