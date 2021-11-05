/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Leonardo
 */
@Entity
@Table(name = "profesor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profesor.findAll", query = "SELECT p FROM Profesor p")
    , @NamedQuery(name = "Profesor.findById", query = "SELECT p FROM Profesor p WHERE p.id = :id")
    , @NamedQuery(name = "Profesor.findByFechaInicio", query = "SELECT p FROM Profesor p WHERE p.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "Profesor.findByCodigo", query = "SELECT p FROM Profesor p WHERE p.codigo = :codigo")
    , @NamedQuery(name = "Profesor.findByHorasSemana", query = "SELECT p FROM Profesor p WHERE p.horasSemana = :horasSemana")
    , @NamedQuery(name = "Profesor.findByVinculacion", query = "SELECT p FROM Profesor p WHERE p.vinculacion = :vinculacion")})
public class Profesor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @Column(name = "codigo")
    private int codigo;
    @Basic(optional = false)
    @Column(name = "horas_semana")
    private int horasSemana;
    @Basic(optional = false)
    @Column(name = "vinculacion")
    private String vinculacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profesor")
    private List<ActividadProfesor> actividadProfesorList;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public Profesor() {
    }

    public Profesor(Integer id) {
        this.id = id;
    }

    public Profesor(Integer id, Date fechaInicio, int codigo, int horasSemana, String vinculacion) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.codigo = codigo;
        this.horasSemana = horasSemana;
        this.vinculacion = vinculacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getHorasSemana() {
        return horasSemana;
    }

    public void setHorasSemana(int horasSemana) {
        this.horasSemana = horasSemana;
    }

    public String getVinculacion() {
        return vinculacion;
    }

    public void setVinculacion(String vinculacion) {
        this.vinculacion = vinculacion;
    }

    @XmlTransient
    public List<ActividadProfesor> getActividadProfesorList() {
        return actividadProfesorList;
    }

    public void setActividadProfesorList(List<ActividadProfesor> actividadProfesorList) {
        this.actividadProfesorList = actividadProfesorList;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
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
        if (!(object instanceof Profesor)) {
            return false;
        }
        Profesor other = (Profesor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DTO.Profesor[ id=" + id + " ]";
    }
    
}
