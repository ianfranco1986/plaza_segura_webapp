/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.plaza_segura_webapp.controller;

import com.areatecnica.plaza_segura_webapp.controller.util.JsfUtil;
import com.areatecnica.plaza_segura_webapp.dao.impl.IComunaDaoImpl;
import com.areatecnica.plaza_segura_webapp.entities.Camara;
import com.areatecnica.plaza_segura_webapp.entities.Comuna;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.persistence.metamodel.SetAttribute;

/**
 *
 * @author ianfrancoconcha
 */
@Named(value = "onlineCamaraController")
@ViewScoped
public class OnlineCamaraController implements Serializable {

    private List<Camara> items;
    private List<Comuna> comunaItems;
    private Comuna comuna;
    private Camara camara;
    private final static String URL = "http://www.areatecnica.cl/images/";
    private String path = "1";

    /**
     * Creates a new instance of OnlineCamaraController
     */
    public OnlineCamaraController() {
    }

    @PostConstruct
    public void init() {
        this.comunaItems = new IComunaDaoImpl().findAll();
    }

    public List<Camara> getItems() {
        return items;
    }

    public void setItems(List<Camara> items) {
        this.items = items;
    }

    public Camara getCamara() {
        return camara;
    }

    public void setCamara(Camara camara) {
        this.camara = camara;
    }

    public Comuna getComuna() {
        return comuna;
    }

    public void setComuna(Comuna comuna) {
        this.comuna = comuna;
    }

    public List<Comuna> getComunaItems() {
        return comunaItems;
    }

    public void setComunaItems(List<Comuna> comunaItems) {
        this.comunaItems = comunaItems;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public static String getURL() {
        return URL;
    }

    public void handleComunaChange() {
        if (this.comuna != null) {
            this.items = this.comuna.getCamaraList();
        }
    }

    public void handleCameraChange() {
        if (this.camara != null) {
            this.path = URL + camara.getCamaraId() + ".jpg?dummy="+Math.random();
            System.err.println("PATH: " + this.path);
            JsfUtil.addSuccessMessage("Actualización");
        }
    }

}
