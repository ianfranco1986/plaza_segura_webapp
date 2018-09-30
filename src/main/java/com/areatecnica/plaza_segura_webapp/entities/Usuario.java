/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.plaza_segura_webapp.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ianfr
 */
@Entity
@Table(name = "usuario", catalog = "plaza_segura", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByUsuarioId", query = "SELECT u FROM Usuario u WHERE u.usuarioId = :usuarioId")
    , @NamedQuery(name = "Usuario.findByUsuarioNombre", query = "SELECT u FROM Usuario u WHERE u.usuarioNombre = :usuarioNombre")
    , @NamedQuery(name = "Usuario.findByUsuarioApellido", query = "SELECT u FROM Usuario u WHERE u.usuarioApellido = :usuarioApellido")
    , @NamedQuery(name = "Usuario.findByUsuarioRut", query = "SELECT u FROM Usuario u WHERE u.usuarioRut = :usuarioRut")
    , @NamedQuery(name = "Usuario.findByUsuarioCorreo", query = "SELECT u FROM Usuario u WHERE u.usuarioCorreo = :usuarioCorreo")
    , @NamedQuery(name = "Usuario.findByUsuarioCorreoPassword", query = "SELECT u FROM Usuario u WHERE u.usuarioCorreo = :usuarioCorreo AND u.usuarioPassword = :usuarioPassword")
    , @NamedQuery(name = "Usuario.findByUsuarioPassword", query = "SELECT u FROM Usuario u WHERE u.usuarioPassword = :usuarioPassword")
    , @NamedQuery(name = "Usuario.findByUsuarioFechaRegistro", query = "SELECT u FROM Usuario u WHERE u.usuarioFechaRegistro = :usuarioFechaRegistro")
    , @NamedQuery(name = "Usuario.findByUsuarioActivo", query = "SELECT u FROM Usuario u WHERE u.usuarioActivo = :usuarioActivo")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usuario_id")
    private Integer usuarioId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "usuario_nombre")
    private String usuarioNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "usuario_apellido")
    private String usuarioApellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "usuario_rut")
    private String usuarioRut;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "usuario_correo")
    private String usuarioCorreo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "usuario_password")
    private String usuarioPassword;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuarioFechaRegistro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_activo")
    private boolean usuarioActivo;
    @JoinColumn(name = "usuario_id_rol", referencedColumnName = "rol_id")
    @ManyToOne(optional = false)
    private Rol usuarioIdRol;
    @JoinColumn(name = "usuario_id_tipo", referencedColumnName = "tipo_usuario_id")
    @ManyToOne(optional = false)
    private TipoUsuario usuarioIdTipo;

    public Usuario() {
    }

    public Usuario(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Usuario(Integer usuarioId, String usuarioNombre, String usuarioApellido, String usuarioRut, String usuarioCorreo, String usuarioPassword, Date usuarioFechaRegistro, boolean usuarioActivo) {
        this.usuarioId = usuarioId;
        this.usuarioNombre = usuarioNombre;
        this.usuarioApellido = usuarioApellido;
        this.usuarioRut = usuarioRut;
        this.usuarioCorreo = usuarioCorreo;
        this.usuarioPassword = usuarioPassword;
        this.usuarioFechaRegistro = usuarioFechaRegistro;
        this.usuarioActivo = usuarioActivo;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getUsuarioNombre() {
        return usuarioNombre;
    }

    public void setUsuarioNombre(String usuarioNombre) {
        this.usuarioNombre = usuarioNombre;
    }

    public String getUsuarioApellido() {
        return usuarioApellido;
    }

    public void setUsuarioApellido(String usuarioApellido) {
        this.usuarioApellido = usuarioApellido;
    }

    public String getUsuarioRut() {
        return usuarioRut;
    }

    public void setUsuarioRut(String usuarioRut) {
        this.usuarioRut = usuarioRut;
    }

    public String getUsuarioCorreo() {
        return usuarioCorreo;
    }

    public void setUsuarioCorreo(String usuarioCorreo) {
        this.usuarioCorreo = usuarioCorreo;
    }

    public String getUsuarioPassword() {
        return usuarioPassword;
    }

    public void setUsuarioPassword(String usuarioPassword) {
        this.usuarioPassword = usuarioPassword;
    }

    public Date getUsuarioFechaRegistro() {
        return usuarioFechaRegistro;
    }

    public void setUsuarioFechaRegistro(Date usuarioFechaRegistro) {
        this.usuarioFechaRegistro = usuarioFechaRegistro;
    }

    public boolean getUsuarioActivo() {
        return usuarioActivo;
    }

    public void setUsuarioActivo(boolean usuarioActivo) {
        this.usuarioActivo = usuarioActivo;
    }

    public Rol getUsuarioIdRol() {
        return usuarioIdRol;
    }

    public void setUsuarioIdRol(Rol usuarioIdRol) {
        this.usuarioIdRol = usuarioIdRol;
    }

    public TipoUsuario getUsuarioIdTipo() {
        return usuarioIdTipo;
    }

    public void setUsuarioIdTipo(TipoUsuario usuarioIdTipo) {
        this.usuarioIdTipo = usuarioIdTipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioId != null ? usuarioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usuarioId == null && other.usuarioId != null) || (this.usuarioId != null && !this.usuarioId.equals(other.usuarioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.plaza_segura_webapp.entities.Usuario[ usuarioId=" + usuarioId + " ]";
    }
    
}
