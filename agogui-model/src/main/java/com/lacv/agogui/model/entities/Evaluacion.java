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
import javax.persistence.Lob;
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
@Table(name = "evaluacion")
@NamedQueries({
    @NamedQuery(name = "Evaluacion.findAll", query = "SELECT e FROM Evaluacion e")})
public class Evaluacion implements BaseEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "numero")
    private Integer numero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "porcentaje")
    private Integer porcentaje;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Lob
    @Size(max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "tipo_calificacion_logros")
    private Integer tipoCalificacionLogros;
    @JoinColumn(name = "id_docente", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Docente docente;
    @JoinColumn(name = "id_asignatura", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Asignatura asignatura;
    @JoinColumn(name = "id_curso", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Curso curso;
    @JoinColumn(name = "id_periodo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Periodo periodo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaluacion")
    private List<NotaEvaluacion> notaEvaluacionList;

    public Evaluacion() {
    }

    public Evaluacion(Integer id) {
        this.id = id;
    }

    public Evaluacion(Integer id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Object id) {
        this.id = (Integer) id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Integer porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getTipoCalificacionLogros() {
        return tipoCalificacionLogros;
    }

    public void setTipoCalificacionLogros(Integer tipoCalificacionLogros) {
        this.tipoCalificacionLogros = tipoCalificacionLogros;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
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
        if (!(object instanceof Evaluacion)) {
            return false;
        }
        Evaluacion other = (Evaluacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lacv.agogui.model.entities.Evaluacion[ id=" + id + " ]";
    }
    
}
