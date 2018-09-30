/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.plaza_segura_webapp.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ianfr
 */
@Entity
@Table(name = "nacionalidad", catalog = "plaza_segura", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nacionalidad.findAll", query = "SELECT n FROM Nacionalidad n")
    , @NamedQuery(name = "Nacionalidad.findByNacionalidadId", query = "SELECT n FROM Nacionalidad n WHERE n.nacionalidadId = :nacionalidadId")
    , @NamedQuery(name = "Nacionalidad.findByNacionalidadNombre", query = "SELECT n FROM Nacionalidad n WHERE n.nacionalidadNombre = :nacionalidadNombre")})
public class Nacionalidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nacionalidad_id")
    private Integer nacionalidadId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nacionalidad_nombre")
    private String nacionalidadNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personaInteresIdNacionalidad")
    private List<PersonaInteres> personaInteresList;

    public Nacionalidad() {
    }

    public Nacionalidad(Integer nacionalidadId) {
        this.nacionalidadId = nacionalidadId;
    }

    public Nacionalidad(Integer nacionalidadId, String nacionalidadNombre) {
        this.nacionalidadId = nacionalidadId;
        this.nacionalidadNombre = nacionalidadNombre;
    }

    public Integer getNacionalidadId() {
        return nacionalidadId;
    }

    public void setNacionalidadId(Integer nacionalidadId) {
        this.nacionalidadId = nacionalidadId;
    }

    public String getNacionalidadNombre() {
        return nacionalidadNombre;
    }

    public void setNacionalidadNombre(String nacionalidadNombre) {
        this.nacionalidadNombre = nacionalidadNombre;
    }

    @XmlTransient
    public List<PersonaInteres> getPersonaInteresList() {
        return personaInteresList;
    }

    public void setPersonaInteresList(List<PersonaInteres> personaInteresList) {
        this.personaInteresList = personaInteresList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nacionalidadId != null ? nacionalidadId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nacionalidad)) {
            return false;
        }
        Nacionalidad other = (Nacionalidad) object;
        if ((this.nacionalidadId == null && other.nacionalidadId != null) || (this.nacionalidadId != null && !this.nacionalidadId.equals(other.nacionalidadId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.plaza_segura_webapp.entities.Nacionalidad[ nacionalidadId=" + nacionalidadId + " ]";
    }
    
}
