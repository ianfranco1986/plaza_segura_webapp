package com.areatecnica.plaza_segura_webapp.converter;

import com.areatecnica.plaza_segura_webapp.entities.PersonaInteres;
import com.areatecnica.plaza_segura_webapp.facade.PersonaInteresFacade;
import com.areatecnica.plaza_segura_webapp.controller.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.convert.FacesConverter;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@FacesConverter(value = "personaInteresConverter")
public class PersonaInteresConverter implements Converter {

    private PersonaInteresFacade ejbFacade;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.getEjbFacade().find(getKey(value));
    }

    java.lang.Integer getKey(String value) {
        java.lang.Integer key;
        key = Integer.valueOf(value);
        return key;
    }

    String getStringKey(java.lang.Integer value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value);
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null
                || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof PersonaInteres) {
            PersonaInteres o = (PersonaInteres) object;
            return getStringKey(o.getPersonaInteresId());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), PersonaInteres.class.getName()});
            return null;
        }
    }

    private PersonaInteresFacade getEjbFacade() {
        this.ejbFacade = CDI.current().select(PersonaInteresFacade.class).get();
        return this.ejbFacade;
    }
}
