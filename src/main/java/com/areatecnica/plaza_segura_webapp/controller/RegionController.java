package com.areatecnica.plaza_segura_webapp.controller;

import com.areatecnica.plaza_segura_webapp.entities.Region;
import com.areatecnica.plaza_segura_webapp.entities.Ciudad;
import java.util.List;
import com.areatecnica.plaza_segura_webapp.facade.RegionFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "regionController")
@ViewScoped
public class RegionController extends AbstractController<Region> {

    // Flags to indicate if child collections are empty
    private boolean isCiudadListEmpty;

    public RegionController() {
        // Inform the Abstract parent controller of the concrete Region Entity
        super(Region.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsCiudadListEmpty();
    }

    public boolean getIsCiudadListEmpty() {
        return this.isCiudadListEmpty;
    }

    private void setIsCiudadListEmpty() {
        Region selected = this.getSelected();
        if (selected != null) {
            RegionFacade ejbFacade = (RegionFacade) this.getFacade();
            this.isCiudadListEmpty = ejbFacade.isCiudadListEmpty(selected);
        } else {
            this.isCiudadListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Ciudad entities that are
     * retrieved from Region and returns the navigation outcome.
     *
     * @return navigation outcome for Ciudad page
     */
    public String navigateCiudadList() {
        Region selected = this.getSelected();
        if (selected != null) {
            RegionFacade ejbFacade = (RegionFacade) this.getFacade();
            List<Ciudad> selectedCiudadList = ejbFacade.findCiudadList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Ciudad_items", selectedCiudadList);
        }
        return "/app/ciudad/index";
    }

}
