/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.plaza_segura_webapp.entities;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ianfr
 */
@Entity
@Table(name = "antecedentes", catalog = "plaza_segura", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Antecedentes.findAll", query = "SELECT a FROM Antecedentes a")
    , @NamedQuery(name = "Antecedentes.findByAntecedentesId", query = "SELECT a FROM Antecedentes a WHERE a.antecedentesId = :antecedentesId")})
public class Antecedentes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "antecedentes_id")
    private Integer antecedentesId;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "antecedentes_descripcion")
    private String antecedentesDescripcion;
    @JoinColumn(name = "antecedentes_id_persona", referencedColumnName = "persona_interes_id")
    @ManyToOne(optional = false)
    private PersonaInteres antecedentesIdPersona;

    public Antecedentes() {
    }

    public Antecedentes(Integer antecedentesId) {
        this.antecedentesId = antecedentesId;
    }

    public Antecedentes(Integer antecedentesId, String antecedentesDescripcion) {
        this.antecedentesId = antecedentesId;
        this.antecedentesDescripcion = antecedentesDescripcion;
    }

    public Integer getAntecedentesId() {
        return antecedentesId;
    }

    public void setAntecedentesId(Integer antecedentesId) {
        this.antecedentesId = antecedentesId;
    }

    public String getAntecedentesDescripcion() {
        return antecedentesDescripcion;
    }

    public void setAntecedentesDescripcion(String antecedentesDescripcion) {
        this.antecedentesDescripcion = antecedentesDescripcion;
    }

    public PersonaInteres getAntecedentesIdPersona() {
        return antecedentesIdPersona;
    }

    public void setAntecedentesIdPersona(PersonaInteres antecedentesIdPersona) {
        this.antecedentesIdPersona = antecedentesIdPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (antecedentesId != null ? antecedentesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Antecedentes)) {
            return false;
        }
        Antecedentes other = (Antecedentes) object;
        if ((this.antecedentesId == null && other.antecedentesId != null) || (this.antecedentesId != null && !this.antecedentesId.equals(other.antecedentesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.plaza_segura_webapp.entities.Antecedentes[ antecedentesId=" + antecedentesId + " ]";
    }
    
}
