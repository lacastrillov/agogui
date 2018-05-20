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
public class AreaDto implements BaseEntity {

    private static final long serialVersionUID = 1L;
    
    @Order(1)
    @NotNull
    @ReadOnly
    @ColumnWidth(100)
    @TextField("Id")
    private Integer id;
    
    @Order(2)
    @NotNull
    @Size(min=1,max=45)
    @ColumnWidth(200)
    @TextField("Nombre")
    private String nombre;
    
    @Order(3)
    @Size(max=65535)
    @ColumnWidth(200)
    @TextField("Descripci&oacute;n")
    private String descripcion;
    
    @Order(4)
    @ColumnWidth(200)
    @TextField("Instituci&oacute;n")
    private InstitucionDto institucion;
    
    private List<AsignaturaDto> asignaturaList;
    

    public AreaDto() {
    }

    public List<AsignaturaDto> getAsignaturaList() {
        return asignaturaList;
    }

    public void setAsignaturaList(List<AsignaturaDto> asignaturaList) {
        this.asignaturaList =  asignaturaList;
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

    public InstitucionDto getInstitucion() {
        return institucion;
    }

    public void setInstitucion(InstitucionDto institucion) {
        this.institucion =  institucion;
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
        if (!(object instanceof AreaDto)) {
            return false;
        }
        AreaDto other = (AreaDto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lacv.agogui.model.dtos.AreaDto[ id=" + id + " ]";
    }
    
}
