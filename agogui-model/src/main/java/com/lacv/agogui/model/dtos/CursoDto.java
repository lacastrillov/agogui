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
import com.lacv.jmagrexs.domain.BaseDto;
import java.util.Date;
import java.util.List;

/**
 *
 * @author lcastrillo
 */
@LabelField("nombre")
public class CursoDto implements BaseDto {

    private static final long serialVersionUID = 1L;
    
    @Order(1)
    @ReadOnly
    @ColumnWidth(100)
    @TextField("Id")
    private Integer id;
    
    @Order(2)
    @NotNull
    @Size(min=1,max=30)
    @ColumnWidth(200)
    @TextField("Nombre")
    private String nombre;
    
    @Order(3)
    @NotNull
    @ColumnWidth(200)
    @TextField("A&ntilde;o Lectivo")
    private int anioLectivo;
    
    @Order(4)
    @ColumnWidth(200)
    @TextField("Grado")
    private GradoDto grado;
    
    @Order(5)
    @ColumnWidth(200)
    @TextField("Fecha Creaci&oacute;n")
    private Date fechaCreacion;
    
    @Order(6)
    @ColumnWidth(200)
    @TextField("Jornada")
    private JornadaDto jornada;
    
    @Order(7)
    @ColumnWidth(200)
    @TextField("Sede")
    private SedeDto sede;
    
    @Order(8)
    @ColumnWidth(100)
    @TextField("Activo")
    private Boolean activo;
    
    private List<DocenteasignaturaCursoDto> docenteasignaturaCursoList;
    
    private List<EstudianteCursoDto> estudianteCursoList;
    
    private List<EvaluacionDto> evaluacionList;
    
    private List<NotaEvaluacionDto> notaEvaluacionList;
    
    private List<NotaFinalDto> notaFinalList;
    
    private List<NotaPeriodoDto> notaPeriodoList;
    

    public CursoDto() {
    }
    
    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Object id) {
        this.id = (Integer) id;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo =  activo;
    }

    public int getAnioLectivo() {
        return anioLectivo;
    }

    public void setAnioLectivo(int anioLectivo) {
        this.anioLectivo =  anioLectivo;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion =  fechaCreacion;
    }

    public GradoDto getGrado() {
        return grado;
    }

    public void setGrado(GradoDto grado) {
        this.grado =  grado;
    }

    public JornadaDto getJornada() {
        return jornada;
    }

    public void setJornada(JornadaDto jornada) {
        this.jornada =  jornada;
    }
    
    public SedeDto getSede() {
        return sede;
    }

    public void setSede(SedeDto sede) {
        this.sede =  sede;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre =  nombre;
    }
    
    public List<DocenteasignaturaCursoDto> getDocenteasignaturaCursoList() {
        return docenteasignaturaCursoList;
    }

    public void setDocenteasignaturaCursoList(List<DocenteasignaturaCursoDto> docenteasignaturaCursoList) {
        this.docenteasignaturaCursoList =  docenteasignaturaCursoList;
    }

    public List<EstudianteCursoDto> getEstudianteCursoList() {
        return estudianteCursoList;
    }

    public void setEstudianteCursoList(List<EstudianteCursoDto> estudianteCursoList) {
        this.estudianteCursoList =  estudianteCursoList;
    }

    public List<EvaluacionDto> getEvaluacionList() {
        return evaluacionList;
    }

    public void setEvaluacionList(List<EvaluacionDto> evaluacionList) {
        this.evaluacionList =  evaluacionList;
    }

    public List<NotaEvaluacionDto> getNotaEvaluacionList() {
        return notaEvaluacionList;
    }

    public void setNotaEvaluacionList(List<NotaEvaluacionDto> notaEvaluacionList) {
        this.notaEvaluacionList =  notaEvaluacionList;
    }

    public List<NotaFinalDto> getNotaFinalList() {
        return notaFinalList;
    }

    public void setNotaFinalList(List<NotaFinalDto> notaFinalList) {
        this.notaFinalList =  notaFinalList;
    }

    public List<NotaPeriodoDto> getNotaPeriodoList() {
        return notaPeriodoList;
    }

    public void setNotaPeriodoList(List<NotaPeriodoDto> notaPeriodoList) {
        this.notaPeriodoList =  notaPeriodoList;
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
        if (!(object instanceof CursoDto)) {
            return false;
        }
        CursoDto other = (CursoDto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lacv.agogui.model.dtos.CursoDto[ id=" + id + " ]";
    }
    
}
