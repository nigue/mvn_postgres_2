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
        LOGGER.debug("########### Entrando a convertidor: rut a int ##########");
        int rut = 0;
        try {
            rut = new Integer(value.substring(0, value.indexOf("-")));
            if (!verificarRut(rut, digitoVerificadorRut(rut))) {
                return null;
            }
            return rut;
        } catch (Exception e) {
            LOGGER.debug(e);
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        int rut = (Integer) value;
        return rut + "-" + digitoVerificadorRut(rut);
    }

    public char digitoVerificadorRut(int rut) {
        LOGGER.debug("digitoVerificadorRut");
        int m = 0, s = 1;
        for (; rut != 0; rut /= 10) {
            s = (s + rut % 10 * (9 - m++ % 6)) % 11;
        }
        char dv = (char) (s != 0 ? s + 47 : 75);
        LOGGER.debug(" es: " + dv);
        return dv;
    }

    public boolean verificarRut(int rut, char dv) {
        int m = 0, s = 1;
        for (; rut != 0; rut /= 10) {
            s = (s + rut % 10 * (9 - m++ % 6)) % 11;
        }
        boolean result = (dv == (char) (s != 0 ? s + 47 : 75));
        return result;
    }
}
