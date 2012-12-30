package cl.utem.informatica.alumnos.nigue.jsf.pages.usuario;

import cl.utem.informatica.alumnos.nigue.modelo.Usuario;
import cl.utem.informatica.alumnos.nigue.servicio.UsuarioService;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.apache.log4j.Logger;

public class DeleteUserBean {

    private static final Logger LOGGER = Logger.getLogger(DeleteUserBean.class);
    @Resource(name = "usuarioService")
    private transient UsuarioService usuarioService;
    private int rutBusqueda;
    private Usuario usuarioToDelete;
    private boolean buttonDelete = true;

    public String doSearch() {
        try {
            usuarioToDelete = usuarioService.getUsuario(getRutBusqueda());
            LOGGER.debug(usuarioToDelete.getRut());
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(
                    FacesMessage.SEVERITY_INFO,
                    "usuario encontrado",
                    "INFO"));
            setButtonDelete(false);
        } catch (NullPointerException npe) {
            LOGGER.debug(npe);
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(
                    FacesMessage.SEVERITY_WARN,
                    "el rut no se encuentra",
                    "WARNING"));
            setButtonDelete(true);
        } catch (Exception e) {
            LOGGER.debug(e);
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,
                    "la busqueda genera un error",
                    "ERROR"));
            setButtonDelete(true);
        }
        return null;
    }

    public String doDelete() {
        try {
            usuarioService.deleteUsuario(getUsuarioToDelete());
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(
                    FacesMessage.SEVERITY_INFO,
                    "exitosamente borrado",
                    "INFO"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,
                    "no es posible borrar",
                    "ERROR"));
        }
        setButtonDelete(true);
        return null;
    }

    public int getRutBusqueda() {
        return rutBusqueda;
    }

    public void setRutBusqueda(int rutBusqueda) {
        this.rutBusqueda = rutBusqueda;
    }

    public Usuario getUsuarioToDelete() {
        return usuarioToDelete;
    }

    public void setUsuarioToDelete(Usuario usuarioToDelete) {
        this.usuarioToDelete = usuarioToDelete;
    }

    public boolean isButtonDelete() {
        return buttonDelete;
    }

    public void setButtonDelete(boolean buttonDelete) {
        this.buttonDelete = buttonDelete;
    }
}
