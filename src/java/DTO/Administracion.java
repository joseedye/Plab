/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Leonardo
 */
@Entity
@Table(name = "administracion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administracion.findAll", query = "SELECT a FROM Administracion a")
    , @NamedQuery(name = "Administracion.findByIdActividad", query = "SELECT a FROM Administracion a WHERE a.idActividad = :idActividad")
    , @NamedQuery(name = "Administracion.findByCargo", query = "SELECT a FROM Administracion a WHERE a.cargo = :cargo")
    , @NamedQuery(name = "Administracion.findByHorasSemestre", query = "SELECT a FROM Administracion a WHERE a.horasSemestre = :horasSemestre")})
public class Administracion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_actividad")
    private Integer idActividad;
    @Basic(optional = false)
    @Column(name = "cargo")
    private String cargo;
    @Basic(optional = false)
    @Column(name = "horas_semestre")
    private int horasSemestre;
    @JoinColumn(name = "id_actividad", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Actividad actividad;

    public Administracion() {
    }

    public Administracion(Integer idActividad) {
        this.idActividad = idActividad;
    }

    public Administracion(Integer idActividad, String cargo, int horasSemestre) {
        this.idActividad = idActividad;
        this.cargo = cargo;
        this.horasSemestre = horasSemestre;
    }

    public Integer getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Integer idActividad) {
        this.idActividad = idActividad;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getHorasSemestre() {
        return horasSemestre;
    }

    public void setHorasSemestre(int horasSemestre) {
        this.horasSemestre = horasSemestre;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idActividad != null ? idActividad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administracion)) {
            return false;
        }
        Administracion other = (Administracion) object;
        if ((this.idActividad == null && other.idActividad != null) || (this.idActividad != null && !this.idActividad.equals(other.idActividad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DTO.Administracion[ idActividad=" + idActividad + " ]";
    }
    
}
