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
@Table(name = "extension")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Extension.findAll", query = "SELECT e FROM Extension e")
    , @NamedQuery(name = "Extension.findByIdActividad", query = "SELECT e FROM Extension e WHERE e.idActividad = :idActividad")
    , @NamedQuery(name = "Extension.findByResponsabilidades", query = "SELECT e FROM Extension e WHERE e.responsabilidades = :responsabilidades")
    , @NamedQuery(name = "Extension.findByCodigo", query = "SELECT e FROM Extension e WHERE e.codigo = :codigo")
    , @NamedQuery(name = "Extension.findByUnidad", query = "SELECT e FROM Extension e WHERE e.unidad = :unidad")
    , @NamedQuery(name = "Extension.findByHorasSemestre", query = "SELECT e FROM Extension e WHERE e.horasSemestre = :horasSemestre")
    , @NamedQuery(name = "Extension.findByHEjecucion", query = "SELECT e FROM Extension e WHERE e.hEjecucion = :hEjecucion")
    , @NamedQuery(name = "Extension.findByHProgramacion", query = "SELECT e FROM Extension e WHERE e.hProgramacion = :hProgramacion")
    , @NamedQuery(name = "Extension.findByPrograma", query = "SELECT e FROM Extension e WHERE e.programa = :programa")})
public class Extension implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_actividad")
    private Integer idActividad;
    @Basic(optional = false)
    @Column(name = "responsabilidades")
    private String responsabilidades;
    @Basic(optional = false)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @Column(name = "unidad")
    private String unidad;
    @Basic(optional = false)
    @Column(name = "horas_semestre")
    private int horasSemestre;
    @Basic(optional = false)
    @Column(name = "h_ejecucion")
    private int hEjecucion;
    @Basic(optional = false)
    @Column(name = "h_programacion")
    private int hProgramacion;
    @Basic(optional = false)
    @Column(name = "programa")
    private String programa;
    @JoinColumn(name = "id_actividad", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Actividad actividad;

    public Extension() {
    }

    public Extension(Integer idActividad) {
        this.idActividad = idActividad;
    }

    public Extension(Integer idActividad, String responsabilidades, String codigo, String unidad, int horasSemestre, int hEjecucion, int hProgramacion, String programa) {
        this.idActividad = idActividad;
        this.responsabilidades = responsabilidades;
        this.codigo = codigo;
        this.unidad = unidad;
        this.horasSemestre = horasSemestre;
        this.hEjecucion = hEjecucion;
        this.hProgramacion = hProgramacion;
        this.programa = programa;
    }

    public Integer getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Integer idActividad) {
        this.idActividad = idActividad;
    }

    public String getResponsabilidades() {
        return responsabilidades;
    }

    public void setResponsabilidades(String responsabilidades) {
        this.responsabilidades = responsabilidades;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public int getHorasSemestre() {
        return horasSemestre;
    }

    public void setHorasSemestre(int horasSemestre) {
        this.horasSemestre = horasSemestre;
    }

    public int getHEjecucion() {
        return hEjecucion;
    }

    public void setHEjecucion(int hEjecucion) {
        this.hEjecucion = hEjecucion;
    }

    public int getHProgramacion() {
        return hProgramacion;
    }

    public void setHProgramacion(int hProgramacion) {
        this.hProgramacion = hProgramacion;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
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
        if (!(object instanceof Extension)) {
            return false;
        }
        Extension other = (Extension) object;
        if ((this.idActividad == null && other.idActividad != null) || (this.idActividad != null && !this.idActividad.equals(other.idActividad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DTO.Extension[ idActividad=" + idActividad + " ]";
    }
    
}
