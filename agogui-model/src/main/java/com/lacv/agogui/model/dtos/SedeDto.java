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
public class SedeDto implements BaseEntity {

    private static final long serialVersionUID = 1L;
    
    @Order(1)
    @Size(max=60)
    @ColumnWidth(200)
    @TextField("CorreoElectronico")
    private String correoElectronico;
    
    @Order(2)
    @Size(max=150)
    @ColumnWidth(200)
    @TextField("Direccion")
    private String direccion;
    
    private List<DocenteDto> docenteList;
    
    @Order(3)
    @NotNull
    @ReadOnly
    @ColumnWidth(100)
    @TextField("Id")
    private Integer id;
    
    @Order(4)
    @ColumnWidth(200)
    @TextField("Institucion")
    private InstitucionDto institucion;
    
    private List<JornadaDto> jornadaList;
    
    @Order(5)
    @NotNull
    @Size(min=1,max=150)
    @ColumnWidth(200)
    @TextField("Nombre")
    private String nombre;
    
    @Order(6)
    @Size(max=50)
    @ColumnWidth(200)
    @TextField("Telefono")
    private String telefono;
    

    public SedeDto() {
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico =  correoElectronico;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion =  direccion;
    }

    public List<DocenteDto> getDocenteList() {
        return docenteList;
    }

    public void setDocenteList(List<DocenteDto> docenteList) {
        this.docenteList =  docenteList;
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

    public List<JornadaDto> getJornadaList() {
        return jornadaList;
    }

    public void setJornadaList(List<JornadaDto> jornadaList) {
        this.jornadaList =  jornadaList;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre =  nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono =  telefono;
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
        if (!(object instanceof SedeDto)) {
            return false;
        }
        SedeDto other = (SedeDto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lacv.agogui.model.dtos.SedeDto[ id=" + id + " ]";
    }
    
}
