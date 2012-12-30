package cl.utem.informatica.alumnos.nigue.jsf.pages.usuario;

import cl.utem.informatica.alumnos.nigue.modelo.Usuario;
import cl.utem.informatica.alumnos.nigue.servicio.UsuarioService;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;

public class AddUserBean {

    private static final Logger LOGGER = Logger.getLogger(AddUserBean.class);
    @Resource(name = "usuarioService")
    private transient UsuarioService usuarioService;
    private int rut;
    private String nombre;
    private String password;

    public String doSubmit() {
        LOGGER.debug("######## DO SUBMIT ########");
        LOGGER.debug(getRut() + " and " + getPassword());
        String passSha1 = DigestUtils.sha1Hex(getPassword());
        Usuario usuario = new Usuario();

        usuario.setRut(getRut());
        usuario.setNombre(getNombre());
        usuario.setPassword(passSha1);

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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
