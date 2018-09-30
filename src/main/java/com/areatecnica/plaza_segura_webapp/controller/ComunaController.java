package com.areatecnica.plaza_segura_webapp.controller;

import com.areatecnica.plaza_segura_webapp.entities.Comuna;
import com.areatecnica.plaza_segura_webapp.entities.Camara;
import java.util.List;
import com.areatecnica.plaza_segura_webapp.facade.ComunaFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "comunaController")
@ViewScoped
public class ComunaController extends AbstractController<Comuna> {

    @Inject
    private CiudadController comunaIdCiudadController;

    // Flags to indicate if child collections are empty
    private boolean isCamaraListEmpty;

    public ComunaController() {
        // Inform the Abstract parent controller of the concrete Comuna Entity
        super(Comuna.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        comunaIdCiudadController.setSelected(null);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsCamaraListEmpty();
    }

    public boolean getIsCamaraListEmpty() {
        return this.isCamaraListEmpty;
    }

    private void setIsCamaraListEmpty() {
        Comuna selected = this.getSelected();
        if (selected != null) {
            ComunaFacade ejbFacade = (ComunaFacade) this.getFacade();
            this.isCamaraListEmpty = ejbFacade.isCamaraListEmpty(selected);
        } else {
            this.isCamaraListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Camara entities that are
     * retrieved from Comuna and returns the navigation outcome.
     *
     * @return navigation outcome for Camara page
     */
    public String navigateCamaraList() {
        Comuna selected = this.getSelected();
        if (selected != null) {
            ComunaFacade ejbFacade = (ComunaFacade) this.getFacade();
            List<Camara> selectedCamaraList = ejbFacade.findCamaraList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Camara_items", selectedCamaraList);
        }
        return "/app/camara/index";
    }

    /**
     * Sets the "selected" attribute of the Ciudad controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareComunaIdCiudad(ActionEvent event) {
        Comuna selected = this.getSelected();
        if (selected != null && comunaIdCiudadController.getSelected() == null) {
            comunaIdCiudadController.setSelected(selected.getComunaIdCiudad());
        }
    }

}
