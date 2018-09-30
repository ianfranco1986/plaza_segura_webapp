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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ianfr
 */
@Entity
@Table(name = "privilegio", catalog = "plaza_segura", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Privilegio.findAll", query = "SELECT p FROM Privilegio p")
    , @NamedQuery(name = "Privilegio.findByPrivilegioId", query = "SELECT p FROM Privilegio p WHERE p.privilegioId = :privilegioId")
    , @NamedQuery(name = "Privilegio.findByPrivilegioNombre", query = "SELECT p FROM Privilegio p WHERE p.privilegioNombre = :privilegioNombre")
    , @NamedQuery(name = "Privilegio.findByPrivilegioDescripcion", query = "SELECT p FROM Privilegio p WHERE p.privilegioDescripcion = :privilegioDescripcion")
    , @NamedQuery(name = "Privilegio.findByPrivilegioMenuLink", query = "SELECT p FROM Privilegio p WHERE p.privilegioMenuLink = :privilegioMenuLink")
    , @NamedQuery(name = "Privilegio.findByPrivilegioTabla", query = "SELECT p FROM Privilegio p WHERE p.privilegioTabla = :privilegioTabla")
    , @NamedQuery(name = "Privilegio.findByPrivilegioIcon", query = "SELECT p FROM Privilegio p WHERE p.privilegioIcon = :privilegioIcon")
    , @NamedQuery(name = "Privilegio.findByPrivilegioNumeroOrden", query = "SELECT p FROM Privilegio p WHERE p.privilegioNumeroOrden = :privilegioNumeroOrden")
    , @NamedQuery(name = "Privilegio.findByPrivilegioColor", query = "SELECT p FROM Privilegio p WHERE p.privilegioColor = :privilegioColor")
    , @NamedQuery(name = "Privilegio.findByPrivilegioTipoMenu", query = "SELECT p FROM Privilegio p WHERE p.privilegioTipoMenu = :privilegioTipoMenu")})
public class Privilegio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "privilegio_id")
    private Integer privilegioId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "privilegio_nombre")
    private String privilegioNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "privilegio_descripcion")
    private String privilegioDescripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "privilegio_menu_link")
    private String privilegioMenuLink;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "privilegio_tabla")
    private String privilegioTabla;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "privilegio_icon")
    private String privilegioIcon;
    @Basic(optional = false)
    @NotNull
    @Column(name = "privilegio_numero_orden")
    private int privilegioNumeroOrden;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "privilegio_color")
    private String privilegioColor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "privilegio_tipo_menu")
    private int privilegioTipoMenu;
    @JoinColumn(name = "privilegio_id_menu", referencedColumnName = "menu_id")
    @ManyToOne(optional = false)
    private Menu privilegioIdMenu;

    public Privilegio() {
    }

    public Privilegio(Integer privilegioId) {
        this.privilegioId = privilegioId;
    }

    public Privilegio(Integer privilegioId, String privilegioNombre, String privilegioDescripcion, String privilegioMenuLink, String privilegioTabla, String privilegioIcon, int privilegioNumeroOrden, String privilegioColor, int privilegioTipoMenu) {
        this.privilegioId = privilegioId;
        this.privilegioNombre = privilegioNombre;
        this.privilegioDescripcion = privilegioDescripcion;
        this.privilegioMenuLink = privilegioMenuLink;
        this.privilegioTabla = privilegioTabla;
        this.privilegioIcon = privilegioIcon;
        this.privilegioNumeroOrden = privilegioNumeroOrden;
        this.privilegioColor = privilegioColor;
        this.privilegioTipoMenu = privilegioTipoMenu;
    }

    public Integer getPrivilegioId() {
        return privilegioId;
    }

    public void setPrivilegioId(Integer privilegioId) {
        this.privilegioId = privilegioId;
    }

    public String getPrivilegioNombre() {
        return privilegioNombre;
    }

    public void setPrivilegioNombre(String privilegioNombre) {
        this.privilegioNombre = privilegioNombre;
    }

    public String getPrivilegioDescripcion() {
        return privilegioDescripcion;
    }

    public void setPrivilegioDescripcion(String privilegioDescripcion) {
        this.privilegioDescripcion = privilegioDescripcion;
    }

    public String getPrivilegioMenuLink() {
        return privilegioMenuLink;
    }

    public void setPrivilegioMenuLink(String privilegioMenuLink) {
        this.privilegioMenuLink = privilegioMenuLink;
    }

    public String getPrivilegioTabla() {
        return privilegioTabla;
    }

    public void setPrivilegioTabla(String privilegioTabla) {
        this.privilegioTabla = privilegioTabla;
    }

    public String getPrivilegioIcon() {
        return privilegioIcon;
    }

    public void setPrivilegioIcon(String privilegioIcon) {
        this.privilegioIcon = privilegioIcon;
    }

    public int getPrivilegioNumeroOrden() {
        return privilegioNumeroOrden;
    }

    public void setPrivilegioNumeroOrden(int privilegioNumeroOrden) {
        this.privilegioNumeroOrden = privilegioNumeroOrden;
    }

    public String getPrivilegioColor() {
        return privilegioColor;
    }

    public void setPrivilegioColor(String privilegioColor) {
        this.privilegioColor = privilegioColor;
    }

    public int getPrivilegioTipoMenu() {
        return privilegioTipoMenu;
    }

    public void setPrivilegioTipoMenu(int privilegioTipoMenu) {
        this.privilegioTipoMenu = privilegioTipoMenu;
    }

    public Menu getPrivilegioIdMenu() {
        return privilegioIdMenu;
    }

    public void setPrivilegioIdMenu(Menu privilegioIdMenu) {
        this.privilegioIdMenu = privilegioIdMenu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (privilegioId != null ? privilegioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Privilegio)) {
            return false;
        }
        Privilegio other = (Privilegio) object;
        if ((this.privilegioId == null && other.privilegioId != null) || (this.privilegioId != null && !this.privilegioId.equals(other.privilegioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.plaza_segura_webapp.entities.Privilegio[ privilegioId=" + privilegioId + " ]";
    }
    
}
