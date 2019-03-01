/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lacv.agogui.model.entities;

import com.lacv.jmagrexs.domain.BaseEntity;
import java.util.Date;
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
import javax.validation.constraints.Size;

/**
 *
 * @author lacastrillov
 */
@Entity
@Table(name = "agrupacion")
@NamedQueries({
    @NamedQuery(name = "Agrupacion.findAll", query = "SELECT a FROM Agrupacion a")})
public class Agrupacion implements BaseEntity {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AgrupacionPK id;
    @Column(name = "fecha_grupo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaGrupo;
    @Size(max = 100)
    @Column(name = "nombre_relacion")
    private String nombreRelacion;
    @Column(name = "estado")
    private Boolean estado;
    @Column(name = "anio")
    private Short anio;
    @JoinColumn(name = "codigo_docente", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Docente docente;
    @JoinColumn(name = "codigo_estudiante", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Estudiante estudiante;
    @JoinColumn(name = "codigo_asignatura", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Asignatura asignatura;

    public Agrupacion() {
    }

    public Agrupacion(AgrupacionPK agrupacionPK) {
        this.id = agrupacionPK;
    }

    public Agrupacion(int codigoDocente, int codigoEstudiante, int codigoAsignatura) {
        this.id = new AgrupacionPK(codigoDocente, codigoEstudiante, codigoAsignatura);
    }

    @Override
    public AgrupacionPK getId() {
        return id;
    }

    @Override
    public void setId(Object id) {
        this.id = (AgrupacionPK) id;
    }

    public Date getFechaGrupo() {
        return fechaGrupo;
    }

    public void setFechaGrupo(Date fechaGrupo) {
        this.fechaGrupo = fechaGrupo;
    }

    public String getNombreRelacion() {
        return nombreRelacion;
    }

    public void setNombreRelacion(String nombreRelacion) {
        this.nombreRelacion = nombreRelacion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Short getAnio() {
        return anio;
    }

    public void setAnio(Short anio) {
        this.anio = anio;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
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
        if (!(object instanceof Agrupacion)) {
            return false;
        }
        Agrupacion other = (Agrupacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lacv.agogui.model.entities.Agrupacion[ agrupacionPK=" + id + " ]";
    }
    
}
