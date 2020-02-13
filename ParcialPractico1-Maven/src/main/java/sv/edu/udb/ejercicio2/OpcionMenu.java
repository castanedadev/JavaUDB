/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.ejercicio2;

/**
 *
 * @author rickc
 */
public enum OpcionMenu {
    AGREGAR("Agregar Empleado"),
    CALCULAR("Calcular Salario"),
    VER("Ver ultimo pago"),
    SALIR("Salir"),
    CERRAR("Cerrar"),
    TIPO_PROGRAMADOR("Analista Programador"),
    TIPO_OTROS("Otros");

    private OpcionMenu(String descripcion) {
        this.descripcion = descripcion;
    }

    private final String descripcion;

    public String getDescripcion() {
        return descripcion;
    }

}
