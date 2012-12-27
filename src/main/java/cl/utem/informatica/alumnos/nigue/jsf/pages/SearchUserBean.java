package cl.utem.informatica.alumnos.nigue.jsf.pages;

import cl.utem.informatica.alumnos.nigue.modelo.Usuario;
import cl.utem.informatica.alumnos.nigue.servicio.UsuarioService;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.apache.log4j.Logger;

public class SearchUserBean {
    
    private static final Logger LOGGER = Logger.getLogger(SearchUserBean.class);
    @Resource(name = "usuarioService")
    private transient UsuarioService usuarioService;
    private int rut = 14646898;
    private Usuario usuarioSearch;
    private boolean dialog;
    
    public String doSubmit() {
        LOGGER.debug("no catch " + isDialog());
        setDialog(true);
        LOGGER.debug("######## do Submit - Search #########");
        LOGGER.debug(getRut());
        try {
            usuarioSearch = usuarioService.getUsuario(getRut());
            LOGGER.debug(getUsuarioSearch().getRut() + " -> " + getUsuarioSearch().getPassword());
            LOGGER.debug("no catch " + isDialog());
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(
                    FacesMessage.SEVERITY_INFO,
                    "ususario encontrado",
                    "INFO"));
            
            return null;
        } catch (NullPointerException npe) {
            setDialog(false);
            LOGGER.debug("ususario no encontrado: " + npe);
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(
                    FacesMessage.SEVERITY_WARN,
                    "ususario no encontrado",
                    "WARNING"));
            LOGGER.debug("npe " + isDialog());
            return null;
        } catch (Exception e) {
            setDialog(false);
            LOGGER.debug(e);
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,
                    "la busqueda genera un error",
                    "ERROR"));
            LOGGER.debug("e " + isDialog());
            return null;
        }
    }
    
    public int getRut() {
        return rut;
    }
    
    public void setRut(int rut) {
        this.rut = rut;
    }
    
    public Usuario getUsuarioSearch() {
        return usuarioSearch;
    }
    
    public void setUsuarioSearch(Usuario usuarioSearch) {
        this.usuarioSearch = usuarioSearch;
    }
    
    public boolean isDialog() {
        return dialog;
    }
    
    public void setDialog(boolean dialog) {
        this.dialog = dialog;
    }
}
