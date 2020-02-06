/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.ejercicio3;

import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author rickc
 */
public class DVD extends MaterialAudiovisual {

    private String director;
    public static int historicoUnidades = 0;

    public DVD() {
        historicoUnidades++;
        String padded = String.format("%05d", historicoUnidades);
        super.setCodigo("DVD" + padded);
    }

    @XmlElement
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
    
    

}
