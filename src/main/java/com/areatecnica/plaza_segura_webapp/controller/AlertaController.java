package com.areatecnica.plaza_segura_webapp.controller;

import com.areatecnica.plaza_segura_webapp.entities.Alerta;
import com.areatecnica.plaza_segura_webapp.entities.AlertaPersonaInteres;
import java.util.List;
import com.areatecnica.plaza_segura_webapp.facade.AlertaFacade;
import java.util.Date;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

@Named(value = "alertaController")
@ViewScoped
public class AlertaController extends AbstractController<Alerta> {

    @Inject
    private CamaraController alertaIdCamaraController;
    @Inject
    private TipoAlertaController alertaIdTipoController;

    private MapModel mapModel;

    private Marker marker;
    private String nombre;
    private double lat;
    private double lng;

    // Flags to indicate if child collections are empty
    private boolean isAlertaPersonaInteresListEmpty;

    public AlertaController() {
        // Inform the Abstract parent controller of the concrete Alerta Entity
        super(Alerta.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        alertaIdCamaraController.setSelected(null);
        alertaIdTipoController.setSelected(null);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsAlertaPersonaInteresListEmpty();
    }

    /**
     * Sets the "selected" attribute of the Camara controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareAlertaIdCamara(ActionEvent event) {
        Alerta selected = this.getSelected();
        if (selected != null && alertaIdCamaraController.getSelected() == null) {
            alertaIdCamaraController.setSelected(selected.getAlertaIdCamara());
        }
    }

    /**
     * Sets the "selected" attribute of the TipoAlerta controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareAlertaIdTipo(ActionEvent event) {
        Alerta selected = this.getSelected();
        if (selected != null && alertaIdTipoController.getSelected() == null) {
            alertaIdTipoController.setSelected(selected.getAlertaIdTipo());
        }
    }

    public boolean getIsAlertaPersonaInteresListEmpty() {
        return this.isAlertaPersonaInteresListEmpty;
    }

    private void setIsAlertaPersonaInteresListEmpty() {
        Alerta selected = this.getSelected();
        if (selected != null) {
            AlertaFacade ejbFacade = (AlertaFacade) this.getFacade();
            this.isAlertaPersonaInteresListEmpty = ejbFacade.isAlertaPersonaInteresListEmpty(selected);
        } else {
            this.isAlertaPersonaInteresListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of AlertaPersonaInteres
     * entities that are retrieved from Alerta and returns the navigation
     * outcome.
     *
     * @return navigation outcome for AlertaPersonaInteres page
     */
    public String navigateAlertaPersonaInteresList() {
        Alerta selected = this.getSelected();
        if (selected != null) {
            AlertaFacade ejbFacade = (AlertaFacade) this.getFacade();
            List<AlertaPersonaInteres> selectedAlertaPersonaInteresList = ejbFacade.findAlertaPersonaInteresList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("AlertaPersonaInteres_items", selectedAlertaPersonaInteresList);
        }
        return "/app/alertaPersonaInteres/index";
    }

    @Override
    public Alerta prepareCreate(ActionEvent event) {
        super.prepareCreate(event); //To change body of generated methods, choose Tools | Templates.
        this.getSelected().setAlertaFechaHora(new Date());
        return this.getSelected();
    }

    public void load() {
        if (this.getSelected() != null) {
            this.lat = this.getSelected().getAlertaIdCamara().getCamaraPosicionLatitud().doubleValue();
            this.lng = this.getSelected().getAlertaIdCamara().getCamaraPosicionLongitud().doubleValue();

            this.marker = new Marker(new LatLng(lat, lng));
            this.mapModel = new DefaultMapModel();

            this.mapModel.addOverlay(marker);
        }
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

    public MapModel getMapModel() {
        return mapModel;
    }

    public void setMapModel(MapModel mapModel) {
        this.mapModel = mapModel;
    }

    public Marker getMarker() {
        return marker;
    }

    public void setMarker(Marker marker) {
        this.marker = marker;
    }

}
