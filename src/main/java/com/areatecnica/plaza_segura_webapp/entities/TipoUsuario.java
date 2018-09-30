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
@Table(name = "tipo_usuario", catalog = "plaza_segura", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoUsuario.findAll", query = "SELECT t FROM TipoUsuario t")
    , @NamedQuery(name = "TipoUsuario.findByTipoUsuarioId", query = "SELECT t FROM TipoUsuario t WHERE t.tipoUsuarioId = :tipoUsuarioId")
    , @NamedQuery(name = "TipoUsuario.findByTipoUsuarioNombre", query = "SELECT t FROM TipoUsuario t WHERE t.tipoUsuarioNombre = :tipoUsuarioNombre")})
public class TipoUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tipo_usuario_id")
    private Integer tipoUsuarioId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipo_usuario_nombre")
    private String tipoUsuarioNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioIdTipo")
    private List<Usuario> usuarioList;

    public TipoUsuario() {
    }

    public TipoUsuario(Integer tipoUsuarioId) {
        this.tipoUsuarioId = tipoUsuarioId;
    }

    public TipoUsuario(Integer tipoUsuarioId, String tipoUsuarioNombre) {
        this.tipoUsuarioId = tipoUsuarioId;
        this.tipoUsuarioNombre = tipoUsuarioNombre;
    }

    public Integer getTipoUsuarioId() {
        return tipoUsuarioId;
    }

    public void setTipoUsuarioId(Integer tipoUsuarioId) {
        this.tipoUsuarioId = tipoUsuarioId;
    }

    public String getTipoUsuarioNombre() {
        return tipoUsuarioNombre;
    }

    public void setTipoUsuarioNombre(String tipoUsuarioNombre) {
        this.tipoUsuarioNombre = tipoUsuarioNombre;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoUsuarioId != null ? tipoUsuarioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoUsuario)) {
            return false;
        }
        TipoUsuario other = (TipoUsuario) object;
        if ((this.tipoUsuarioId == null && other.tipoUsuarioId != null) || (this.tipoUsuarioId != null && !this.tipoUsuarioId.equals(other.tipoUsuarioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.plaza_segura_webapp.entities.TipoUsuario[ tipoUsuarioId=" + tipoUsuarioId + " ]";
    }
    
}
