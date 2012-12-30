package cl.utem.informatica.alumnos.nigue.jsf.utils.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.apache.log4j.Logger;

@FacesConverter("rut")
public class RutConverter implements Converter {

    private static final Logger LOGGER = Logger.getLogger(RutConverter.class);

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        LOGGER.debug("########### Entrando a convertidor: rut a int ##########");
        int rut = 0;
        try {
            LOGGER.debug("rut a cortar: " + value);
            String[] dataRut = value.split("-");
            String dataNum = dataRut[0];
            dataNum = dataNum.replaceAll("\\.", "");
            Integer number = new Integer(dataNum);
            char dv = dataRut[1].charAt(0);
            String dvData = "" + dv;
            dvData = dvData.toUpperCase();
            LOGGER.debug("rut completo: " + number + "-" + dvData);
            LOGGER.debug("dv completo: " + digitoVerificadorRut(number));
            LOGGER.debug("paso: " + dvData.equals(digitoVerificadorRut(number).toString()));
            if (dvData.equals(digitoVerificadorRut(number).toString())) {
                return number;
            } else {
                return null;
            }
        } catch (Exception e) {
            LOGGER.debug(e);
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Integer rut = (Integer) value;
        if (rut.equals(0) ) {
            return "";
        }
        String dataRut = rut.toString();
        try {
            String NewDataRut = dataRut.substring(0, dataRut.length() - 6)
                    + "." + dataRut.substring(dataRut.length() - 6, dataRut.length() - 3)
                    + "." + dataRut.substring(dataRut.length() - 3, dataRut.length());
//        LOGGER.debug("rut a cortar: " + rut);
//        LOGGER.debug("p1: " + dataRut.substring(0, dataRut.length() - 6));
//        LOGGER.debug("p2: " + dataRut.substring(dataRut.length() - 6, dataRut.length() - 3));
//        LOGGER.debug("p3: " + dataRut.substring(dataRut.length() - 3, dataRut.length()));
            return NewDataRut + "-" + digitoVerificadorRut(rut);
        } catch (Exception e) {
            LOGGER.debug(e);
            return rut + "-" + digitoVerificadorRut(rut);
        }
    }

    public String digitoVerificadorRut(int rut) {
        int m = 0, s = 1;
        for (; rut != 0; rut /= 10) {
            s = (s + rut % 10 * (9 - m++ % 6)) % 11;
        }
        char dv = (char) (s != 0 ? s + 47 : 75);
        String result = "" + dv;
        return result;
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
