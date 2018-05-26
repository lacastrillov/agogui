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
@LabelField("nombre")
public class SedeDto implements BaseDto {

    private static final long serialVersionUID = 1L;
    
    @Order(1)
    @ReadOnly
    @ColumnWidth(100)
    @TextField("Id")
    private Integer id;
    
    @Order(2)
    @NotNull
    @Size(min=1,max=150)
    @ColumnWidth(200)
    @TextField("Nombre")
    private String nombre;
    
    @Order(3)
    @Size(max=150)
    @ColumnWidth(200)
    @TextField("Direcci&oacute;n")
    private String direccion;
    
    @Order(4)
    @Size(max=60)
    @ColumnWidth(200)
    @TextField("Correo Electr&oacute;nico")
    private String correoElectronico;
    
    @Order(5)
    @Size(max=50)
    @ColumnWidth(200)
    @TextField("Tel&eacute;fono")
    private String telefono;
    
    @Order(6)
    @ColumnWidth(200)
    @TextField("Instituci&oacute;n")
    private InstitucionDto institucion;
    
    private List<DocenteDto> docenteList;
    
    private List<EstudianteDto> estudianteList;
    
    private List<CursoDto> cursoList;

    public SedeDto() {
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Object id) {
        this.id = (Integer) id;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono =  telefono;
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
    
    public List<CursoDto> getCursoList() {
        return cursoList;
    }

    public void setCursoList(List<CursoDto> cursoList) {
        this.cursoList = cursoList;
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
