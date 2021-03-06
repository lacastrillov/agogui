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
import java.util.List;

/**
 *
 * @author lcastrillo
 */
@LabelField("alias")
public class PeriodoDto implements BaseDto {

    private static final long serialVersionUID = 1L;
    
    @Order(1)
    @ReadOnly
    @ColumnWidth(100)
    @TextField("Id")
    private Integer id;
    
    @Order(2)
    @Size(max=45)
    @ColumnWidth(200)
    @TextField("Alias")
    private String alias;
    
    @Order(3)
    @NotNull
    @ColumnWidth(200)
    @TextField("N&uacute;mero")
    private int numero;
    
    @Order(4)
    @NotNull
    @ColumnWidth(200)
    @TextField("Instituci&oacute;n")
    private InstitucionDto institucion;
    
    private List<EvaluacionDto> evaluacionList;
    
    private List<LogroDto> logroList;
    
    private List<NotaPeriodoDto> notaPeriodoList;
    

    public PeriodoDto() {
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias =  alias;
    }

    public List<EvaluacionDto> getEvaluacionList() {
        return evaluacionList;
    }

    public void setEvaluacionList(List<EvaluacionDto> evaluacionList) {
        this.evaluacionList =  evaluacionList;
    }

    public InstitucionDto getInstitucion() {
        return institucion;
    }

    public void setInstitucion(InstitucionDto institucion) {
        this.institucion =  institucion;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Object id) {
        this.id = (Integer) id;
    }

    public List<LogroDto> getLogroList() {
        return logroList;
    }

    public void setLogroList(List<LogroDto> logroList) {
        this.logroList =  logroList;
    }

    public List<NotaPeriodoDto> getNotaPeriodoList() {
        return notaPeriodoList;
    }

    public void setNotaPeriodoList(List<NotaPeriodoDto> notaPeriodoList) {
        this.notaPeriodoList =  notaPeriodoList;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero =  numero;
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
        if (!(object instanceof PeriodoDto)) {
            return false;
        }
        PeriodoDto other = (PeriodoDto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lacv.agogui.model.dtos.PeriodoDto[ id=" + id + " ]";
    }
    
}
