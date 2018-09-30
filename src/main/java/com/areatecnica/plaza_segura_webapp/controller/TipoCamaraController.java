package com.areatecnica.plaza_segura_webapp.controller;

import com.areatecnica.plaza_segura_webapp.entities.TipoCamara;
import com.areatecnica.plaza_segura_webapp.entities.Camara;
import java.util.List;
import com.areatecnica.plaza_segura_webapp.facade.TipoCamaraFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "tipoCamaraController")
@ViewScoped
public class TipoCamaraController extends AbstractController<TipoCamara> {

    // Flags to indicate if child collections are empty
    private boolean isCamaraListEmpty;

    public TipoCamaraController() {
        // Inform the Abstract parent controller of the concrete TipoCamara Entity
        super(TipoCamara.class);
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
        TipoCamara selected = this.getSelected();
        if (selected != null) {
            TipoCamaraFacade ejbFacade = (TipoCamaraFacade) this.getFacade();
            this.isCamaraListEmpty = ejbFacade.isCamaraListEmpty(selected);
        } else {
            this.isCamaraListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Camara entities that are
     * retrieved from TipoCamara and returns the navigation outcome.
     *
     * @return navigation outcome for Camara page
     */
    public String navigateCamaraList() {
        TipoCamara selected = this.getSelected();
        if (selected != null) {
            TipoCamaraFacade ejbFacade = (TipoCamaraFacade) this.getFacade();
            List<Camara> selectedCamaraList = ejbFacade.findCamaraList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Camara_items", selectedCamaraList);
        }
        return "/app/camara/index";
    }

}
