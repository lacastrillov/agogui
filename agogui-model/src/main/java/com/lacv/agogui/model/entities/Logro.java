/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lacv.agogui.model.entities;

import com.lacv.jmagrexs.domain.BaseEntity;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author lacastrillov
 */
@Entity
@Table(name = "logro")
@NamedQueries({
    @NamedQuery(name = "Logro.findAll", query = "SELECT l FROM Logro l")})
public class Logro implements BaseEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "id_tema", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tema tema;
    @JoinColumn(name = "id_competencia", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Competencia competencia;
    @JoinColumn(name = "id_periodo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Periodo periodo;

    public Logro() {
    }

    public Logro(Integer codigo) {
        this.id = codigo;
    }

    public Logro(Integer codigo, String descripcion) {
        this.id = codigo;
        this.descripcion = descripcion;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Object id) {
        this.id = (Integer) id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public Competencia getCompetencia() {
        return competencia;
    }

    public void setCompetencia(Competencia competencia) {
        this.competencia = competencia;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
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
        if (!(object instanceof Logro)) {
            return false;
        }
        Logro other = (Logro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lacv.agogui.model.entities.Logro[ codigo=" + id + " ]";
    }
    
}
