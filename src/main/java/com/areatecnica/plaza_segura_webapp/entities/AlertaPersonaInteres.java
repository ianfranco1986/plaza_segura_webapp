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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ianfr
 */
@Entity
@Table(name = "alerta_persona_interes", catalog = "plaza_segura", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AlertaPersonaInteres.findAll", query = "SELECT a FROM AlertaPersonaInteres a")
    , @NamedQuery(name = "AlertaPersonaInteres.findByAlertaPersonaInteresId", query = "SELECT a FROM AlertaPersonaInteres a WHERE a.alertaPersonaInteresId = :alertaPersonaInteresId")})
public class AlertaPersonaInteres implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "alerta_persona_interes_id")
    private Integer alertaPersonaInteresId;
    @JoinColumn(name = "alerta_persona_interes_id_alerta", referencedColumnName = "alerta_id")
    @ManyToOne(optional = false)
    private Alerta alertaPersonaInteresIdAlerta;
    @JoinColumn(name = "alerta_persona_interes_id_persona", referencedColumnName = "persona_interes_id")
    @ManyToOne(optional = false)
    private PersonaInteres alertaPersonaInteresIdPersona;

    public AlertaPersonaInteres() {
    }

    public AlertaPersonaInteres(Integer alertaPersonaInteresId) {
        this.alertaPersonaInteresId = alertaPersonaInteresId;
    }

    public Integer getAlertaPersonaInteresId() {
        return alertaPersonaInteresId;
    }

    public void setAlertaPersonaInteresId(Integer alertaPersonaInteresId) {
        this.alertaPersonaInteresId = alertaPersonaInteresId;
    }

    public Alerta getAlertaPersonaInteresIdAlerta() {
        return alertaPersonaInteresIdAlerta;
    }

    public void setAlertaPersonaInteresIdAlerta(Alerta alertaPersonaInteresIdAlerta) {
        this.alertaPersonaInteresIdAlerta = alertaPersonaInteresIdAlerta;
    }

    public PersonaInteres getAlertaPersonaInteresIdPersona() {
        return alertaPersonaInteresIdPersona;
    }

    public void setAlertaPersonaInteresIdPersona(PersonaInteres alertaPersonaInteresIdPersona) {
        this.alertaPersonaInteresIdPersona = alertaPersonaInteresIdPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (alertaPersonaInteresId != null ? alertaPersonaInteresId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlertaPersonaInteres)) {
            return false;
        }
        AlertaPersonaInteres other = (AlertaPersonaInteres) object;
        if ((this.alertaPersonaInteresId == null && other.alertaPersonaInteresId != null) || (this.alertaPersonaInteresId != null && !this.alertaPersonaInteresId.equals(other.alertaPersonaInteresId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.plaza_segura_webapp.entities.AlertaPersonaInteres[ alertaPersonaInteresId=" + alertaPersonaInteresId + " ]";
    }
    
}
