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
import com.lacv.jmagrexs.domain.BaseDto;
import com.lacv.jmagrexs.enums.FieldType;
import java.util.Date;
import java.util.List;

/**
 *
 * @author lcastrillo
 */
@LabelField("nombre")
public class EstudianteDto implements BaseDto {

    private static final long serialVersionUID = 1L;
    
    @Order(1)
    @NotNull
    @ColumnWidth(100)
    @TextField("Id")
    private Integer id;
    
    @Order(2)
    @NotNull
    @ColumnWidth(200)
    @TextField("Documento Id")
    private long documentoId;
    
    @Order(3)
    @NotNull
    @Size(min=1,max=100)
    @ColumnWidth(200)
    @TextField("Nombre")
    private String nombre;
    
    @Order(4)
    @NotNull
    @Size(min=1,max=50)
    @ColumnWidth(200)
    @TextField("Primer Apellido")
    private String primerApellido;
    
    @Order(5)
    @NotNull
    @Size(min=1,max=50)
    @ColumnWidth(200)
    @TextField("Segundo Apellido")
    private String segundoApellido;
    
    @Order(6)
    @Size(max=1)
    @ColumnWidth(200)
    @TextField("Sexo")
    @TypeFormField(value = FieldType.LIST, data = {"F:Femenino", "M:Masculino"})
    private String sexo;
    
    @Order(7)
    @ColumnWidth(200)
    @TextField("Fecha Nacimiento")
    private Date fechaNacimiento;
    
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
    @Size(max=100)
    @ColumnWidth(200)
    @TextField("Barrio")
    private String barrio;
    
    @Order(12)
    @Size(max=150)
    @ColumnWidth(200)
    @TextField("Direcci&oacute;n")
    private String direccion;
    
    @Order(13)
    @Size(max=60)
    @ColumnWidth(200)
    @TextField("Correo Electr&oacute;nico")
    private String correoElectronico;
    
    @Order(14)
    @Size(max=50)
    @ColumnWidth(200)
    @TextField("Telefono 1")
    private String telefono1;
    
    @Order(15)
    @Size(max=50)
    @ColumnWidth(200)
    @TextField("Telefono 2")
    private String telefono2;
    
    @Order(16)
    @ColumnWidth(200)
    @TextField("Sede")
    private SedeDto sede;
    
    @Order(17)
    @Size(max=100)
    @ColumnWidth(200)
    @TextField("Foto")
    private String foto;
    
    @Order(18)
    @ColumnWidth(200)
    @TextField("TipoAcceso")
    private Integer tipoAcceso;
    
    @Order(19)
    @ColumnWidth(100)
    @TextField("Estado")
    @TypeFormField(value = FieldType.MULTI_SELECT, data = {"Active", "Inactive", "Locked", "Deleted"})
    private String estado;
    
    @Order(20)
    @ColumnWidth(200)
    @TextField("Fecha Registro")
    private Date fechaRegistro;
    
    private List<EstudianteCursoDto> estudianteCursoList;
    
    private List<NotaEvaluacionDto> notaEvaluacionList;
    
    private List<NotaFinalDto> notaFinalList;
    
    private List<NotaPeriodoDto> notaPeriodoList;
    

    public EstudianteDto() {
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio =  barrio;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion =  direccion;
    }

    public long getDocumentoId() {
        return documentoId;
    }

    public void setDocumentoId(long documentoId) {
        this.documentoId =  documentoId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado =  estado;
    }

    public List<EstudianteCursoDto> getEstudianteCursoList() {
        return estudianteCursoList;
    }

    public void setEstudianteCursoList(List<EstudianteCursoDto> estudianteCursoList) {
        this.estudianteCursoList =  estudianteCursoList;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento =  fechaNacimiento;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro =  fechaRegistro;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto =  foto;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Object id) {
        this.id = (Integer) id;
    }

    public SedeDto getSede() {
        return sede;
    }

    public void setSede(SedeDto sede) {
        this.sede =  sede;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre =  nombre;
    }

    public List<NotaEvaluacionDto> getNotaEvaluacionList() {
        return notaEvaluacionList;
    }

    public void setNotaEvaluacionList(List<NotaEvaluacionDto> notaEvaluacionList) {
        this.notaEvaluacionList =  notaEvaluacionList;
    }

    public List<NotaFinalDto> getNotaFinalList() {
        return notaFinalList;
    }

    public void setNotaFinalList(List<NotaFinalDto> notaFinalList) {
        this.notaFinalList =  notaFinalList;
    }

    public List<NotaPeriodoDto> getNotaPeriodoList() {
        return notaPeriodoList;
    }

    public void setNotaPeriodoList(List<NotaPeriodoDto> notaPeriodoList) {
        this.notaPeriodoList =  notaPeriodoList;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido =  primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido =  segundoApellido;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo =  sexo;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 =  telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 =  telefono2;
    }

    public Integer getTipoAcceso() {
        return tipoAcceso;
    }

    public void setTipoAcceso(Integer tipoAcceso) {
        this.tipoAcceso =  tipoAcceso;
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
        if (!(object instanceof EstudianteDto)) {
            return false;
        }
        EstudianteDto other = (EstudianteDto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lacv.agogui.model.dtos.EstudianteDto[ id=" + id + " ]";
    }
    
}
