/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Leonardo
 */
@Entity
@Table(name = "actividad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actividad.findAll", query = "SELECT a FROM Actividad a")
    , @NamedQuery(name = "Actividad.findById", query = "SELECT a FROM Actividad a WHERE a.id = :id")
    , @NamedQuery(name = "Actividad.findByNombre", query = "SELECT a FROM Actividad a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Actividad.findByHorasSemana", query = "SELECT a FROM Actividad a WHERE a.horasSemana = :horasSemana")})
public class Actividad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "horas_semana")
    private int horasSemana;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "actividad")
    private Investigacion investigacion;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "actividad")
    private Docencia docencia;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "actividad")
    private Extension extension;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "actividad")
    private List<ActividadProfesor> actividadProfesorList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "actividad")
    private Otras otras;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "actividad")
    private Administracion administracion;

    public Actividad() {
    }

    public Actividad(Integer id) {
        this.id = id;
    }

    public Actividad(Integer id, String nombre, int horasSemana) {
        this.id = id;
        this.nombre = nombre;
        this.horasSemana = horasSemana;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHorasSemana() {
        return horasSemana;
    }

    public void setHorasSemana(int horasSemana) {
        this.horasSemana = horasSemana;
    }

    public Investigacion getInvestigacion() {
        return investigacion;
    }

    public void setInvestigacion(Investigacion investigacion) {
        this.investigacion = investigacion;
    }

    public Docencia getDocencia() {
        return docencia;
    }

    public void setDocencia(Docencia docencia) {
        this.docencia = docencia;
    }

    public Extension getExtension() {
        return extension;
    }

    public void setExtension(Extension extension) {
        this.extension = extension;
    }

    @XmlTransient
    public List<ActividadProfesor> getActividadProfesorList() {
        return actividadProfesorList;
    }

    public void setActividadProfesorList(List<ActividadProfesor> actividadProfesorList) {
        this.actividadProfesorList = actividadProfesorList;
    }

    public Otras getOtras() {
        return otras;
    }

    public void setOtras(Otras otras) {
        this.otras = otras;
    }

    public Administracion getAdministracion() {
        return administracion;
    }

    public void setAdministracion(Administracion administracion) {
        this.administracion = administracion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actividad)) {
            return false;
        }
        Actividad other = (Actividad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DTO.Actividad[ id=" + id + " ]";
    }
    
}
