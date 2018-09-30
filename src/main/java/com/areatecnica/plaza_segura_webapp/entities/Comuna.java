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
@Table(name = "comuna", catalog = "plaza_segura", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comuna.findAll", query = "SELECT c FROM Comuna c")
    , @NamedQuery(name = "Comuna.findByComunaId", query = "SELECT c FROM Comuna c WHERE c.comunaId = :comunaId")
    , @NamedQuery(name = "Comuna.findByComunaNombre", query = "SELECT c FROM Comuna c WHERE c.comunaNombre = :comunaNombre")})
public class Comuna implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "comuna_id")
    private Integer comunaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "comuna_nombre")
    private String comunaNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "camaraIdComuna")
    private List<Camara> camaraList;
    @JoinColumn(name = "comuna_id_ciudad", referencedColumnName = "ciudad_id")
    @ManyToOne(optional = false)
    private Ciudad comunaIdCiudad;

    public Comuna() {
    }

    public Comuna(Integer comunaId) {
        this.comunaId = comunaId;
    }

    public Comuna(Integer comunaId, String comunaNombre) {
        this.comunaId = comunaId;
        this.comunaNombre = comunaNombre;
    }

    public Integer getComunaId() {
        return comunaId;
    }

    public void setComunaId(Integer comunaId) {
        this.comunaId = comunaId;
    }

    public String getComunaNombre() {
        return comunaNombre;
    }

    public void setComunaNombre(String comunaNombre) {
        this.comunaNombre = comunaNombre;
    }

    @XmlTransient
    public List<Camara> getCamaraList() {
        return camaraList;
    }

    public void setCamaraList(List<Camara> camaraList) {
        this.camaraList = camaraList;
    }

    public Ciudad getComunaIdCiudad() {
        return comunaIdCiudad;
    }

    public void setComunaIdCiudad(Ciudad comunaIdCiudad) {
        this.comunaIdCiudad = comunaIdCiudad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (comunaId != null ? comunaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comuna)) {
            return false;
        }
        Comuna other = (Comuna) object;
        if ((this.comunaId == null && other.comunaId != null) || (this.comunaId != null && !this.comunaId.equals(other.comunaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.plaza_segura_webapp.entities.Comuna[ comunaId=" + comunaId + " ]";
    }
    
}
