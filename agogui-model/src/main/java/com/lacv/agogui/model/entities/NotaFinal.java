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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.eclipse.persistence.annotations.JoinFetch;
import org.eclipse.persistence.annotations.JoinFetchType;

/**
 *
 * @author lacastrillov
 */
@Entity
@Table(name = "nota_final")
@NamedQueries({
    @NamedQuery(name = "NotaFinal.findAll", query = "SELECT n FROM NotaFinal n")})
public class NotaFinal implements BaseEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "nota_numero")
    private Double notaNumero;
    @Size(max = 10)
    @Column(name = "nota_texto")
    private String notaTexto;
    @Lob
    @Size(max = 65535)
    @Column(name = "desempenio")
    private String desempenio;
    @Size(max = 1)
    @Column(name = "formato")
    private String formato;
    @JoinColumn(name = "id_estudiante", referencedColumnName = "codigo")
    @JoinFetch(JoinFetchType.OUTER)
    @ManyToOne(optional = false)
    private Estudiante estudiante;
    @JoinColumn(name = "id_curso", referencedColumnName = "id")
    @JoinFetch(JoinFetchType.OUTER)
    @ManyToOne(optional = false)
    private Curso curso;
    @JoinColumn(name = "id_asignatura", referencedColumnName = "codigo")
    @JoinFetch(JoinFetchType.OUTER)
    @ManyToOne(optional = false)
    private Asignatura asignatura;

    public NotaFinal() {
    }

    public NotaFinal(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Object id) {
        this.id = (Integer) id;
    }

    public Double getNotaNumero() {
        return notaNumero;
    }

    public void setNotaNumero(Double notaNumero) {
        this.notaNumero = notaNumero;
    }

    public String getNotaTexto() {
        return notaTexto;
    }

    public void setNotaTexto(String notaTexto) {
        this.notaTexto = notaTexto;
    }

    public String getDesempenio() {
        return desempenio;
    }

    public void setDesempenio(String desempenio) {
        this.desempenio = desempenio;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
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
        if (!(object instanceof NotaFinal)) {
            return false;
        }
        NotaFinal other = (NotaFinal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lacv.agogui.model.entities.NotaFinal[ id=" + id + " ]";
    }
    
}
