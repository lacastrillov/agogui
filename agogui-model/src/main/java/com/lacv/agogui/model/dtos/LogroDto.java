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

/**
 *
 * @author lcastrillo
 */
@LabelField("id")
public class LogroDto implements BaseDto {

    private static final long serialVersionUID = 1L;
    
    @Order(1)
    @NotNull
    @ColumnWidth(100)
    @TextField("C&oacute;digo")
    private Integer id;
    
    @Order(2)
    @NotNull
    @Size(min=1,max=500)
    @ColumnWidth(200)
    @TextField("Descripcion")
    private String descripcion;
    
    @Order(3)
    @ColumnWidth(200)
    @TextField("Competencia")
    private CompetenciaDto competencia;
    
    @Order(4)
    @ColumnWidth(200)
    @TextField("Tema")
    private TemaDto tema;
    
    @Order(5)
    @ColumnWidth(200)
    @TextField("Periodo")
    private PeriodoDto periodo;
    

    public LogroDto() {
    }

    public CompetenciaDto getCompetencia() {
        return competencia;
    }

    public void setCompetencia(CompetenciaDto competencia) {
        this.competencia =  competencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion =  descripcion;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Object id) {
        this.id = (Integer) id;
    }

    public PeriodoDto getPeriodo() {
        return periodo;
    }

    public void setPeriodo(PeriodoDto periodo) {
        this.periodo =  periodo;
    }

    public TemaDto getTema() {
        return tema;
    }

    public void setTema(TemaDto tema) {
        this.tema =  tema;
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
        if (!(object instanceof LogroDto)) {
            return false;
        }
        LogroDto other = (LogroDto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lacv.agogui.model.dtos.LogroDto[ id=" + id + " ]";
    }
    
}
