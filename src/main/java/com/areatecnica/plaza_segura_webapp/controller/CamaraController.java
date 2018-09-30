package com.areatecnica.plaza_segura_webapp.controller;

import com.areatecnica.plaza_segura_webapp.entities.Camara;
import com.areatecnica.plaza_segura_webapp.entities.Alerta;
import java.util.List;
import com.areatecnica.plaza_segura_webapp.facade.CamaraFacade;
import java.math.BigDecimal;
import java.math.MathContext;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import org.primefaces.event.map.MarkerDragEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

@Named(value = "camaraController")
@ViewScoped
public class CamaraController extends AbstractController<Camara> {

    @Inject
    private ComunaController camaraIdComunaController;
    @Inject
    private TipoCamaraController camaraIdTipoController;

    private MapModel draggableModel;

    private Marker marker;
    private String nombre;
    private double lat;
    private double lng;

    // Flags to indicate if child collections are empty
    private boolean isAlertaListEmpty;

    public CamaraController() {
        // Inform the Abstract parent controller of the concrete Camara Entity
        super(Camara.class);
    }

    @PostConstruct
    public void init() {
        draggableModel = new DefaultMapModel();
    }

    public void loadMap() {
        System.err.println("LOADING MAP");
        if (this.getSelected() != null) {
            this.lat = this.getSelected().getCamaraPosicionLatitud().doubleValue();
            this.lng = this.getSelected().getCamaraPosicionLongitud().doubleValue();
            LatLng coord = new LatLng(lat, lng);

            this.draggableModel = new DefaultMapModel();
            this.draggableModel.addOverlay(new Marker(coord));
        }
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        camaraIdComunaController.setSelected(null);
        camaraIdTipoController.setSelected(null);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsAlertaListEmpty();
    }

    public boolean getIsAlertaListEmpty() {
        return this.isAlertaListEmpty;
    }

    private void setIsAlertaListEmpty() {
        Camara selected = this.getSelected();
        if (selected != null) {
            CamaraFacade ejbFacade = (CamaraFacade) this.getFacade();
            this.isAlertaListEmpty = ejbFacade.isAlertaListEmpty(selected);
        } else {
            this.isAlertaListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Alerta entities that are
     * retrieved from Camara and returns the navigation outcome.
     *
     * @return navigation outcome for Alerta page
     */
    public String navigateAlertaList() {
        Camara selected = this.getSelected();
        if (selected != null) {
            CamaraFacade ejbFacade = (CamaraFacade) this.getFacade();
            List<Alerta> selectedAlertaList = ejbFacade.findAlertaList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Alerta_items", selectedAlertaList);
        }
        return "/app/alerta/index";
    }

    /**
     * Sets the "selected" attribute of the Comuna controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCamaraIdComuna(ActionEvent event) {
        Camara selected = this.getSelected();
        if (selected != null && camaraIdComunaController.getSelected() == null) {
            camaraIdComunaController.setSelected(selected.getCamaraIdComuna());
        }
    }

    /**
     * Sets the "selected" attribute of the TipoCamara controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCamaraIdTipo(ActionEvent event) {
        Camara selected = this.getSelected();
        if (selected != null && camaraIdTipoController.getSelected() == null) {
            camaraIdTipoController.setSelected(selected.getCamaraIdTipo());
        }
    }

    public void addMarker() {
        Marker marker = new Marker(new LatLng(lat, lng));
        draggableModel.addOverlay(marker);

        this.getSelected().setCamaraNombre(nombre);
        this.getSelected().setCamaraPosicionLongitud(new BigDecimal(lng, MathContext.DECIMAL32));
        this.getSelected().setCamaraPosicionLatitud(new BigDecimal(lat, MathContext.DECIMAL32));

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Marcador agregado", ""));
    }

    public MapModel getDraggableModel() {
        return draggableModel;
    }

    public void onMarkerDrag(MarkerDragEvent event) {
        marker = event.getMarker();

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Lat:" + marker.getLatlng().getLat() + ", Lng:" + marker.getLatlng().getLng()));
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
