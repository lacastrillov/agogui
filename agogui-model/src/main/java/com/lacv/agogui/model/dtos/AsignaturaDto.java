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
import com.lacv.jmagrexs.annotation.Size;
import com.lacv.jmagrexs.annotation.TextField;
import com.lacv.jmagrexs.domain.BaseDto;
import java.util.List;

/**
 *
 * @author lcastrillo
 */
@LabelField("nombre")
public class AsignaturaDto implements BaseDto {

    private static final long serialVersionUID = 1L;
    
    @Order(1)
    @NotNull
    @ColumnWidth(100)
    @TextField("C&oacute;digo")
    private Integer id;
    
    @Order(2)
    @Size(max=100)
    @ColumnWidth(200)
    @TextField("Nombre")
    private String nombre;
    
    @Order(3)
    @ColumnWidth(200)
    @TextField("Area")
    private AreaDto area;
    
    private List<DocenteAsignaturaDto> docenteAsignaturaList;
    
    private List<DocenteasignaturaCursoDto> docenteasignaturaCursoList;
    
    private List<EvaluacionDto> evaluacionList;
    
    private List<NotaEvaluacionDto> notaEvaluacionList;
    
    private List<NotaFinalDto> notaFinalList;
    
    private List<NotaPeriodoDto> notaPeriodoList;
    
    private List<TemaDto> temaList;
    

    public AsignaturaDto() {
    }

    public AreaDto getArea() {
        return area;
    }

    public void setArea(AreaDto area) {
        this.area =  area;
    }

    public List<DocenteAsignaturaDto> getDocenteAsignaturaList() {
        return docenteAsignaturaList;
    }

    public void setDocenteAsignaturaList(List<DocenteAsignaturaDto> docenteAsignaturaList) {
        this.docenteAsignaturaList =  docenteAsignaturaList;
    }

    public List<DocenteasignaturaCursoDto> getDocenteasignaturaCursoList() {
        return docenteasignaturaCursoList;
    }

    public void setDocenteasignaturaCursoList(List<DocenteasignaturaCursoDto> docenteasignaturaCursoList) {
        this.docenteasignaturaCursoList =  docenteasignaturaCursoList;
    }

    public List<EvaluacionDto> getEvaluacionList() {
        return evaluacionList;
    }

    public void setEvaluacionList(List<EvaluacionDto> evaluacionList) {
        this.evaluacionList =  evaluacionList;
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
        this.nombre =  nombre;
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

    public List<TemaDto> getTemaList() {
        return temaList;
    }

    public void setTemaList(List<TemaDto> temaList) {
        this.temaList =  temaList;
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
        if (!(object instanceof AsignaturaDto)) {
            return false;
        }
        AsignaturaDto other = (AsignaturaDto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lacv.agogui.model.dtos.AsignaturaDto[ id=" + id + " ]";
    }
    
}
