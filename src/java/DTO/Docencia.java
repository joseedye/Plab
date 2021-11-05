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
@Table(name = "docencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Docencia.findAll", query = "SELECT d FROM Docencia d")
    , @NamedQuery(name = "Docencia.findByIdActividad", query = "SELECT d FROM Docencia d WHERE d.idActividad = :idActividad")
    , @NamedQuery(name = "Docencia.findByCodigo", query = "SELECT d FROM Docencia d WHERE d.codigo = :codigo")
    , @NamedQuery(name = "Docencia.findByGrupo", query = "SELECT d FROM Docencia d WHERE d.grupo = :grupo")
    , @NamedQuery(name = "Docencia.findByCreditos", query = "SELECT d FROM Docencia d WHERE d.creditos = :creditos")
    , @NamedQuery(name = "Docencia.findByNivel", query = "SELECT d FROM Docencia d WHERE d.nivel = :nivel")
    , @NamedQuery(name = "Docencia.findByNumEstudiantes", query = "SELECT d FROM Docencia d WHERE d.numEstudiantes = :numEstudiantes")
    , @NamedQuery(name = "Docencia.findByHorasSemestre", query = "SELECT d FROM Docencia d WHERE d.horasSemestre = :horasSemestre")
    , @NamedQuery(name = "Docencia.findByHP", query = "SELECT d FROM Docencia d WHERE d.hP = :hP")
    , @NamedQuery(name = "Docencia.findByHTP", query = "SELECT d FROM Docencia d WHERE d.hTP = :hTP")
    , @NamedQuery(name = "Docencia.findByHT", query = "SELECT d FROM Docencia d WHERE d.hT = :hT")})
public class Docencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_actividad")
    private Integer idActividad;
    @Basic(optional = false)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @Column(name = "grupo")
    private String grupo;
    @Basic(optional = false)
    @Column(name = "creditos")
    private int creditos;
    @Basic(optional = false)
    @Column(name = "nivel")
    private String nivel;
    @Basic(optional = false)
    @Column(name = "num_estudiantes")
    private int numEstudiantes;
    @Basic(optional = false)
    @Column(name = "horas_semestre")
    private int horasSemestre;
    @Basic(optional = false)
    @Column(name = "h_p")
    private int hP;
    @Basic(optional = false)
    @Column(name = "h_t_p")
    private int hTP;
    @Basic(optional = false)
    @Column(name = "h_t")
    private int hT;
    @JoinColumn(name = "id_actividad", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Actividad actividad;

    public Docencia() {
    }

    public Docencia(Integer idActividad) {
        this.idActividad = idActividad;
    }

    public Docencia(Integer idActividad, String codigo, String grupo, int creditos, String nivel, int numEstudiantes, int horasSemestre, int hP, int hTP, int hT) {
        this.idActividad = idActividad;
        this.codigo = codigo;
        this.grupo = grupo;
        this.creditos = creditos;
        this.nivel = nivel;
        this.numEstudiantes = numEstudiantes;
        this.horasSemestre = horasSemestre;
        this.hP = hP;
        this.hTP = hTP;
        this.hT = hT;
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

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public int getNumEstudiantes() {
        return numEstudiantes;
    }

    public void setNumEstudiantes(int numEstudiantes) {
        this.numEstudiantes = numEstudiantes;
    }

    public int getHorasSemestre() {
        return horasSemestre;
    }

    public void setHorasSemestre(int horasSemestre) {
        this.horasSemestre = horasSemestre;
    }

    public int getHP() {
        return hP;
    }

    public void setHP(int hP) {
        this.hP = hP;
    }

    public int getHTP() {
        return hTP;
    }

    public void setHTP(int hTP) {
        this.hTP = hTP;
    }

    public int getHT() {
        return hT;
    }

    public void setHT(int hT) {
        this.hT = hT;
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
        if (!(object instanceof Docencia)) {
            return false;
        }
        Docencia other = (Docencia) object;
        if ((this.idActividad == null && other.idActividad != null) || (this.idActividad != null && !this.idActividad.equals(other.idActividad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DTO.Docencia[ idActividad=" + idActividad + " ]";
    }
    
}
