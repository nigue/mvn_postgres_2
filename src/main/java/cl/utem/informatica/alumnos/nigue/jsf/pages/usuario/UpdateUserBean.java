package cl.utem.informatica.alumnos.nigue.jsf.pages.usuario;

import cl.utem.informatica.alumnos.nigue.modelo.Usuario;
import cl.utem.informatica.alumnos.nigue.servicio.UsuarioService;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;

public class UpdateUserBean {

    private static final Logger LOGGER = Logger.getLogger(UpdateUserBean.class);
    @Resource(name = "usuarioService")
    private transient UsuarioService usuarioService;
    private int rutBusqueda;
    private Usuario usuarioToUpdate;
    private boolean buttonUpdate = true;

    public String doSearch() {
        try {
            usuarioToUpdate = usuarioService.getUsuario(getRutBusqueda());
            getUsuarioToUpdate().setPassword("");
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(
                    FacesMessage.SEVERITY_INFO,
                    "usuario encontrado",
                    "INFO"));
            setButtonUpdate(false);
        } catch (NullPointerException npe) {
            LOGGER.debug(npe);
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(
                    FacesMessage.SEVERITY_WARN,
                    "el rut no se encuentra",
                    "WARNING"));
            setButtonUpdate(true);
        } catch (Exception e) {
            LOGGER.debug(e);
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,
                    "la busqueda genera un error",
                    "ERROR"));
            setButtonUpdate(true);
        }
        return null;
    }

    public String doUpdate() {
        String passSha1 = DigestUtils.sha1Hex(usuarioToUpdate.getPassword());
        usuarioToUpdate.setPassword(passSha1);
        try {
            usuarioService.updateUsuario(getUsuarioToUpdate());
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(
                    FacesMessage.SEVERITY_INFO,
                    "exitosamente updateado",
                    "INFO"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,
                    "no es posible updatear",
                    "ERROR"));
        }
        setButtonUpdate(true);
        return null;
    }

    public int getRutBusqueda() {
        return rutBusqueda;
    }

    public void setRutBusqueda(int rutBusqueda) {
        this.rutBusqueda = rutBusqueda;
    }

    public Usuario getUsuarioToUpdate() {
        return usuarioToUpdate;
    }

    public void setUsuarioToUpdate(Usuario usuarioToUpdate) {
        this.usuarioToUpdate = usuarioToUpdate;
    }

    public boolean isButtonUpdate() {
        return buttonUpdate;
    }

    public void setButtonUpdate(boolean buttonUpdate) {
        this.buttonUpdate = buttonUpdate;
    }
}
