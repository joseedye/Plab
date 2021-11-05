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
@Table(name = "investigacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Investigacion.findAll", query = "SELECT i FROM Investigacion i")
    , @NamedQuery(name = "Investigacion.findByIdActividad", query = "SELECT i FROM Investigacion i WHERE i.idActividad = :idActividad")
    , @NamedQuery(name = "Investigacion.findByCodigo", query = "SELECT i FROM Investigacion i WHERE i.codigo = :codigo")
    , @NamedQuery(name = "Investigacion.findByResponsabilidad", query = "SELECT i FROM Investigacion i WHERE i.responsabilidad = :responsabilidad")
    , @NamedQuery(name = "Investigacion.findByUnidadInv", query = "SELECT i FROM Investigacion i WHERE i.unidadInv = :unidadInv")
    , @NamedQuery(name = "Investigacion.findByInstitucion", query = "SELECT i FROM Investigacion i WHERE i.institucion = :institucion")})
public class Investigacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_actividad")
    private Integer idActividad;
    @Basic(optional = false)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @Column(name = "responsabilidad")
    private String responsabilidad;
    @Basic(optional = false)
    @Column(name = "unidad_inv")
    private String unidadInv;
    @Basic(optional = false)
    @Column(name = "institucion")
    private String institucion;
    @JoinColumn(name = "id_actividad", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Actividad actividad;

    public Investigacion() {
    }

    public Investigacion(Integer idActividad) {
        this.idActividad = idActividad;
    }

    public Investigacion(Integer idActividad, String codigo, String responsabilidad, String unidadInv, String institucion) {
        this.idActividad = idActividad;
        this.codigo = codigo;
        this.responsabilidad = responsabilidad;
        this.unidadInv = unidadInv;
        this.institucion = institucion;
    }

    public Integer getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Integer idActividad) {
        this.idActividad = idActividad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getResponsabilidad() {
        return responsabilidad;
    }

    public void setResponsabilidad(String responsabilidad) {
        this.responsabilidad = responsabilidad;
    }

    public String getUnidadInv() {
        return unidadInv;
    }

    public void setUnidadInv(String unidadInv) {
        this.unidadInv = unidadInv;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
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
        if (!(object instanceof Investigacion)) {
            return false;
        }
        Investigacion other = (Investigacion) object;
        if ((this.idActividad == null && other.idActividad != null) || (this.idActividad != null && !this.idActividad.equals(other.idActividad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DTO.Investigacion[ idActividad=" + idActividad + " ]";
    }
    
}
