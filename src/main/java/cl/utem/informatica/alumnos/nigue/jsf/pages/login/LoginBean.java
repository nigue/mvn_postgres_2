package cl.utem.informatica.alumnos.nigue.jsf.pages.login;

import cl.utem.informatica.alumnos.nigue.modelo.Acceso;
import cl.utem.informatica.alumnos.nigue.modelo.Usuario;
import cl.utem.informatica.alumnos.nigue.servicio.AccesoService;
import cl.utem.informatica.alumnos.nigue.servicio.UsuarioService;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;

public class LoginBean {

    private static final Logger LOGGER = Logger.getLogger(LoginBean.class);
    @Resource(name = "usuarioService")
    private transient UsuarioService usuarioService;
    @Resource(name = "accesoService")
    private transient AccesoService accesoService;
    private int rut = 16978752;
    private String password;

    public String doSubmit() {
        String nav = null;
        try {
            String passSha1 = DigestUtils.sha1Hex(getPassword());
            Usuario usuario = usuarioService.getUsuarioByRutAndPassword(getRut(), passSha1);
            LOGGER.debug("#####" + usuario.getNombre());
            try {
                Acceso acceso = new Acceso();
                java.util.Date date = new java.util.Date();

                InetAddress ip;
                try {
                    ip = Inet4Address.getLocalHost();
                    String dip = ip.getHostAddress();
                    InetAddress inet = Inet4Address.getByName(dip.substring(0, 9));
                    acceso.setNombre(usuario.getNombre());
                    acceso.setFecha(new Timestamp(date.getTime()));
                    acceso.setIp(InetAddress.getLocalHost());
                    try {
                        accesoService.insertAcceso(acceso);
                        return "welcome";
                    } catch (Exception e) {
                        LOGGER.debug(e);
                        FacesContext.getCurrentInstance().addMessage(
                                null,
                                new FacesMessage(
                                FacesMessage.SEVERITY_ERROR,
                                "La transación fue un fracaso: " + ", " + passSha1.matches(usuario.getPassword())
                                + ", " + getRut() + ", " + getPassword()
                                + ", " + dip.substring(0, 9) + ", " + acceso.getFecha()
                                + ", " + acceso.getNombre(),
                                "ERROR"));
                    }

                } catch (UnknownHostException e) {
                    LOGGER.debug(e);
                    FacesContext.getCurrentInstance().addMessage(
                            null,
                            new FacesMessage(
                            FacesMessage.SEVERITY_ERROR,
                            "Error en la autentificación",
                            "ERROR"));
                }

            } catch (Exception e) {
                LOGGER.debug(e);
                FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(
                        FacesMessage.SEVERITY_ERROR,
                        "No se encontro al usuario" + getRut(),
                        "ERROR"));
            }
        } catch (NullPointerException npe) {
            LOGGER.debug("usuario no encontrado: " + npe);
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(
                    FacesMessage.SEVERITY_WARN,
                    "usuario no encontrado",
                    "WARNING"));
            return null;
        } catch (Exception e) {
            LOGGER.debug(e);
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,
                    "No se encontro al usuario" + getRut(),
                    "ERROR"));
        }
        return nav;
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
