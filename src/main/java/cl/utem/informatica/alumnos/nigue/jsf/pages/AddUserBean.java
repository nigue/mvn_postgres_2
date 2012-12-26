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

public class AddUserBean {

    private static final Logger LOGGER = Logger.getLogger(AddUserBean.class);
    @Resource(name = "usuarioService")
    private transient UsuarioService usuarioService;
    private int rut = 16978752;
    private String password = "asdf";

    public String doSubmit() {
        LOGGER.debug("######## DO SUBMIT ########");
        LOGGER.debug(getRut() + " and " + getPassword());
        String hash = new String("");
        try {
            MessageDigest md = MessageDigest.getInstance("sha1");
            byte[] textBytes = getPassword().getBytes("8859_1");
            for (byte b : md.digest()) {
                hash += Integer.toHexString(b & 0xff);
            }
            LOGGER.debug(hash);
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
        Usuario usuario = new Usuario();

        usuario.setRut(getRut());
        usuario.setPassword(hash);

        try {
            usuarioService.insertUsuario(usuario);
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(
                    FacesMessage.SEVERITY_INFO,
                    getRut() + "-" + digitoVerificadorRut(getRut()) + " exitosamente guardado",
                    "INFO"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,
                    getRut() + "-" + digitoVerificadorRut(getRut()) + " no es posible guardar",
                    "ERROR"));
        }
        return null;
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
