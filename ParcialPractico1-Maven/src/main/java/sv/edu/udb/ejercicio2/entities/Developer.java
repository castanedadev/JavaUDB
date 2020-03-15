/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.ejercicio2.entities;

/**
 *
 * @author rickc
 */
public class Developer extends Employee implements EmployeeInt {

    private float horasExtras;

    @Override
    public double calcularSalario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public float getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(float horasExtras) {
        this.horasExtras = horasExtras;
    }

}
