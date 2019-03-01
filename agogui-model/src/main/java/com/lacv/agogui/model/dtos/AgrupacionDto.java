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
import java.sql.Time;
import java.util.Date;
import java.util.List;

/**
 *
 * @author lcastrillo
 */
@LabelField("id")
public class AgrupacionDto implements BaseDto {

    private static final long serialVersionUID = 1L;
    
    @Order(1)
    @ReadOnly
    @ColumnWidth(300)
    @TextField("Id")
    private String id;
    
    @Order(2)
    @ColumnWidth(200)
    @TextField("Docente")
    private DocenteDto docente;
    
    @Order(3)
    @ColumnWidth(200)
    @TextField("Estudiante")
    private EstudianteDto estudiante;
    
    @Order(4)
    @ColumnWidth(200)
    @TextField("Asignatura")
    private AsignaturaDto asignatura;
    
    @Order(5)
    @Size(max=100)
    @ColumnWidth(200)
    @TextField("Nombre Relacion")
    private String nombreRelacion;
    
    @Order(6)
    @ColumnWidth(200)
    @TextField("Anio")
    private Short anio;
    
    @Order(7)
    @ColumnWidth(100)
    @TextField("Estado")
    private Boolean estado;    
    
    @Order(8)
    @ColumnWidth(200)
    @TextField("Fecha Grupo")
    private Date fechaGrupo;

    
    

    public AgrupacionDto() {
    }

    public Short getAnio() {
        return anio;
    }

    public void setAnio(Short anio) {
        this.anio =  anio;
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

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado =  estado;
    }

    public EstudianteDto getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(EstudianteDto estudiante) {
        this.estudiante =  estudiante;
    }

    public Date getFechaGrupo() {
        return fechaGrupo;
    }

    public void setFechaGrupo(Date fechaGrupo) {
        this.fechaGrupo =  fechaGrupo;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(Object id) {
        this.id = (String) id;
    }

    public String getNombreRelacion() {
        return nombreRelacion;
    }

    public void setNombreRelacion(String nombreRelacion) {
        this.nombreRelacion =  nombreRelacion;
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
        if (!(object instanceof AgrupacionDto)) {
            return false;
        }
        AgrupacionDto other = (AgrupacionDto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lacv.agogui.model.dtos.AgrupacionDto[ id=" + id + " ]";
    }
    
}
