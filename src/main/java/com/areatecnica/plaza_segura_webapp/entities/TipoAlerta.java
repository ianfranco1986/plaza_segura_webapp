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
@Table(name = "tipo_alerta", catalog = "plaza_segura", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoAlerta.findAll", query = "SELECT t FROM TipoAlerta t")
    , @NamedQuery(name = "TipoAlerta.findByTipoAlertaId", query = "SELECT t FROM TipoAlerta t WHERE t.tipoAlertaId = :tipoAlertaId")
    , @NamedQuery(name = "TipoAlerta.findByTipoAlertaNombre", query = "SELECT t FROM TipoAlerta t WHERE t.tipoAlertaNombre = :tipoAlertaNombre")})
public class TipoAlerta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tipo_alerta_id")
    private Integer tipoAlertaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipo_alerta_nombre")
    private String tipoAlertaNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alertaIdTipo")
    private List<Alerta> alertaList;

    public TipoAlerta() {
    }

    public TipoAlerta(Integer tipoAlertaId) {
        this.tipoAlertaId = tipoAlertaId;
    }

    public TipoAlerta(Integer tipoAlertaId, String tipoAlertaNombre) {
        this.tipoAlertaId = tipoAlertaId;
        this.tipoAlertaNombre = tipoAlertaNombre;
    }

    public Integer getTipoAlertaId() {
        return tipoAlertaId;
    }

    public void setTipoAlertaId(Integer tipoAlertaId) {
        this.tipoAlertaId = tipoAlertaId;
    }

    public String getTipoAlertaNombre() {
        return tipoAlertaNombre;
    }

    public void setTipoAlertaNombre(String tipoAlertaNombre) {
        this.tipoAlertaNombre = tipoAlertaNombre;
    }

    @XmlTransient
    public List<Alerta> getAlertaList() {
        return alertaList;
    }

    public void setAlertaList(List<Alerta> alertaList) {
        this.alertaList = alertaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoAlertaId != null ? tipoAlertaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoAlerta)) {
            return false;
        }
        TipoAlerta other = (TipoAlerta) object;
        if ((this.tipoAlertaId == null && other.tipoAlertaId != null) || (this.tipoAlertaId != null && !this.tipoAlertaId.equals(other.tipoAlertaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.plaza_segura_webapp.entities.TipoAlerta[ tipoAlertaId=" + tipoAlertaId + " ]";
    }
    
}
