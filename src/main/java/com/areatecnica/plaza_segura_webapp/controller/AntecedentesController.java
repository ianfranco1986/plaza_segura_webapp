package com.areatecnica.plaza_segura_webapp.controller;

import com.areatecnica.plaza_segura_webapp.entities.Antecedentes;
import com.areatecnica.plaza_segura_webapp.facade.AntecedentesFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "antecedentesController")
@ViewScoped
public class AntecedentesController extends AbstractController<Antecedentes> {

    @Inject
    private PersonaInteresController antecedentesIdPersonaController;

    public AntecedentesController() {
        // Inform the Abstract parent controller of the concrete Antecedentes Entity
        super(Antecedentes.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        antecedentesIdPersonaController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the PersonaInteres controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareAntecedentesIdPersona(ActionEvent event) {
        Antecedentes selected = this.getSelected();
        if (selected != null && antecedentesIdPersonaController.getSelected() == null) {
            antecedentesIdPersonaController.setSelected(selected.getAntecedentesIdPersona());
        }
    }

}
