package com.areatecnica.plaza_segura_webapp.controller;

import com.areatecnica.plaza_segura_webapp.entities.TipoUsuario;
import com.areatecnica.plaza_segura_webapp.entities.Usuario;
import java.util.List;
import com.areatecnica.plaza_segura_webapp.facade.TipoUsuarioFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "tipoUsuarioController")
@ViewScoped
public class TipoUsuarioController extends AbstractController<TipoUsuario> {

    // Flags to indicate if child collections are empty
    private boolean isUsuarioListEmpty;

    public TipoUsuarioController() {
        // Inform the Abstract parent controller of the concrete TipoUsuario Entity
        super(TipoUsuario.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsUsuarioListEmpty();
    }

    public boolean getIsUsuarioListEmpty() {
        return this.isUsuarioListEmpty;
    }

    private void setIsUsuarioListEmpty() {
        TipoUsuario selected = this.getSelected();
        if (selected != null) {
            TipoUsuarioFacade ejbFacade = (TipoUsuarioFacade) this.getFacade();
            this.isUsuarioListEmpty = ejbFacade.isUsuarioListEmpty(selected);
        } else {
            this.isUsuarioListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Usuario entities that are
     * retrieved from TipoUsuario and returns the navigation outcome.
     *
     * @return navigation outcome for Usuario page
     */
    public String navigateUsuarioList() {
        TipoUsuario selected = this.getSelected();
        if (selected != null) {
            TipoUsuarioFacade ejbFacade = (TipoUsuarioFacade) this.getFacade();
            List<Usuario> selectedUsuarioList = ejbFacade.findUsuarioList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Usuario_items", selectedUsuarioList);
        }
        return "/app/usuario/index";
    }

}
