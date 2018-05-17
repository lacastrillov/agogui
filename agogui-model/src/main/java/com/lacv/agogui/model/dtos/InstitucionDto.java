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
public class InstitucionDto implements BaseEntity {

    private static final long serialVersionUID = 1L;
    
    private List<AreaDto> areaList;
    
    @Order(1)
    @ColumnWidth(200)
    @TextField("CiudadOMunicipio")
    private CiudadOMunicipioDto ciudadOMunicipio;
    
    @Order(2)
    @Size(max=60)
    @ColumnWidth(200)
    @TextField("CorreoElectronico")
    private String correoElectronico;
    
    @Order(3)
    @Size(max=20)
    @ColumnWidth(200)
    @TextField("Estado")
    private String estado;
    
    @Order(4)
    @ColumnWidth(200)
    @TextField("FechaCreacion")
    private Date fechaCreacion;
    
    private List<GradoDto> gradoList;
    
    @Order(5)
    @NotNull
    @ColumnWidth(100)
    @TextField("Id")
    private Integer id;
    
    @Order(6)
    @NotNull
    @Size(min=1,max=1)
    @ColumnWidth(200)
    @TextField("Nivel")
    private String nivel;
    
    @Order(7)
    @NotNull
    @Size(min=1,max=150)
    @ColumnWidth(200)
    @TextField("Nombre")
    private String nombre;
    
    @Order(8)
    @NotNull
    @Size(min=1,max=1)
    @ColumnWidth(200)
    @TextField("RazonSocial")
    private String razonSocial;
    
    private List<SedeDto> sedeList;
    
    @Order(9)
    @Size(max=50)
    @ColumnWidth(200)
    @TextField("Telefono")
    private String telefono;
    

    public InstitucionDto() {
    }

    public List<AreaDto> getAreaList() {
        return areaList;
    }

    public void setAreaList(List<AreaDto> areaList) {
        this.areaList =  areaList;
    }

    public CiudadOMunicipioDto getCiudadOMunicipio() {
        return ciudadOMunicipio;
    }

    public void setCiudadOMunicipio(CiudadOMunicipioDto ciudadOMunicipio) {
        this.ciudadOMunicipio =  ciudadOMunicipio;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico =  correoElectronico;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado =  estado;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion =  fechaCreacion;
    }

    public List<GradoDto> getGradoList() {
        return gradoList;
    }

    public void setGradoList(List<GradoDto> gradoList) {
        this.gradoList =  gradoList;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Object id) {
        this.id = (Integer) id;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel =  nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre =  nombre;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial =  razonSocial;
    }

    public List<SedeDto> getSedeList() {
        return sedeList;
    }

    public void setSedeList(List<SedeDto> sedeList) {
        this.sedeList =  sedeList;
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
        if (!(object instanceof InstitucionDto)) {
            return false;
        }
        InstitucionDto other = (InstitucionDto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lacv.agogui.model.dtos.InstitucionDto[ id=" + id + " ]";
    }
    
}
