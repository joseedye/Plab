/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Leonardo
 */
@Embeddable
public class ActividadProfesorPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_profesor")
    private int idProfesor;
    @Basic(optional = false)
    @Column(name = "id_actividad")
    private int idActividad;

    public ActividadProfesorPK() {
    }

    public ActividadProfesorPK(int idProfesor, int idActividad) {
        this.idProfesor = idProfesor;
        this.idActividad = idActividad;
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idProfesor;
        hash += (int) idActividad;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActividadProfesorPK)) {
            return false;
        }
        ActividadProfesorPK other = (ActividadProfesorPK) object;
        if (this.idProfesor != other.idProfesor) {
            return false;
        }
        if (this.idActividad != other.idActividad) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DTO.ActividadProfesorPK[ idProfesor=" + idProfesor + ", idActividad=" + idActividad + " ]";
    }
    
}
