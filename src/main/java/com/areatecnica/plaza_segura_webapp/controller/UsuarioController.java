package com.areatecnica.plaza_segura_webapp.controller;

import com.areatecnica.plaza_segura_webapp.entities.Usuario;
import com.areatecnica.plaza_segura_webapp.facade.UsuarioFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "usuarioController")
@ViewScoped
public class UsuarioController extends AbstractController<Usuario> {

    @Inject
    private TipoUsuarioController usuarioIdTipoController;

    public UsuarioController() {
        // Inform the Abstract parent controller of the concrete Usuario Entity
        super(Usuario.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        usuarioIdTipoController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the TipoUsuario controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareUsuarioIdTipo(ActionEvent event) {
        Usuario selected = this.getSelected();
        if (selected != null && usuarioIdTipoController.getSelected() == null) {
            usuarioIdTipoController.setSelected(selected.getUsuarioIdTipo());
        }
    }

}
