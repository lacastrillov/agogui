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
import com.lacv.jmagrexs.annotation.TextField;
import com.lacv.jmagrexs.domain.BaseDto;
import com.lacv.jmagrexs.modules.security.model.dtos.UserDto;

/**
 *
 * @author lcastrillo
 */
@LabelField("id")
public class InstitucionUserDto implements BaseDto {

    private static final long serialVersionUID = 1L;
    
    @Order(1)
    @ReadOnly
    @ColumnWidth(100)
    @TextField("Id")
    private Integer id;
    
    @Order(2)
    @ColumnWidth(200)
    @TextField("Instituci&oacute;n")
    private InstitucionDto institucion;
    
    @Order(3)
    @ColumnWidth(200)
    @TextField("Usuario")
    private UserDto user;
    

    public InstitucionUserDto() {
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

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user =  user;
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
        if (!(object instanceof InstitucionUserDto)) {
            return false;
        }
        InstitucionUserDto other = (InstitucionUserDto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lacv.agogui.model.dtos.InstitucionUserDto[ id=" + id + " ]";
    }
    
}
