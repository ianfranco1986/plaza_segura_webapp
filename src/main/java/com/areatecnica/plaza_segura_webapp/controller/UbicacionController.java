/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.plaza_segura_webapp.controller;

import com.areatecnica.plaza_segura_webapp.entities.Camara;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

/**
 *
 * @author ianfr
 */
@Named(value = "ubicacionController")
@SessionScoped
public class UbicacionController implements Serializable {

    @Inject
    private CamaraController controller;

    private List<Camara> items;
    private Marker marker;
    private MapModel mapModel;

    /**
     * Creates a new instance of UbicacionController
     */
    public UbicacionController() {
    }

    @PostConstruct
    public void init() {
        this.items = new ArrayList<>(this.controller.getItems());
        this.mapModel = new DefaultMapModel();

        for (Camara c : this.items) {
            this.marker = new Marker(new LatLng(c.getCamaraPosicionLatitud().doubleValue(), c.getCamaraPosicionLongitud().doubleValue()), c.getCamaraNombre());
            this.mapModel.addOverlay(marker);
        }
    }

    public MapModel getMapModel() {
        return mapModel;
    }

    public void setMapModel(MapModel mapModel) {
        this.mapModel = mapModel;
    }

    public void setMarker(Marker marker) {
        this.marker = marker;
    }

    public Marker getMarker() {
        return marker;
    }

    public List<Camara> getItems() {
        return items;
    }

    public void setItems(List<Camara> items) {
        this.items = items;
    }

    public void onMarkerSelect(OverlaySelectEvent event) {
        marker = (Marker) event.getOverlay();
    }

}
