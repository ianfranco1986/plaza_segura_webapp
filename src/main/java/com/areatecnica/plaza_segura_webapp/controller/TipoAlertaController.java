package com.areatecnica.plaza_segura_webapp.controller;

import com.areatecnica.plaza_segura_webapp.entities.TipoAlerta;
import com.areatecnica.plaza_segura_webapp.entities.Alerta;
import java.util.List;
import com.areatecnica.plaza_segura_webapp.facade.TipoAlertaFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "tipoAlertaController")
@ViewScoped
public class TipoAlertaController extends AbstractController<TipoAlerta> {

    // Flags to indicate if child collections are empty
    private boolean isAlertaListEmpty;

    public TipoAlertaController() {
        // Inform the Abstract parent controller of the concrete TipoAlerta Entity
        super(TipoAlerta.class);
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
        TipoAlerta selected = this.getSelected();
        if (selected != null) {
            TipoAlertaFacade ejbFacade = (TipoAlertaFacade) this.getFacade();
            this.isAlertaListEmpty = ejbFacade.isAlertaListEmpty(selected);
        } else {
            this.isAlertaListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Alerta entities that are
     * retrieved from TipoAlerta and returns the navigation outcome.
     *
     * @return navigation outcome for Alerta page
     */
    public String navigateAlertaList() {
        TipoAlerta selected = this.getSelected();
        if (selected != null) {
            TipoAlertaFacade ejbFacade = (TipoAlertaFacade) this.getFacade();
            List<Alerta> selectedAlertaList = ejbFacade.findAlertaList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Alerta_items", selectedAlertaList);
        }
        return "/app/alerta/index";
    }

}
