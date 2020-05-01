/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Rick
 */
@Entity
@Table(name = "estudiantes")
@NamedQueries({
    @NamedQuery(name = "EstudianteEntity.findAll", query = "SELECT e FROM EstudianteEntity e"),
    @NamedQuery(name = "EstudianteEntity.findByCarnet", query = "SELECT e FROM EstudianteEntity e WHERE e.carnet = :carnet"),
    @NamedQuery(name = "EstudianteEntity.findByNombres", query = "SELECT e FROM EstudianteEntity e WHERE e.nombres = :nombres"),
    @NamedQuery(name = "EstudianteEntity.findByApellidos", query = "SELECT e FROM EstudianteEntity e WHERE e.apellidos = :apellidos"),
    @NamedQuery(name = "EstudianteEntity.findByEdad", query = "SELECT e FROM EstudianteEntity e WHERE e.edad = :edad"),
    @NamedQuery(name = "EstudianteEntity.findByCum", query = "SELECT e FROM EstudianteEntity e WHERE e.cum = :cum"),
    @NamedQuery(name = "EstudianteEntity.findByGenero", query = "SELECT e FROM EstudianteEntity e WHERE e.genero = :genero"),
    @NamedQuery(name = "EstudianteEntity.findByCarrera", query = "SELECT e FROM EstudianteEntity e WHERE e.carrera = :carrera")})
public class EstudianteEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private String carnet;
    @Basic(optional = false)
    private String nombres;
    @Basic(optional = false)
    private String apellidos;
    @Basic(optional = false)
    private int edad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    private BigDecimal cum;
    @Basic(optional = false)
    private Character genero;
    @Basic(optional = false)
    private String carrera;

    public EstudianteEntity() {
    }

    public EstudianteEntity(String carnet) {
        this.carnet = carnet;
    }

    public EstudianteEntity(String carnet, String nombres, String apellidos, int edad, BigDecimal cum, Character genero, String carrera) {
        this.carnet = carnet;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.cum = cum;
        this.genero = genero;
        this.carrera = carrera;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public BigDecimal getCum() {
        return cum;
    }

    public void setCum(BigDecimal cum) {
        this.cum = cum;
    }

    public Character getGenero() {
        return genero;
    }

    public void setGenero(Character genero) {
        this.genero = genero;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (carnet != null ? carnet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstudianteEntity)) {
            return false;
        }
        EstudianteEntity other = (EstudianteEntity) object;
        if ((this.carnet == null && other.carnet != null) || (this.carnet != null && !this.carnet.equals(other.carnet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.www.entities.EstudianteEntity[ carnet=" + carnet + " ]";
    }
    
}
