package com.areatecnica.plaza_segura_webapp.converter;

import com.areatecnica.plaza_segura_webapp.entities.TipoUsuario;
import com.areatecnica.plaza_segura_webapp.facade.TipoUsuarioFacade;
import com.areatecnica.plaza_segura_webapp.controller.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.convert.FacesConverter;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@FacesConverter(value = "tipoUsuarioConverter")
public class TipoUsuarioConverter implements Converter {

    private TipoUsuarioFacade ejbFacade;

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
        if (object instanceof TipoUsuario) {
            TipoUsuario o = (TipoUsuario) object;
            return getStringKey(o.getTipoUsuarioId());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), TipoUsuario.class.getName()});
            return null;
        }
    }

    private TipoUsuarioFacade getEjbFacade() {
        this.ejbFacade = CDI.current().select(TipoUsuarioFacade.class).get();
        return this.ejbFacade;
    }
}
