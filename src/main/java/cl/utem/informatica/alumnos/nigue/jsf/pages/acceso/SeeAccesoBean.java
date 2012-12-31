package cl.utem.informatica.alumnos.nigue.jsf.pages.acceso;

import cl.utem.informatica.alumnos.nigue.modelo.Acceso;
import cl.utem.informatica.alumnos.nigue.servicio.AccesoService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import org.apache.log4j.Logger;

public class SeeAccesoBean {
    
    private static final Logger LOGGER = Logger.getLogger(SeeAccesoBean.class);
    @Resource(name = "accesoService")
    private transient AccesoService accesoService;
    private List<Acceso> accesos = new ArrayList<Acceso>();
    
    @PostConstruct
    public void initPostDeclarative() {
        
        LOGGER.debug("######## LIST[Acceso] #######");
        List<Acceso> accesosDao = accesoService.getAllAcceso();
        for (Acceso acceso : accesosDao) {
            this.getAccesos().add(acceso);
        }
    }
    
    public List<Acceso> getAccesos() {
        return accesos;
    }
    
    public void setAccesos(List<Acceso> accesos) {
        this.accesos = accesos;
    }
}
