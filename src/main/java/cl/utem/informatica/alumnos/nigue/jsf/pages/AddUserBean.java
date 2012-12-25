package cl.utem.informatica.alumnos.nigue.jsf.pages;

import cl.utem.informatica.alumnos.nigue.servicio.UsuarioService;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import org.apache.log4j.Logger;

public class AddUserBean {
    
    private static final Logger LOGGER = Logger.getLogger(AddUserBean.class);
    @Resource(name = "usuarioService")
    private transient UsuarioService usuarioService;
    private int rut = 16978752;
    private String password = "asdf";
    
    public void rutValidator(
            FacesContext context,
            UIComponent component,
            Object value) throws ValidatorException {
        LOGGER.debug("######## VALIDATION ########");
                      
//                throw new ValidatorException(new FacesMessage(
//                        FacesMessage.SEVERITY_WARN,
//                        "error",
//                        "WARNING"));  
        try {
            String[] varRut = (String[]) value;
            boolean rutValido = verificarRut(new Integer(varRut[0]), varRut[1].charAt(0));
            if (!rutValido) {
                String msg = varRut[0] + "-" + varRut[1] + ": no es un rut válido";
                LOGGER.debug(msg);
                throw new ValidatorException(new FacesMessage(
                        FacesMessage.SEVERITY_WARN,
                        msg,
                        "WARNING"));
            }
        } catch (Exception e) {
            LOGGER.debug(e.getMessage());
        }
    }
    
    public boolean verificarRut(int rut, char dv) {
        LOGGER.debug("verirficar rut");
        int m = 0, s = 1;
        for (; rut != 0; rut /= 10) {
            s = (s + rut % 10 * (9 - m++ % 6)) % 11;
        }
        boolean result = ( dv == (char) (s != 0 ? s + 47 : 75));
        LOGGER.debug(result);
        return result;
    }
    
    public String doSubmit() {
        LOGGER.debug("######## DO SUBMIT ########");
        return "hola";
    }
    
    public int getRut() {
        return rut;
    }
    
    public void setRut(int rut) {
        this.rut = rut;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
}
