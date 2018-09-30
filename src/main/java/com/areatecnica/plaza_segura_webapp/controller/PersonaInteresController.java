package com.areatecnica.plaza_segura_webapp.controller;

import com.areatecnica.plaza_segura_webapp.entities.PersonaInteres;
import com.areatecnica.plaza_segura_webapp.entities.AlertaPersonaInteres;
import com.areatecnica.plaza_segura_webapp.entities.Antecedentes;
import java.util.List;
import com.areatecnica.plaza_segura_webapp.facade.PersonaInteresFacade;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import org.primefaces.event.FileUploadEvent;

@Named(value = "personaInteresController")
@ViewScoped
public class PersonaInteresController extends AbstractController<PersonaInteres> {

    @Inject
    private NacionalidadController personaInteresIdNacionalidadController;

    // Flags to indicate if child collections are empty
    private boolean isAlertaPersonaInteresListEmpty;
    private boolean isAntecedentesListEmpty;

    public PersonaInteresController() {
        // Inform the Abstract parent controller of the concrete PersonaInteres Entity
        super(PersonaInteres.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        personaInteresIdNacionalidadController.setSelected(null);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsAlertaPersonaInteresListEmpty();
        this.setIsAntecedentesListEmpty();
    }

    /**
     * Sets the "selected" attribute of the Nacionalidad controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void preparePersonaInteresIdNacionalidad(ActionEvent event) {
        PersonaInteres selected = this.getSelected();
        if (selected != null && personaInteresIdNacionalidadController.getSelected() == null) {
            personaInteresIdNacionalidadController.setSelected(selected.getPersonaInteresIdNacionalidad());
        }
    }

    public boolean getIsAlertaPersonaInteresListEmpty() {
        return this.isAlertaPersonaInteresListEmpty;
    }

    private void setIsAlertaPersonaInteresListEmpty() {
        PersonaInteres selected = this.getSelected();
        if (selected != null) {
            PersonaInteresFacade ejbFacade = (PersonaInteresFacade) this.getFacade();
            this.isAlertaPersonaInteresListEmpty = ejbFacade.isAlertaPersonaInteresListEmpty(selected);
        } else {
            this.isAlertaPersonaInteresListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of AlertaPersonaInteres
     * entities that are retrieved from PersonaInteres and returns the
     * navigation outcome.
     *
     * @return navigation outcome for AlertaPersonaInteres page
     */
    public String navigateAlertaPersonaInteresList() {
        PersonaInteres selected = this.getSelected();
        if (selected != null) {
            PersonaInteresFacade ejbFacade = (PersonaInteresFacade) this.getFacade();
            List<AlertaPersonaInteres> selectedAlertaPersonaInteresList = ejbFacade.findAlertaPersonaInteresList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("AlertaPersonaInteres_items", selectedAlertaPersonaInteresList);
        }
        return "/app/alertaPersonaInteres/index";
    }

    public boolean getIsAntecedentesListEmpty() {
        return this.isAntecedentesListEmpty;
    }

    private void setIsAntecedentesListEmpty() {
        PersonaInteres selected = this.getSelected();
        if (selected != null) {
            PersonaInteresFacade ejbFacade = (PersonaInteresFacade) this.getFacade();
            this.isAntecedentesListEmpty = ejbFacade.isAntecedentesListEmpty(selected);
        } else {
            this.isAntecedentesListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Antecedentes entities
     * that are retrieved from PersonaInteres and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Antecedentes page
     */
    public String navigateAntecedentesList() {
        PersonaInteres selected = this.getSelected();
        if (selected != null) {
            PersonaInteresFacade ejbFacade = (PersonaInteresFacade) this.getFacade();
            List<Antecedentes> selectedAntecedentesList = ejbFacade.findAntecedentesList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Antecedentes_items", selectedAntecedentesList);
        }
        return "/app/antecedentes/index";
    }

    @Override
    public PersonaInteres prepareCreate(ActionEvent event) {
        super.prepareCreate(event); //To change body of generated methods, choose Tools | Templates.
        this.getSelected().setPersonaInteresActivo(true);
        return this.getSelected();
    }

    public void handleFileUpload(FileUploadEvent event) {
        FacesMessage message = new FacesMessage("Subida la imagen: ", event.getFile().getFileName() + ".");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
