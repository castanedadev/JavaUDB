/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.complementarios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author rickc
 */
public class Estudiante {

    private String nombre;
    private String carnet;
    private int edad;
    private List<String> materias;

    public Estudiante() {
        this.nombre = "Drew Gilroy";
        this.carnet = "DG192036";
        this.edad = 26;
        this.materias = new ArrayList();

    }

    public void agregarListaMaterias() {
        this.materias.add("Sistemas Operativos");
        this.materias.add("Compiladores");
        this.materias.add("Java Avanzado");
        this.materias.add("PHP");
        this.materias.add("Python");
    }

    public void agregarMateria(String nombreMateria) {
        this.materias.add(nombreMateria);
    }

    public void agregarInformacion(String nombre, String carnet, int edad, String... materias) {
        this.nombre = nombre;
        this.carnet = carnet;
        this.edad = edad;
        this.materias.addAll(Arrays.asList(materias));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Estudiante {");
        sb.append("\n\t\tnombre = ").append(nombre);
        sb.append("\n\t\tcarnet = ").append(carnet);
        sb.append("\n\t\tedad = ").append(edad);
        sb.append("\n\t\tmaterias = ").append(materias.size() == 0
                ? "Este alumno no posee materias" : materias);
        sb.append("\n\t}");
        return sb.toString();
    }

}
