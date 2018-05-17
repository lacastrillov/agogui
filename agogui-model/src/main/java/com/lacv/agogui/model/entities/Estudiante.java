/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lacv.agogui.model.entities;

import com.lacv.jmagrexs.domain.BaseEntity;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author lacastrillov
 */
@Entity
@Table(name = "estudiante")
@NamedQueries({
    @NamedQuery(name = "Estudiante.findAll", query = "SELECT e FROM Estudiante e")})
public class Estudiante implements BaseEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "documento_id")
    private long documentoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "primer_apellido")
    private String primerApellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "segundo_apellido")
    private String segundoApellido;
    @Size(max = 1)
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Size(max = 100)
    @Column(name = "foto")
    private String foto;
    @Size(max = 50)
    @Column(name = "nacionalidad")
    private String nacionalidad;
    @Size(max = 100)
    @Column(name = "barrio")
    private String barrio;
    @Size(max = 150)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 50)
    @Column(name = "telefono1")
    private String telefono1;
    @Size(max = 50)
    @Column(name = "telefono2")
    private String telefono2;
    @Size(max = 60)
    @Column(name = "correo_electronico")
    private String correoElectronico;
    @Column(name = "tipo_acceso")
    private Integer tipoAcceso;
    @Column(name = "estado")
    private Boolean estado;
    @JoinColumn(name = "id_ciudad_o_municipio", referencedColumnName = "id")
    @ManyToOne
    private CiudadOMunicipio ciudadOMunicipio;
    @JoinColumn(name = "id_jornada", referencedColumnName = "id")
    @ManyToOne
    private Jornada jornada;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estudiante")
    private List<NotaFinal> notaFinalList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estudiante")
    private List<NotaPeriodo> notaPeriodoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estudiante")
    private List<NotaEvaluacion> notaEvaluacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estudiante")
    private List<EstudianteCurso> estudianteCursoList;

    public Estudiante() {
    }

    public Estudiante(Integer codigo) {
        this.id = codigo;
    }

    public Estudiante(Integer codigo, long documentoId, String nombre, String primerApellido, String segundoApellido) {
        this.id = codigo;
        this.documentoId = documentoId;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Object id) {
        this.id = (Integer) id;
    }

    public long getDocumentoId() {
        return documentoId;
    }

    public void setDocumentoId(long documentoId) {
        this.documentoId = documentoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public Integer getTipoAcceso() {
        return tipoAcceso;
    }

    public void setTipoAcceso(Integer tipoAcceso) {
        this.tipoAcceso = tipoAcceso;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public CiudadOMunicipio getCiudadOMunicipio() {
        return ciudadOMunicipio;
    }

    public void setCiudadOMunicipio(CiudadOMunicipio ciudadOMunicipio) {
        this.ciudadOMunicipio = ciudadOMunicipio;
    }

    public Jornada getJornada() {
        return jornada;
    }

    public void setJornada(Jornada jornada) {
        this.jornada = jornada;
    }

    public List<NotaFinal> getNotaFinalList() {
        return notaFinalList;
    }

    public void setNotaFinalList(List<NotaFinal> notaFinalList) {
        this.notaFinalList = notaFinalList;
    }

    public List<NotaPeriodo> getNotaPeriodoList() {
        return notaPeriodoList;
    }

    public void setNotaPeriodoList(List<NotaPeriodo> notaPeriodoList) {
        this.notaPeriodoList = notaPeriodoList;
    }

    public List<NotaEvaluacion> getNotaEvaluacionList() {
        return notaEvaluacionList;
    }

    public void setNotaEvaluacionList(List<NotaEvaluacion> notaEvaluacionList) {
        this.notaEvaluacionList = notaEvaluacionList;
    }

    public List<EstudianteCurso> getEstudianteCursoList() {
        return estudianteCursoList;
    }

    public void setEstudianteCursoList(List<EstudianteCurso> estudianteCursoList) {
        this.estudianteCursoList = estudianteCursoList;
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
        if (!(object instanceof Estudiante)) {
            return false;
        }
        Estudiante other = (Estudiante) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lacv.agogui.model.entities.Estudiante[ codigo=" + id + " ]";
    }
    
}
