/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.plaza_segura_webapp.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ianfr
 */
@Entity
@Table(name = "alerta", catalog = "plaza_segura", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alerta.findAll", query = "SELECT a FROM Alerta a")
    , @NamedQuery(name = "Alerta.findByAlertaId", query = "SELECT a FROM Alerta a WHERE a.alertaId = :alertaId")
    , @NamedQuery(name = "Alerta.findByAlertaFechaHora", query = "SELECT a FROM Alerta a WHERE a.alertaFechaHora = :alertaFechaHora")})
public class Alerta implements Serializable {

    @Size(max = 100)
    @Column(name = "alerta_descripcion")
    private String alertaDescripcion;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "alerta_id")
    private Integer alertaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "alerta_fecha_hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date alertaFechaHora;
    @JoinColumn(name = "alerta_id_camara", referencedColumnName = "camara_id")
    @ManyToOne(optional = false)
    private Camara alertaIdCamara;
    @JoinColumn(name = "alerta_id_tipo", referencedColumnName = "tipo_alerta_id")
    @ManyToOne(optional = false)
    private TipoAlerta alertaIdTipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alertaPersonaInteresIdAlerta")
    private List<AlertaPersonaInteres> alertaPersonaInteresList;

    public Alerta() {
    }

    public Alerta(Integer alertaId) {
        this.alertaId = alertaId;
    }

    public Alerta(Integer alertaId, Date alertaFechaHora) {
        this.alertaId = alertaId;
        this.alertaFechaHora = alertaFechaHora;
    }

    public Integer getAlertaId() {
        return alertaId;
    }

    public void setAlertaId(Integer alertaId) {
        this.alertaId = alertaId;
    }

    public Date getAlertaFechaHora() {
        return alertaFechaHora;
    }

    public void setAlertaFechaHora(Date alertaFechaHora) {
        this.alertaFechaHora = alertaFechaHora;
    }

    public Camara getAlertaIdCamara() {
        return alertaIdCamara;
    }

    public void setAlertaIdCamara(Camara alertaIdCamara) {
        this.alertaIdCamara = alertaIdCamara;
    }

    public TipoAlerta getAlertaIdTipo() {
        return alertaIdTipo;
    }

    public void setAlertaIdTipo(TipoAlerta alertaIdTipo) {
        this.alertaIdTipo = alertaIdTipo;
    }

    @XmlTransient
    public List<AlertaPersonaInteres> getAlertaPersonaInteresList() {
        return alertaPersonaInteresList;
    }

    public void setAlertaPersonaInteresList(List<AlertaPersonaInteres> alertaPersonaInteresList) {
        this.alertaPersonaInteresList = alertaPersonaInteresList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (alertaId != null ? alertaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alerta)) {
            return false;
        }
        Alerta other = (Alerta) object;
        if ((this.alertaId == null && other.alertaId != null) || (this.alertaId != null && !this.alertaId.equals(other.alertaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.plaza_segura_webapp.entities.Alerta[ alertaId=" + alertaId + " ]";
    }

    public String getAlertaDescripcion() {
        return alertaDescripcion;
    }

    public void setAlertaDescripcion(String alertaDescripcion) {
        this.alertaDescripcion = alertaDescripcion;
    }
    
}
