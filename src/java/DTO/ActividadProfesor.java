/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Leonardo
 */
@Entity
@Table(name = "actividad_profesor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActividadProfesor.findAll", query = "SELECT a FROM ActividadProfesor a")
    , @NamedQuery(name = "ActividadProfesor.findByIdProfesor", query = "SELECT a FROM ActividadProfesor a WHERE a.actividadProfesorPK.idProfesor = :idProfesor")
    , @NamedQuery(name = "ActividadProfesor.findByIdActividad", query = "SELECT a FROM ActividadProfesor a WHERE a.actividadProfesorPK.idActividad = :idActividad")
    , @NamedQuery(name = "ActividadProfesor.findByFechaIngreso", query = "SELECT a FROM ActividadProfesor a WHERE a.fechaIngreso = :fechaIngreso")
    , @NamedQuery(name = "ActividadProfesor.findBySemestre", query = "SELECT a FROM ActividadProfesor a WHERE a.semestre = :semestre")})
public class ActividadProfesor implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ActividadProfesorPK actividadProfesorPK;
    @Basic(optional = false)
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Basic(optional = false)
    @Column(name = "semestre")
    private String semestre;
    @JoinColumn(name = "id_actividad", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Actividad actividad;
    @JoinColumn(name = "id_profesor", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Profesor profesor;

    public ActividadProfesor() {
    }

    public ActividadProfesor(ActividadProfesorPK actividadProfesorPK) {
        this.actividadProfesorPK = actividadProfesorPK;
    }

    public ActividadProfesor(ActividadProfesorPK actividadProfesorPK, Date fechaIngreso, String semestre) {
        this.actividadProfesorPK = actividadProfesorPK;
        this.fechaIngreso = fechaIngreso;
        this.semestre = semestre;
    }

    public ActividadProfesor(int idProfesor, int idActividad) {
        this.actividadProfesorPK = new ActividadProfesorPK(idProfesor, idActividad);
    }

    public ActividadProfesorPK getActividadProfesorPK() {
        return actividadProfesorPK;
    }

    public void setActividadProfesorPK(ActividadProfesorPK actividadProfesorPK) {
        this.actividadProfesorPK = actividadProfesorPK;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (actividadProfesorPK != null ? actividadProfesorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActividadProfesor)) {
            return false;
        }
        ActividadProfesor other = (ActividadProfesor) object;
        if ((this.actividadProfesorPK == null && other.actividadProfesorPK != null) || (this.actividadProfesorPK != null && !this.actividadProfesorPK.equals(other.actividadProfesorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DTO.ActividadProfesor[ actividadProfesorPK=" + actividadProfesorPK + " ]";
    }
    
}
