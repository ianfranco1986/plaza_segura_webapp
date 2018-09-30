package com.areatecnica.plaza_segura_webapp.controller;

import com.areatecnica.plaza_segura_webapp.entities.Nacionalidad;
import com.areatecnica.plaza_segura_webapp.entities.PersonaInteres;
import java.util.List;
import com.areatecnica.plaza_segura_webapp.facade.NacionalidadFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "nacionalidadController")
@ViewScoped
public class NacionalidadController extends AbstractController<Nacionalidad> {

    // Flags to indicate if child collections are empty
    private boolean isPersonaInteresListEmpty;

    public NacionalidadController() {
        // Inform the Abstract parent controller of the concrete Nacionalidad Entity
        super(Nacionalidad.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsPersonaInteresListEmpty();
    }

    public boolean getIsPersonaInteresListEmpty() {
        return this.isPersonaInteresListEmpty;
    }

    private void setIsPersonaInteresListEmpty() {
        Nacionalidad selected = this.getSelected();
        if (selected != null) {
            NacionalidadFacade ejbFacade = (NacionalidadFacade) this.getFacade();
            this.isPersonaInteresListEmpty = ejbFacade.isPersonaInteresListEmpty(selected);
        } else {
            this.isPersonaInteresListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of PersonaInteres entities
     * that are retrieved from Nacionalidad and returns the navigation outcome.
     *
     * @return navigation outcome for PersonaInteres page
     */
    public String navigatePersonaInteresList() {
        Nacionalidad selected = this.getSelected();
        if (selected != null) {
            NacionalidadFacade ejbFacade = (NacionalidadFacade) this.getFacade();
            List<PersonaInteres> selectedPersonaInteresList = ejbFacade.findPersonaInteresList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("PersonaInteres_items", selectedPersonaInteresList);
        }
        return "/app/personaInteres/index";
    }

}
