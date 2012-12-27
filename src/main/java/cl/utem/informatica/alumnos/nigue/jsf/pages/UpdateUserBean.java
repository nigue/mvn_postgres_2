package cl.utem.informatica.alumnos.nigue.jsf.pages;

import cl.utem.informatica.alumnos.nigue.modelo.Usuario;
import cl.utem.informatica.alumnos.nigue.servicio.UsuarioService;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.apache.log4j.Logger;

public class UpdateUserBean {

    private static final Logger LOGGER = Logger.getLogger(UpdateUserBean.class);
    @Resource(name = "usuarioService")
    private transient UsuarioService usuarioService;
    private int rutBusqueda = 14646898;
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
                    "ususario encontrado",
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
        String hash = new String("");
        try {
            MessageDigest md = MessageDigest.getInstance("sha1");
            byte[] textBytes = getUsuarioToUpdate().getPassword().getBytes("8859_1");
            for (byte b : md.digest()) {
                hash += Integer.toHexString(b & 0xff);
            }
            LOGGER.debug(hash);
            getUsuarioToUpdate().setPassword(hash);
        } catch (UnsupportedEncodingException ex) {
            LOGGER.debug(ex);
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,
                    "no es posible guardar",
                    "ERROR"));
        } catch (NoSuchAlgorithmException nsae) {
            LOGGER.debug(nsae);
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,
                    "no es posible guardar",
                    "ERROR"));
        }
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