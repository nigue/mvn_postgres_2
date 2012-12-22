package cl.utem.informatica.alumnos.nigue.jsf.pages;

import cl.utem.informatica.alumnos.nigue.modelo.Usuario;
import cl.utem.informatica.alumnos.nigue.servicio.UsuarioService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import org.apache.log4j.Logger;

public class SeeUserBean {

    private static final Logger LOGGER = Logger.getLogger(SeeUserBean.class);
    @Resource(name = "usuarioService")
    private transient UsuarioService usuarioService;
    private List<Usuario> usuarios = new ArrayList<Usuario>();

    @PostConstruct
    public void initPostDeclarative() {

        LOGGER.debug("######## LIST[Usuario] #######");
        List<Usuario> usuariosDao = usuarioService.getAllUsuario();
        for (Usuario usuario : usuariosDao) {
            this.getUsuarios().add(usuario);
        }
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
