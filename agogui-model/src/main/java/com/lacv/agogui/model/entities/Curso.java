/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lacv.agogui.model.entities;

import com.lacv.jmagrexs.domain.BaseEntity;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author lacastrillov
 */
@Entity
@Table(name = "curso")
@NamedQueries({
    @NamedQuery(name = "Curso.findAll", query = "SELECT c FROM Curso c")})
public class Curso implements BaseEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "anio_lectivo")
    private int anioLectivo;
    @Column(name = "activo")
    private Boolean activo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curso")
    private List<DocenteasignaturaCurso> docenteasignaturaCursoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curso")
    private List<Evaluacion> evaluacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curso")
    private List<NotaFinal> notaFinalList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curso")
    private List<NotaPeriodo> notaPeriodoList;
    @JoinColumn(name = "id_grado", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Grado grado;
    @JoinColumn(name = "id_jornada", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Jornada jornada;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curso")
    private List<NotaEvaluacion> notaEvaluacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curso")
    private List<EstudianteCurso> estudianteCursoList;

    public Curso() {
    }

    public Curso(Integer id) {
        this.id = id;
    }

    public Curso(Integer id, String nombre, int anioLectivo) {
        this.id = id;
        this.nombre = nombre;
        this.anioLectivo = anioLectivo;
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

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getAnioLectivo() {
        return anioLectivo;
    }

    public void setAnioLectivo(int anioLectivo) {
        this.anioLectivo = anioLectivo;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
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

    public Grado getGrado() {
        return grado;
    }

    public void setGrado(Grado grado) {
        this.grado = grado;
    }

    public Jornada getJornada() {
        return jornada;
    }

    public void setJornada(Jornada jornada) {
        this.jornada = jornada;
    }

    public List<NotaEvaluacion> getNotaEvaluacionList() {
        return notaEvaluacionList;
    }

    public void setNotaEvaluacionList(List<NotaEvaluacion> notaEvaluacionList) {
        this.notaEvaluacionList = notaEvaluacionList;
    }

    public List<EstudianteCurso> getEstudianteCursoList() {
        return estudianteCursoList;
    }

    public void setEstudianteCursoList(List<EstudianteCurso> estudianteCursoList) {
        this.estudianteCursoList = estudianteCursoList;
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
        if (!(object instanceof Curso)) {
            return false;
        }
        Curso other = (Curso) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lacv.agogui.model.entities.Curso[ id=" + id + " ]";
    }
    
}
