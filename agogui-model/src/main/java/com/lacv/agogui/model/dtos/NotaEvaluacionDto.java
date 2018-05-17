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
import java.sql.Time;
import java.util.Date;
import java.util.List;

/**
 *
 * @author lcastrillo
 */
@LabelField("id")
public class NotaEvaluacionDto implements BaseEntity {

    private static final long serialVersionUID = 1L;
    
    @Order(1)
    @ColumnWidth(200)
    @TextField("Asignatura")
    private AsignaturaDto asignatura;
    
    @Order(2)
    @ColumnWidth(200)
    @TextField("Curso")
    private CursoDto curso;
    
    @Order(3)
    @ColumnWidth(200)
    @TextField("Estudiante")
    private EstudianteDto estudiante;
    
    @Order(4)
    @ColumnWidth(200)
    @TextField("Evaluacion")
    private EvaluacionDto evaluacion;
    
    @Order(5)
    @Size(max=1)
    @ColumnWidth(200)
    @TextField("Formato")
    private String formato;
    
    @Order(6)
    @ReadOnly
    @ColumnWidth(100)
    @TextField("Id")
    private Integer id;
    
    @Order(7)
    @ColumnWidth(200)
    @TextField("NotaNumero")
    private Double notaNumero;
    
    @Order(8)
    @Size(max=10)
    @ColumnWidth(200)
    @TextField("NotaTexto")
    private String notaTexto;
    

    public NotaEvaluacionDto() {
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

    public EstudianteDto getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(EstudianteDto estudiante) {
        this.estudiante =  estudiante;
    }

    public EvaluacionDto getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(EvaluacionDto evaluacion) {
        this.evaluacion =  evaluacion;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato =  formato;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Object id) {
        this.id = (Integer) id;
    }

    public Double getNotaNumero() {
        return notaNumero;
    }

    public void setNotaNumero(Double notaNumero) {
        this.notaNumero =  notaNumero;
    }

    public String getNotaTexto() {
        return notaTexto;
    }

    public void setNotaTexto(String notaTexto) {
        this.notaTexto =  notaTexto;
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
        if (!(object instanceof NotaEvaluacionDto)) {
            return false;
        }
        NotaEvaluacionDto other = (NotaEvaluacionDto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lacv.agogui.model.dtos.NotaEvaluacionDto[ id=" + id + " ]";
    }
    
}
