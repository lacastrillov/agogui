/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lacv.agogui.model.dtos;

import com.lacv.jmagrexs.annotation.ColumnWidth;
import com.lacv.jmagrexs.annotation.LabelField;
import com.lacv.jmagrexs.annotation.Order;
import com.lacv.jmagrexs.annotation.ReadOnly;
import com.lacv.jmagrexs.annotation.Size;
import com.lacv.jmagrexs.annotation.TextField;
import com.lacv.jmagrexs.annotation.TypeFormField;
import com.lacv.jmagrexs.domain.BaseDto;
import com.lacv.jmagrexs.enums.FieldType;

/**
 *
 * @author lcastrillo
 */
@LabelField("id")
public class DocenteAsignaturaDto implements BaseDto {

    private static final long serialVersionUID = 1L;
    
    @Order(1)
    @ReadOnly
    @ColumnWidth(100)
    @TextField("Id")
    private Integer id;
    
    @Order(2)
    @ColumnWidth(200)
    @TextField("Docente")
    private DocenteDto docente;
    
    @Order(3)
    @ColumnWidth(200)
    @TextField("Asignatura")
    private AsignaturaDto asignatura;
    
    @Order(4)
    @Size(max=1)
    @ColumnWidth(200)
    @TextField("Habilitado")
    @TypeFormField(value = FieldType.MULTI_SELECT, data = {"S", "N"})
    private String habilitado;
    

    public DocenteAsignaturaDto() {
    }

    public AsignaturaDto getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(AsignaturaDto asignatura) {
        this.asignatura =  asignatura;
    }

    public DocenteDto getDocente() {
        return docente;
    }

    public void setDocente(DocenteDto docente) {
        this.docente =  docente;
    }

    public String getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(String habilitado) {
        this.habilitado =  habilitado;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Object id) {
        this.id = (Integer) id;
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
        if (!(object instanceof DocenteAsignaturaDto)) {
            return false;
        }
        DocenteAsignaturaDto other = (DocenteAsignaturaDto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lacv.agogui.model.dtos.DocenteAsignaturaDto[ id=" + id + " ]";
    }
    
}
