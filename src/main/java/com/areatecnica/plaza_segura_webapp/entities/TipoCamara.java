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
@Table(name = "tipo_camara", catalog = "plaza_segura", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoCamara.findAll", query = "SELECT t FROM TipoCamara t")
    , @NamedQuery(name = "TipoCamara.findByTipoCamaraId", query = "SELECT t FROM TipoCamara t WHERE t.tipoCamaraId = :tipoCamaraId")
    , @NamedQuery(name = "TipoCamara.findByTipoCamaraMarca", query = "SELECT t FROM TipoCamara t WHERE t.tipoCamaraMarca = :tipoCamaraMarca")
    , @NamedQuery(name = "TipoCamara.findByTipoCamaraResolucion", query = "SELECT t FROM TipoCamara t WHERE t.tipoCamaraResolucion = :tipoCamaraResolucion")})
public class TipoCamara implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tipo_camara_id")
    private Integer tipoCamaraId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipo_camara_marca")
    private String tipoCamaraMarca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipo_camara_resolucion")
    private String tipoCamaraResolucion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "camaraIdTipo")
    private List<Camara> camaraList;

    public TipoCamara() {
    }

    public TipoCamara(Integer tipoCamaraId) {
        this.tipoCamaraId = tipoCamaraId;
    }

    public TipoCamara(Integer tipoCamaraId, String tipoCamaraMarca, String tipoCamaraResolucion) {
        this.tipoCamaraId = tipoCamaraId;
        this.tipoCamaraMarca = tipoCamaraMarca;
        this.tipoCamaraResolucion = tipoCamaraResolucion;
    }

    public Integer getTipoCamaraId() {
        return tipoCamaraId;
    }

    public void setTipoCamaraId(Integer tipoCamaraId) {
        this.tipoCamaraId = tipoCamaraId;
    }

    public String getTipoCamaraMarca() {
        return tipoCamaraMarca;
    }

    public void setTipoCamaraMarca(String tipoCamaraMarca) {
        this.tipoCamaraMarca = tipoCamaraMarca;
    }

    public String getTipoCamaraResolucion() {
        return tipoCamaraResolucion;
    }

    public void setTipoCamaraResolucion(String tipoCamaraResolucion) {
        this.tipoCamaraResolucion = tipoCamaraResolucion;
    }

    @XmlTransient
    public List<Camara> getCamaraList() {
        return camaraList;
    }

    public void setCamaraList(List<Camara> camaraList) {
        this.camaraList = camaraList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoCamaraId != null ? tipoCamaraId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCamara)) {
            return false;
        }
        TipoCamara other = (TipoCamara) object;
        if ((this.tipoCamaraId == null && other.tipoCamaraId != null) || (this.tipoCamaraId != null && !this.tipoCamaraId.equals(other.tipoCamaraId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.plaza_segura_webapp.entities.TipoCamara[ tipoCamaraId=" + tipoCamaraId + " ]";
    }
    
}
