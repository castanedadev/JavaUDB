/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.complementarios;

/**
 *
 * @author rickc
 */
public class Ejercicio1_IntanciarEstudiante {
    
    public static void main(String[] args) {
        Estudiante estudiante1 = new Estudiante();
        Estudiante estudiante2 = new Estudiante();
        Estudiante estudiante3 = new Estudiante();
        
        System.out.println("---- Primera Instancia ----");
        System.out.println(estudiante1);
        
        System.out.println("---- Segunda Instancia ----");
        estudiante2.agregarListaMaterias();
        System.out.println(estudiante2);
        
        System.out.println("---- Tercera Instancia ----");
        estudiante3.agregarInformacion("Ricardo Castaneda", 
                "CH142568", 25, 
                "Metodos Numericos", "Seguridad Informatica", 
                "Auditoria", "React Avanzado", "Deep Learning");
        System.out.println(estudiante3);
    }
}
