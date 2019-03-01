/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lacv.agogui.model.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author lacastrillov
 */
@Embeddable
public class AgrupacionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_docente")
    private int docente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_estudiante")
    private int estudiante;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_asignatura")
    private int asignatura;

    public AgrupacionPK() {
    }

    public AgrupacionPK(int docente, int estudiante, int asignatura) {
        this.docente = docente;
        this.estudiante = estudiante;
        this.asignatura = asignatura;
    }

    public int getDocente() {
        return docente;
    }

    public void setDocente(int docente) {
        this.docente = docente;
    }

    public int getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(int estudiante) {
        this.estudiante = estudiante;
    }

    public int getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(int asignatura) {
        this.asignatura = asignatura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) docente;
        hash += (int) estudiante;
        hash += (int) asignatura;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AgrupacionPK)) {
            return false;
        }
        AgrupacionPK other = (AgrupacionPK) object;
        if (this.docente != other.docente) {
            return false;
        }
        if (this.estudiante != other.estudiante) {
            return false;
        }
        if (this.asignatura != other.asignatura) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lacv.agogui.model.entities.AgrupacionPK[ codigoDocente=" + docente + ", codigoEstudiante=" + estudiante + ", codigoAsignatura=" + asignatura + " ]";
    }
    
}
