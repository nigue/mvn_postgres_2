package cl.utem.informatica.alumnos.nigue.jsf.utils.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.validator.ValidatorException;
import org.apache.log4j.Logger;

@FacesConverter("rut")
public class RutConverter implements Converter {

    private static final Logger LOGGER = Logger.getLogger(RutConverter.class);

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        LOGGER.debug("########### Entrando a convertidor ##########");
        throw new ValidatorException(new FacesMessage(
                    FacesMessage.SEVERITY_WARN,
                    value + " is already on DB",
                    "WARNING"));
//        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return value.toString();
    }
}
