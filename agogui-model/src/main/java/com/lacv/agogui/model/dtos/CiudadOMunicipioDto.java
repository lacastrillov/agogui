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
import java.util.List;

/**
 *
 * @author lcastrillo
 */
@LabelField("nombre")
public class CiudadOMunicipioDto implements BaseEntity {

    private static final long serialVersionUID = 1L;
    
    @Order(1)
    @ReadOnly
    @ColumnWidth(100)
    @TextField("Id")
    private Integer id;
    
    @Order(2)
    @NotNull
    @Size(min=1,max=100)
    @ColumnWidth(200)
    @TextField("Nombre")
    private String nombre;
    
    @Order(3)
    @ColumnWidth(200)
    @TextField("Departamento")
    private DepartamentoDto departamento;
    
    private List<DocenteDto> docenteList;
    
    private List<EstudianteDto> estudianteList;
    
    private List<InstitucionDto> institucionList;
    

    public CiudadOMunicipioDto() {
    }

    public DepartamentoDto getDepartamento() {
        return departamento;
    }

    public void setDepartamento(DepartamentoDto departamento) {
        this.departamento =  departamento;
    }

    public List<DocenteDto> getDocenteList() {
        return docenteList;
    }

    public void setDocenteList(List<DocenteDto> docenteList) {
        this.docenteList =  docenteList;
    }

    public List<EstudianteDto> getEstudianteList() {
        return estudianteList;
    }

    public void setEstudianteList(List<EstudianteDto> estudianteList) {
        this.estudianteList =  estudianteList;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Object id) {
        this.id = (Integer) id;
    }

    public List<InstitucionDto> getInstitucionList() {
        return institucionList;
    }

    public void setInstitucionList(List<InstitucionDto> institucionList) {
        this.institucionList =  institucionList;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre =  nombre;
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
        if (!(object instanceof CiudadOMunicipioDto)) {
            return false;
        }
        CiudadOMunicipioDto other = (CiudadOMunicipioDto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lacv.agogui.model.dtos.CiudadOMunicipioDto[ id=" + id + " ]";
    }
    
}
