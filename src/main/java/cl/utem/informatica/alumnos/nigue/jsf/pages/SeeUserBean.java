package cl.utem.informatica.alumnos.nigue.jsf.pages;

import cl.utem.informatica.alumnos.nigue.servicio.UsuarioService;
import javax.annotation.Resource;
import org.apache.log4j.Logger;

public class SeeUserBean {

    private static final Logger LOGGER = Logger.getLogger(SeeUserBean.class);
    
    @Resource(name = "usuariosService")
    private transient UsuarioService usuariosService;
    
    
}
