package cl.utem.informatica.alumnos.nigue.jsf.pages;

import cl.utem.informatica.alumnos.nigue.servicio.UsuariosService;
import javax.annotation.Resource;
import org.apache.log4j.Logger;

public class SeeUserBean {

    private static final Logger LOGGER = Logger.getLogger(SeeUserBean.class);
    
    @Resource(name = "usuariosService")
    private transient UsuariosService usuariosService;
    
    
}
