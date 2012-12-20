package cl.utem.informatica.alumnos.nigue.test;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import cl.utem.informatica.alumnos.nigue.modelo.Usuario;
import cl.utem.informatica.alumnos.nigue.servicio.UsuariosService;
import javax.annotation.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:dataSourceTestContext.xml", "classpath:testContext.xml"})
public class TestMybatis {

    private static final Logger LOGGER = Logger.getLogger(TestMybatis.class);
    @Resource(name="usuariosService")
    private transient UsuariosService usuariosService;

    @Test
    public void testLog() {

        LOGGER.debug("/////////////Inicio de TEST: TestMybatis");

        Usuario usuarios;
        
//        LOGGER.debug("dataSource: " + usuariosService.toString());
        try {
            usuarios = usuariosService.getUsuarios(22222222);
//            LOGGER.debug("user 1:" + usuarios.getPassword());
        } catch (Exception e) {
            LOGGER.debug("ERROR: " + e.getMessage());
        }

        LOGGER.debug("/////////////FIN");
        Assert.assertFalse(false);
    }
}
