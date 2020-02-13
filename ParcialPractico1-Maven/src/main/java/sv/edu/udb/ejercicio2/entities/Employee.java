/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.ejercicio2.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import sv.edu.udb.ejercicio2.Utils;

/**
 *
 * @author rickc
 */
public abstract class Employee {

    private static final Logger LOGGER = Logger.getLogger(Employee.class.toGenericString());
    private String nit;
    private String dui;
    private String nombres;
    private String apellidos;
    private int tipoEmpleado;
    private double salarioBase;

    private List<Developer> devs = new ArrayList<>();

    private List<OtherEmp> OtherEmp = new ArrayList<>();

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public int getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(int tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    boolean validarDUI(String dui) {
        String duiPattern = "^\\d{8}-\\d{1}$";
        Pattern pattern = Pattern.compile(duiPattern);
        return pattern.matcher(dui).matches();
    }

    boolean validarNIT(String nit) {
        String nitPattern = "^\\d{4}-\\d{6}-\\d{3}-\\d{1}$";
        Pattern pattern = Pattern.compile(nitPattern);
        return pattern.matcher(nit).matches();
    }

    public boolean agregarEmpleado() {

//        Utils.validarString("Ingrese los nombres del empleado: ");
//        Utils.validarString("Ingrese los apellidos del empleado: ");
//        Utils.validarString("Ingrese el DUI: ");
        return validarNIT("0501-060492-103");
//        Utils.validarString("Ingrese el NIT: ");
//        Utils.validarNumeroDecimal("Ingrese el salario base: ");

    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
}
