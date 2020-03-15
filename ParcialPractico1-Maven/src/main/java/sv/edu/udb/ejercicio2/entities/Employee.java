/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.ejercicio2.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import sv.edu.udb.ejercicio2.OpcionMenu;
import sv.edu.udb.ejercicio2.Utils;
import sv.edu.udb.ejercicio2.connection.Conexion;

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
    private String tipoEmpleado;
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

    public String getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(String tipoEmpleado) {
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

    public static boolean agregarEmpleado() {

        String nombres = Utils.validarString("Ingrese los nombres del empleado: ");
        String apellidos = Utils.validarString("Ingrese los apellidos del empleado: ");
        String dui = Utils.validarStringConPattern(
                "Ingrese el DUI (incluyendo guiones): ",
                "^\\d{8}-\\d{1}$");
        String nit = Utils.validarStringConPattern(
                "Ingrese el NIT (incluyendo guiones): ",
                "^\\d{4}-\\d{6}-\\d{3}-\\d{1}$");
        double salarioBase = Utils.validarNumeroDecimal("Ingrese el salario base: ");

        List<String> optionList = new ArrayList<>();
        optionList.add(OpcionMenu.TIPO_PROGRAMADOR.getDescripcion());
        optionList.add(OpcionMenu.TIPO_OTROS.getDescripcion());

        String opcion = Utils.buildGUI(optionList, "Que tipo de empleado es:");

        if (opcion.equals(OpcionMenu.TIPO_PROGRAMADOR.name())) {
            Developer dev = new Developer();
            dev.setNombres(nombres);
            dev.setApellidos(apellidos);
            dev.setDui(dui);
            dev.setNit(nit);
            dev.setSalarioBase(salarioBase);
            dev.setTipoEmpleado(OpcionMenu.TIPO_PROGRAMADOR.name());
            Employee.persistirEmpleado(dev);
        } else {
            OtherEmp emp = new OtherEmp();
            emp.setNombres(nombres);
            emp.setApellidos(apellidos);
            emp.setDui(dui);
            emp.setNit(nit);
            emp.setSalarioBase(salarioBase);
            emp.setTipoEmpleado(OpcionMenu.TIPO_OTROS.name());
            Employee.persistirEmpleado(emp);
        }
        return true;

    }

    private static <T extends Employee> boolean persistirEmpleado(T empleado) {

        StringBuilder sb = new StringBuilder("INSERT INTO `empleados`(");
        sb.append("`Nombres`, `Apellidos`, `Dui`, `Nit`, `SalarioBase`, `TipoEmpleado`) VALUES (");
        sb.append("'").append(empleado.getNombres()).append("',");
        sb.append("'").append(empleado.getApellidos()).append("',");
        sb.append("'").append(empleado.getDui()).append("',");
        sb.append("'").append(empleado.getNit()).append("',");
        sb.append("'").append(empleado.getSalarioBase()).append("',");
        sb.append("'").append(empleado.getTipoEmpleado()).append("')");

        int result = 0;
        try {
            Conexion.crearConexion();
            result = Conexion.executeUpdate(sb.toString());
            Conexion.cerrarConexion();
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
            return false;
        }
        return result > 0;
    }

    public static boolean buscarEmpleado() throws SQLException {
        String dui = Utils.validarStringConPattern(
                "Ingrese el DUI (incluyendo guiones): ",
                "^\\d{8}-\\d{1}$");
        StringBuilder sb = new StringBuilder("SELECT * FROM `empleados` WHERE");

        sb.append(" `Dui` = '").append(dui).append("'");
        Conexion.crearConexion();
        Conexion.executeQuery(sb.toString());
        ResultSet rs = Conexion.getResultSet();
        while (rs.next()) {
            System.out.println("ID: " + rs.getInt(1)
                    + "\nNombre: " + rs.getString(2)
                    + "\nApellidos: " + rs.getString(3)
                    + "\nDUI: " + rs.getString(4)
                    + "\nNIT: " + rs.getString(5)
                    + "\nSalario: " + rs.getString(6)
                    + "\nTipo Empleado: " + rs.getString(7));

            System.out.println("==================================");
        }
        Conexion.cerrarConexion();

        return true;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
}
