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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "persona_interes", catalog = "plaza_segura", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonaInteres.findAll", query = "SELECT p FROM PersonaInteres p")
    , @NamedQuery(name = "PersonaInteres.findByPersonaInteresId", query = "SELECT p FROM PersonaInteres p WHERE p.personaInteresId = :personaInteresId")
    , @NamedQuery(name = "PersonaInteres.findByPersonaInteresDocumento", query = "SELECT p FROM PersonaInteres p WHERE p.personaInteresDocumento = :personaInteresDocumento")
    , @NamedQuery(name = "PersonaInteres.findByPersonaInteresNombres", query = "SELECT p FROM PersonaInteres p WHERE p.personaInteresNombres = :personaInteresNombres")
    , @NamedQuery(name = "PersonaInteres.findByPersonaInteresApellidos", query = "SELECT p FROM PersonaInteres p WHERE p.personaInteresApellidos = :personaInteresApellidos")
    , @NamedQuery(name = "PersonaInteres.findByPersonaInteresActivo", query = "SELECT p FROM PersonaInteres p WHERE p.personaInteresActivo = :personaInteresActivo")})
public class PersonaInteres implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "persona_interes_id")
    private Integer personaInteresId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "persona_interes_documento")
    private String personaInteresDocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "persona_interes_nombres")
    private String personaInteresNombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "persona_interes_apellidos")
    private String personaInteresApellidos;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "persona_interes_observacion")
    private String personaInteresObservacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "persona_interes_activo")
    private boolean personaInteresActivo;
    @JoinColumn(name = "persona_interes_id_nacionalidad", referencedColumnName = "nacionalidad_id")
    @ManyToOne(optional = false)
    private Nacionalidad personaInteresIdNacionalidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alertaPersonaInteresIdPersona")
    private List<AlertaPersonaInteres> alertaPersonaInteresList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "antecedentesIdPersona")
    private List<Antecedentes> antecedentesList;

    public PersonaInteres() {
    }

    public PersonaInteres(Integer personaInteresId) {
        this.personaInteresId = personaInteresId;
    }

    public PersonaInteres(Integer personaInteresId, String personaInteresDocumento, String personaInteresNombres, String personaInteresApellidos, boolean personaInteresActivo) {
        this.personaInteresId = personaInteresId;
        this.personaInteresDocumento = personaInteresDocumento;
        this.personaInteresNombres = personaInteresNombres;
        this.personaInteresApellidos = personaInteresApellidos;
        this.personaInteresActivo = personaInteresActivo;
    }

    public Integer getPersonaInteresId() {
        return personaInteresId;
    }

    public void setPersonaInteresId(Integer personaInteresId) {
        this.personaInteresId = personaInteresId;
    }

    public String getPersonaInteresDocumento() {
        return personaInteresDocumento;
    }

    public void setPersonaInteresDocumento(String personaInteresDocumento) {
        this.personaInteresDocumento = personaInteresDocumento;
    }

    public String getPersonaInteresNombres() {
        return personaInteresNombres;
    }

    public void setPersonaInteresNombres(String personaInteresNombres) {
        this.personaInteresNombres = personaInteresNombres;
    }

    public String getPersonaInteresApellidos() {
        return personaInteresApellidos;
    }

    public void setPersonaInteresApellidos(String personaInteresApellidos) {
        this.personaInteresApellidos = personaInteresApellidos;
    }

    public String getPersonaInteresObservacion() {
        return personaInteresObservacion;
    }

    public void setPersonaInteresObservacion(String personaInteresObservacion) {
        this.personaInteresObservacion = personaInteresObservacion;
    }

    public boolean getPersonaInteresActivo() {
        return personaInteresActivo;
    }

    public void setPersonaInteresActivo(boolean personaInteresActivo) {
        this.personaInteresActivo = personaInteresActivo;
    }

    public Nacionalidad getPersonaInteresIdNacionalidad() {
        return personaInteresIdNacionalidad;
    }

    public void setPersonaInteresIdNacionalidad(Nacionalidad personaInteresIdNacionalidad) {
        this.personaInteresIdNacionalidad = personaInteresIdNacionalidad;
    }

    @XmlTransient
    public List<AlertaPersonaInteres> getAlertaPersonaInteresList() {
        return alertaPersonaInteresList;
    }

    public void setAlertaPersonaInteresList(List<AlertaPersonaInteres> alertaPersonaInteresList) {
        this.alertaPersonaInteresList = alertaPersonaInteresList;
    }

    @XmlTransient
    public List<Antecedentes> getAntecedentesList() {
        return antecedentesList;
    }

    public void setAntecedentesList(List<Antecedentes> antecedentesList) {
        this.antecedentesList = antecedentesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personaInteresId != null ? personaInteresId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonaInteres)) {
            return false;
        }
        PersonaInteres other = (PersonaInteres) object;
        if ((this.personaInteresId == null && other.personaInteresId != null) || (this.personaInteresId != null && !this.personaInteresId.equals(other.personaInteresId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.plaza_segura_webapp.entities.PersonaInteres[ personaInteresId=" + personaInteresId + " ]";
    }
    
}
