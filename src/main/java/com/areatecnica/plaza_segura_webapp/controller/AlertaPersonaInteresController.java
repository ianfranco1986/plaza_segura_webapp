package com.areatecnica.plaza_segura_webapp.controller;

import com.areatecnica.plaza_segura_webapp.entities.AlertaPersonaInteres;
import com.areatecnica.plaza_segura_webapp.facade.AlertaPersonaInteresFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "alertaPersonaInteresController")
@ViewScoped
public class AlertaPersonaInteresController extends AbstractController<AlertaPersonaInteres> {

    @Inject
    private AlertaController alertaPersonaInteresIdAlertaController;
    @Inject
    private PersonaInteresController alertaPersonaInteresIdPersonaController;

    public AlertaPersonaInteresController() {
        // Inform the Abstract parent controller of the concrete AlertaPersonaInteres Entity
        super(AlertaPersonaInteres.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        alertaPersonaInteresIdAlertaController.setSelected(null);
        alertaPersonaInteresIdPersonaController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Alerta controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareAlertaPersonaInteresIdAlerta(ActionEvent event) {
        AlertaPersonaInteres selected = this.getSelected();
        if (selected != null && alertaPersonaInteresIdAlertaController.getSelected() == null) {
            alertaPersonaInteresIdAlertaController.setSelected(selected.getAlertaPersonaInteresIdAlerta());
        }
    }

    /**
     * Sets the "selected" attribute of the PersonaInteres controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareAlertaPersonaInteresIdPersona(ActionEvent event) {
        AlertaPersonaInteres selected = this.getSelected();
        if (selected != null && alertaPersonaInteresIdPersonaController.getSelected() == null) {
            alertaPersonaInteresIdPersonaController.setSelected(selected.getAlertaPersonaInteresIdPersona());
        }
    }

}
