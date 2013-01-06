package cl.utem.informatica.alumnos.nigue.jsf.pages.graphics;

import cl.utem.informatica.alumnos.nigue.modelo.graphics.sql.UsuarioVsAcceso;
import cl.utem.informatica.alumnos.nigue.servicio.UsuarioVsAccesoService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.LineChartSeries;

public class UsuarioVsAccesoBean {

    private static final Logger LOGGER = Logger.getLogger(UsuarioVsAccesoBean.class);
    @Resource(name = "usuarioVsAccesoService")
    private transient UsuarioVsAccesoService usuarioVsAccesoService;
    private CartesianChartModel linearModel;

    public CartesianChartModel getLinearModel() {
        return linearModel;
    }

    @PostConstruct
    private void createLinearModel() {
        linearModel = new CartesianChartModel();

        LineChartSeries usuarios = new LineChartSeries();
        usuarios.setLabel("Usuarios");
        
        List<UsuarioVsAcceso> UsuarioVsAccesoGraphicDao = usuarioVsAccesoService.getAllUsuarioVsAcceso();
        for (UsuarioVsAcceso usuarioVsAcceso : UsuarioVsAccesoGraphicDao) {
            usuarios.set(usuarioVsAcceso.getNombre(), usuarioVsAcceso.getAcceso());
        }

        linearModel.addSeries(usuarios);
    }
}
