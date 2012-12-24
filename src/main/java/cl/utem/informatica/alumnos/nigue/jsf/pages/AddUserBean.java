package cl.utem.informatica.alumnos.nigue.jsf.pages;

import cl.utem.informatica.alumnos.nigue.servicio.UsuarioService;
import javax.annotation.Resource;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import org.apache.log4j.Logger;

public class AddUserBean {

    private static final Logger LOGGER = Logger.getLogger(AddUserBean.class);
    @Resource(name = "usuarioService")
    private transient UsuarioService usuarioService;
    private int rut;
    private String password;
    
    public void rutValidator(
            FacesContext context,
            UIComponent component,
            Object value) throws ValidatorException {
        LOGGER.debug("######## VALIDATION ########");

        String newRut = (String) value;
//        List<Player> players = playerDAO.findByField("name", playerData);
//        if (!players.isEmpty()) {
//            LOGGER.debug(playerData + " is already on DB");
//            throw new ValidatorException(new FacesMessage(
//                    FacesMessage.SEVERITY_WARN,
//                    playerData + " is already on DB",
//                    "WARNING"));
//        }
    }
    
     public String doSubmit() {
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
