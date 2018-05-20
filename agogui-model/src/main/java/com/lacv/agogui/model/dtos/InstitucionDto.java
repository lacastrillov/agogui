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
import com.lacv.jmagrexs.annotation.TypeFormField;
import com.lacv.jmagrexs.domain.BaseEntity;
import com.lacv.jmagrexs.enums.FieldType;
import java.util.Date;
import java.util.List;

/**
 *
 * @author lcastrillo
 */
@LabelField("nombre")
public class InstitucionDto implements BaseEntity {

    private static final long serialVersionUID = 1L;
    
    @Order(1)
    @NotNull
    @ColumnWidth(100)
    @TextField("C&oacute;digo")
    private Integer id;
    
    @Order(2)
    @NotNull
    @Size(min=1,max=150)
    @ColumnWidth(200)
    @TextField("Nombre")
    private String nombre;
    
    @Order(3)
    @NotNull
    @Size(min=1,max=1)
    @ColumnWidth(200)
    @TextField("Nivel")
    private String nivel;
    
    @Order(4)
    @NotNull
    @Size(min=1,max=1)
    @ColumnWidth(200)
    @TextField("Razon Social")
    private String razonSocial;
    
    @Order(5)
    @ColumnWidth(200)
    @TextField("Fecha Creaci&oacute;n")
    private Date fechaCreacion;
    
    @Order(6)
    @Size(max=60)
    @ColumnWidth(200)
    @TextField("Correo Electr&oacute;nico")
    private String correoElectronico;
    
    @Order(7)
    @Size(max=50)
    @ColumnWidth(200)
    @TextField("Tel&eacute;fono")
    private String telefono;
    
    @Order(8)
    @ColumnWidth(200)
    @TextField("Pais")
    private PaisDto pais;
    
    @Order(9)
    @ColumnWidth(200)
    @TextField("Departamento")
    private DepartamentoDto departamento;
    
    @Order(10)
    @ColumnWidth(200)
    @TextField("Ciudad o Municipio")
    private CiudadOMunicipioDto ciudadOMunicipio;
    
    @Order(11)
    @Size(max=20)
    @ColumnWidth(200)
    @TextField("Estado")
    @TypeFormField(value = FieldType.MULTI_SELECT, data = {"Active", "Inactive", "Locked", "Deleted"})
    private String estado;
    
    private List<GradoDto> gradoList;
    
    private List<AreaDto> areaList;
    
    private List<SedeDto> sedeList;
    
    private List<PeriodoDto> periodoList;
    
    private List<JornadaDto> jornadaList;
    

    public InstitucionDto() {
    }

    public List<AreaDto> getAreaList() {
        return areaList;
    }

    public void setAreaList(List<AreaDto> areaList) {
        this.areaList =  areaList;
    }
    
    public PaisDto getPais() {
        return pais;
    }

    public void setPais(PaisDto pais) {
        this.pais = pais;
    }
    
    public DepartamentoDto getDepartamento() {
        return departamento;
    }

    public void setDepartamento(DepartamentoDto departamento) {
        this.departamento = departamento;
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
    
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono =  telefono;
    }

    public List<SedeDto> getSedeList() {
        return sedeList;
    }

    public void setSedeList(List<SedeDto> sedeList) {
        this.sedeList =  sedeList;
    }
    
    public List<PeriodoDto> getPeriodoList() {
        return periodoList;
    }

    public void setPeriodoList(List<PeriodoDto> periodoList) {
        this.periodoList =  periodoList;
    }
    
    public List<JornadaDto> getJornadaList() {
        return jornadaList;
    }

    public void setJornadaList(List<JornadaDto> jornadaList) {
        this.jornadaList =  jornadaList;
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
