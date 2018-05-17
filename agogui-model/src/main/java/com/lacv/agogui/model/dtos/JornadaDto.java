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
public class JornadaDto implements BaseEntity {

    private static final long serialVersionUID = 1L;
    
    private List<CursoDto> cursoList;
    
    private List<EstudianteDto> estudianteList;
    
    @Order(1)
    @NotNull
    @ReadOnly
    @ColumnWidth(100)
    @TextField("Id")
    private Integer id;
    
    @Order(2)
    @Size(max=60)
    @ColumnWidth(200)
    @TextField("Nombre")
    private String nombre;
    
    @Order(3)
    @ColumnWidth(200)
    @TextField("Sede")
    private SedeDto sede;
    

    public JornadaDto() {
    }

    public List<CursoDto> getCursoList() {
        return cursoList;
    }

    public void setCursoList(List<CursoDto> cursoList) {
        this.cursoList =  cursoList;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre =  nombre;
    }

    public SedeDto getSede() {
        return sede;
    }

    public void setSede(SedeDto sede) {
        this.sede =  sede;
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
        if (!(object instanceof JornadaDto)) {
            return false;
        }
        JornadaDto other = (JornadaDto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lacv.agogui.model.dtos.JornadaDto[ id=" + id + " ]";
    }
    
}
