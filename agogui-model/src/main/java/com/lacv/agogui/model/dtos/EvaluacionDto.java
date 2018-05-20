/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lacv.agogui.model.dtos;

import com.lacv.jmagrexs.annotation.ColumnWidth;
import com.lacv.jmagrexs.annotation.LabelField;
import com.lacv.jmagrexs.annotation.NotNull;
import com.lacv.jmagrexs.annotation.Order;
import com.lacv.jmagrexs.annotation.ReadOnly;
import com.lacv.jmagrexs.annotation.Size;
import com.lacv.jmagrexs.annotation.TextField;
import com.lacv.jmagrexs.domain.BaseEntity;
import java.util.Date;
import java.util.List;

/**
 *
 * @author lcastrillo
 */
@LabelField("titulo")
public class EvaluacionDto implements BaseEntity {

    private static final long serialVersionUID = 1L;
    
    @Order(1)
    @ReadOnly
    @ColumnWidth(100)
    @TextField("Id")
    private Integer id;
    
    @Order(2)
    @NotNull
    @Size(min=1,max=150)
    @ColumnWidth(200)
    @TextField("Titulo")
    private String titulo;
    
    @Order(3)
    @Size(max=65535)
    @ColumnWidth(200)
    @TextField("Descripcion")
    private String descripcion;
    
    @Order(4)
    @ColumnWidth(200)
    @TextField("Numero")
    private Integer numero;
    
    @Order(5)
    @ColumnWidth(200)
    @TextField("Porcentaje")
    private Integer porcentaje;
    
    @Order(6)
    @ColumnWidth(200)
    @TextField("Periodo")
    private PeriodoDto periodo;
    
    @Order(7)
    @ColumnWidth(200)
    @TextField("Docente")
    private DocenteDto docente;
    
    @Order(8)
    @ColumnWidth(200)
    @TextField("Asignatura")
    private AsignaturaDto asignatura;
    
    @Order(9)
    @ColumnWidth(200)
    @TextField("Curso")
    private CursoDto curso;
    
    @Order(10)
    @ColumnWidth(200)
    @TextField("Tipom Calificacion Logros")
    private Integer tipoCalificacionLogros;
    
    @Order(11)
    @ColumnWidth(200)
    @TextField("Fecha")
    private Date fecha;
    
    private List<NotaEvaluacionDto> notaEvaluacionList;
    

    public EvaluacionDto() {
    }

    public AsignaturaDto getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(AsignaturaDto asignatura) {
        this.asignatura =  asignatura;
    }

    public CursoDto getCurso() {
        return curso;
    }

    public void setCurso(CursoDto curso) {
        this.curso =  curso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion =  descripcion;
    }

    public DocenteDto getDocente() {
        return docente;
    }

    public void setDocente(DocenteDto docente) {
        this.docente =  docente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha =  fecha;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Object id) {
        this.id = (Integer) id;
    }

    public List<NotaEvaluacionDto> getNotaEvaluacionList() {
        return notaEvaluacionList;
    }

    public void setNotaEvaluacionList(List<NotaEvaluacionDto> notaEvaluacionList) {
        this.notaEvaluacionList =  notaEvaluacionList;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero =  numero;
    }

    public PeriodoDto getPeriodo() {
        return periodo;
    }

    public void setPeriodo(PeriodoDto periodo) {
        this.periodo =  periodo;
    }

    public Integer getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Integer porcentaje) {
        this.porcentaje =  porcentaje;
    }

    public Integer getTipoCalificacionLogros() {
        return tipoCalificacionLogros;
    }

    public void setTipoCalificacionLogros(Integer tipoCalificacionLogros) {
        this.tipoCalificacionLogros =  tipoCalificacionLogros;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo =  titulo;
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
        if (!(object instanceof EvaluacionDto)) {
            return false;
        }
        EvaluacionDto other = (EvaluacionDto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lacv.agogui.model.dtos.EvaluacionDto[ id=" + id + " ]";
    }
    
}
