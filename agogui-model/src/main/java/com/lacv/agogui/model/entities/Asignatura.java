/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lacv.agogui.model.entities;

import com.lacv.jmagrexs.domain.BaseEntity;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author lacastrillov
 */
@Entity
@Table(name = "asignatura")
@NamedQueries({
    @NamedQuery(name = "Asignatura.findAll", query = "SELECT a FROM Asignatura a")})
public class Asignatura implements BaseEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private Integer id;
    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;
    @JoinColumn(name = "id_area", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Area area;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "asignatura")
    private List<DocenteasignaturaCurso> docenteasignaturaCursoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "asignatura")
    private List<Evaluacion> evaluacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "asignatura")
    private List<DocenteAsignatura> docenteAsignaturaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "asignatura")
    private List<NotaFinal> notaFinalList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "asignatura")
    private List<NotaPeriodo> notaPeriodoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "asignatura")
    private List<Tema> temaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "asignatura")
    private List<NotaEvaluacion> notaEvaluacionList;

    public Asignatura() {
    }

    public Asignatura(Integer codigo) {
        this.id = codigo;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Object id) {
        this.id = (Integer) id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public List<DocenteasignaturaCurso> getDocenteasignaturaCursoList() {
        return docenteasignaturaCursoList;
    }

    public void setDocenteasignaturaCursoList(List<DocenteasignaturaCurso> docenteasignaturaCursoList) {
        this.docenteasignaturaCursoList = docenteasignaturaCursoList;
    }

    public List<Evaluacion> getEvaluacionList() {
        return evaluacionList;
    }

    public void setEvaluacionList(List<Evaluacion> evaluacionList) {
        this.evaluacionList = evaluacionList;
    }

    public List<DocenteAsignatura> getDocenteAsignaturaList() {
        return docenteAsignaturaList;
    }

    public void setDocenteAsignaturaList(List<DocenteAsignatura> docenteAsignaturaList) {
        this.docenteAsignaturaList = docenteAsignaturaList;
    }

    public List<NotaFinal> getNotaFinalList() {
        return notaFinalList;
    }

    public void setNotaFinalList(List<NotaFinal> notaFinalList) {
        this.notaFinalList = notaFinalList;
    }

    public List<NotaPeriodo> getNotaPeriodoList() {
        return notaPeriodoList;
    }

    public void setNotaPeriodoList(List<NotaPeriodo> notaPeriodoList) {
        this.notaPeriodoList = notaPeriodoList;
    }

    public List<Tema> getTemaList() {
        return temaList;
    }

    public void setTemaList(List<Tema> temaList) {
        this.temaList = temaList;
    }

    public List<NotaEvaluacion> getNotaEvaluacionList() {
        return notaEvaluacionList;
    }

    public void setNotaEvaluacionList(List<NotaEvaluacion> notaEvaluacionList) {
        this.notaEvaluacionList = notaEvaluacionList;
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
        if (!(object instanceof Asignatura)) {
            return false;
        }
        Asignatura other = (Asignatura) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lacv.agogui.model.entities.Asignatura[ codigo=" + id + " ]";
    }
    
}
