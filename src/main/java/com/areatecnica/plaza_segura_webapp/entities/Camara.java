/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.plaza_segura_webapp.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
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
@Cacheable(false)
@Table(name = "camara", catalog = "plaza_segura", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Camara.findAll", query = "SELECT c FROM Camara c"),
    @NamedQuery(name = "Camara.findByCamaraId", query = "SELECT c FROM Camara c WHERE c.camaraId = :camaraId"),
    @NamedQuery(name = "Camara.findByCamaraIdComuna", query = "SELECT c FROM Camara c WHERE c.camaraIdComuna = :camaraIdComuna"),
    @NamedQuery(name = "Camara.findByCamaraNombre", query = "SELECT c FROM Camara c WHERE c.camaraNombre = :camaraNombre"),
    @NamedQuery(name = "Camara.findByCamaraDireccionCalle", query = "SELECT c FROM Camara c WHERE c.camaraDireccionCalle = :camaraDireccionCalle"),
    @NamedQuery(name = "Camara.findByCamaraDireccionNumero", query = "SELECT c FROM Camara c WHERE c.camaraDireccionNumero = :camaraDireccionNumero"),
    @NamedQuery(name = "Camara.findByCamaraPosicionLongitud", query = "SELECT c FROM Camara c WHERE c.camaraPosicionLongitud = :camaraPosicionLongitud"),
    @NamedQuery(name = "Camara.findByCamaraPosicionLatitud", query = "SELECT c FROM Camara c WHERE c.camaraPosicionLatitud = :camaraPosicionLatitud"),
    @NamedQuery(name = "Camara.findByCamaraUrl", query = "SELECT c FROM Camara c WHERE c.camaraUrl = :camaraUrl"),
    @NamedQuery(name = "Camara.findByCamaraAltura", query = "SELECT c FROM Camara c WHERE c.camaraAltura = :camaraAltura"),
    @NamedQuery(name = "Camara.findByCamaraAnguloVision", query = "SELECT c FROM Camara c WHERE c.camaraAnguloVision = :camaraAnguloVision")})
public class Camara implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "camara_id")
    private Integer camaraId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "camara_nombre")
    private String camaraNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "camara_direccion_calle")
    private String camaraDireccionCalle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "camara_direccion_numero")
    private String camaraDireccionNumero;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "camara_posicion_longitud")
    private BigDecimal camaraPosicionLongitud;
    @Basic(optional = false)
    @NotNull
    @Column(name = "camara_posicion_latitud")
    private BigDecimal camaraPosicionLatitud;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "camara_url")
    private String camaraUrl;
    @Column(name = "camara_altura")
    private Integer camaraAltura;
    @Column(name = "camara_angulo_vision")
    private Float camaraAnguloVision;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alertaIdCamara")
    private List<Alerta> alertaList;
    @JoinColumn(name = "camara_id_comuna", referencedColumnName = "comuna_id")
    @ManyToOne(optional = false)
    private Comuna camaraIdComuna;
    @JoinColumn(name = "camara_id_tipo", referencedColumnName = "tipo_camara_id")
    @ManyToOne(optional = false)
    private TipoCamara camaraIdTipo;

    public Camara() {
    }

    public Camara(Integer camaraId) {
        this.camaraId = camaraId;
    }

    public Camara(Integer camaraId, String camaraNombre, String camaraDireccionCalle, String camaraDireccionNumero, BigDecimal camaraPosicionLongitud, BigDecimal camaraPosicionLatitud, String camaraUrl) {
        this.camaraId = camaraId;
        this.camaraNombre = camaraNombre;
        this.camaraDireccionCalle = camaraDireccionCalle;
        this.camaraDireccionNumero = camaraDireccionNumero;
        this.camaraPosicionLongitud = camaraPosicionLongitud;
        this.camaraPosicionLatitud = camaraPosicionLatitud;
        this.camaraUrl = camaraUrl;
    }

    public Integer getCamaraId() {
        return camaraId;
    }

    public void setCamaraId(Integer camaraId) {
        this.camaraId = camaraId;
    }

    public String getCamaraNombre() {
        return camaraNombre;
    }

    public void setCamaraNombre(String camaraNombre) {
        this.camaraNombre = camaraNombre;
    }

    public String getCamaraDireccionCalle() {
        return camaraDireccionCalle;
    }

    public void setCamaraDireccionCalle(String camaraDireccionCalle) {
        this.camaraDireccionCalle = camaraDireccionCalle;
    }

    public String getCamaraDireccionNumero() {
        return camaraDireccionNumero;
    }

    public void setCamaraDireccionNumero(String camaraDireccionNumero) {
        this.camaraDireccionNumero = camaraDireccionNumero;
    }

    public BigDecimal getCamaraPosicionLongitud() {
        return camaraPosicionLongitud;
    }

    public void setCamaraPosicionLongitud(BigDecimal camaraPosicionLongitud) {
        this.camaraPosicionLongitud = camaraPosicionLongitud;
    }

    public BigDecimal getCamaraPosicionLatitud() {
        return camaraPosicionLatitud;
    }

    public void setCamaraPosicionLatitud(BigDecimal camaraPosicionLatitud) {
        this.camaraPosicionLatitud = camaraPosicionLatitud;
    }

    public String getCamaraUrl() {
        return camaraUrl;
    }

    public void setCamaraUrl(String camaraUrl) {
        this.camaraUrl = camaraUrl;
    }

    public Integer getCamaraAltura() {
        return camaraAltura;
    }

    public void setCamaraAltura(Integer camaraAltura) {
        this.camaraAltura = camaraAltura;
    }

    public Float getCamaraAnguloVision() {
        return camaraAnguloVision;
    }

    public void setCamaraAnguloVision(Float camaraAnguloVision) {
        this.camaraAnguloVision = camaraAnguloVision;
    }

    @XmlTransient
    public List<Alerta> getAlertaList() {
        return alertaList;
    }

    public void setAlertaList(List<Alerta> alertaList) {
        this.alertaList = alertaList;
    }

    public Comuna getCamaraIdComuna() {
        return camaraIdComuna;
    }

    public void setCamaraIdComuna(Comuna camaraIdComuna) {
        this.camaraIdComuna = camaraIdComuna;
    }

    public TipoCamara getCamaraIdTipo() {
        return camaraIdTipo;
    }

    public void setCamaraIdTipo(TipoCamara camaraIdTipo) {
        this.camaraIdTipo = camaraIdTipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (camaraId != null ? camaraId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Camara)) {
            return false;
        }
        Camara other = (Camara) object;
        if ((this.camaraId == null && other.camaraId != null) || (this.camaraId != null && !this.camaraId.equals(other.camaraId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.plaza_segura_webapp.entities.Camara[ camaraId=" + camaraId + " ]";
    }

}
