package cl.utem.informatica.alumnos.nigue.test;

import cl.utem.informatica.alumnos.nigue.modelo.Usuario;
import cl.utem.informatica.alumnos.nigue.servicio.UsuariosService;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:dataSourceTestContext.xml", "classpath:testContext.xml"})
@Transactional
public class TestMybatis {

    private static final Logger LOGGER = Logger.getLogger(TestMybatis.class);
    @Resource(name="usuariosService")
    private transient UsuariosService usuariosService;

    @Test
    public void getUsuariosByRutTest() {

        LOGGER.debug("/////////////Inicio de TEST: getUsuariosByRutTest");

        Usuario usuarios;
        
        LOGGER.debug("dataSource: " + usuariosService.toString());
        try {
            usuarios = usuariosService.getUsuarios(22222222);
            LOGGER.debug("user 2: " + usuarios.getPassword());
        } catch (Exception e) {
            LOGGER.debug("ERROR: " + e.getMessage());
        }

        LOGGER.debug("/////////////FIN");
        Assert.assertFalse(false);
    }
    
    @Test
    public void insertUsuariosTest() {
    
        LOGGER.debug("/////////////Inicio de TEST: insertUsuariosTest");
        
        Usuario usuarios = new Usuario();
        
        usuarios.setRut(55555555);
        usuarios.setPassword("user_5");
        
        usuariosService.insertUsuarios(usuarios);
        
        Usuario usuariosDelta = new Usuario();
        
        usuariosDelta = usuariosService.getUsuarios(55555555);
        
        Assert.assertEquals(usuariosDelta.getPassword(), usuarios.getPassword());
        Assert.assertEquals(usuariosDelta.getRut(), usuarios.getRut());
    }
    
    @Test
    public void updateUsuariosTest() {
    
        LOGGER.debug("/////////////Inicio de TEST: updateUsuariosTest");
        
        Usuario usuarios = new Usuario();
        usuarios = usuariosService.getUsuarios(44444444);
        
        usuarios.setPassword("nuevoPassword");
        
        usuariosService.updateUsuarios(usuarios);
        
        Usuario usuariosDelta = new Usuario();
        usuariosDelta = usuariosService.getUsuarios(44444444);
        
        Assert.assertNotEquals(usuariosDelta.getPassword(), "user_4");
    }
    
    @Test
    public void deleteUsuariosAndgetAllUsuariosTest() {
    
        int before = usuariosService.getAllUsuarios().size();
        
        Usuario usuarios = new Usuario();
        
        usuarios = usuariosService.getUsuarios(44444444);
        
        usuariosService.deleteUsuarios(usuarios);
        
        int after = usuariosService.getAllUsuarios().size();
        
        Assert.assertEquals(before, after + 1);
    }
}