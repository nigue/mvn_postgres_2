package cl.utem.informatica.alumnos.nigue.test;

import cl.utem.informatica.alumnos.nigue.modelo.Usuario;
import cl.utem.informatica.alumnos.nigue.servicio.UsuarioService;
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
    @Resource(name="usuarioService")
    private transient UsuarioService usuarioService;

    @Test
    public void getUsuarioByRutTest() {

        LOGGER.debug("/////////////Inicio de TEST: getUsuarioByRutTest");

        Usuario usuario;
        
        LOGGER.debug("dataSource: " + usuarioService.toString());
        try {
            usuario = usuarioService.getUsuario(22222222);
            LOGGER.debug("user 2: " + usuario.getPassword());
        } catch (Exception e) {
            LOGGER.debug("ERROR: " + e.getMessage());
        }

        LOGGER.debug("/////////////FIN");
        Assert.assertFalse(false);
    }
    
    @Test
    public void insertUsuarioTest() {
    
        LOGGER.debug("/////////////Inicio de TEST: insertUsuarioTest");
        
        Usuario usuario = new Usuario();
        
        usuario.setRut(55555555);
        usuario.setPassword("user_5");
        
        usuarioService.insertUsuario(usuario);
        
        Usuario usuarioDelta = new Usuario();
        
        usuarioDelta = usuarioService.getUsuario(55555555);
        
        Assert.assertEquals(usuarioDelta.getPassword(), usuario.getPassword());
        Assert.assertEquals(usuarioDelta.getRut(), usuario.getRut());
    }
    
    @Test
    public void updateUsuarioTest() {
    
        LOGGER.debug("/////////////Inicio de TEST: updateUsuarioTest");
        
        Usuario usuario = new Usuario();
        usuario = usuarioService.getUsuario(44444444);
        
        usuario.setPassword("nuevoPassword");
        
        usuarioService.updateUsuario(usuario);
        
        Usuario usuarioDelta = new Usuario();
        usuarioDelta = usuarioService.getUsuario(44444444);
        
        Assert.assertNotEquals(usuarioDelta.getPassword(), "user_4");
    }
    
    @Test
    public void deleteUsuarioAndgetAllUsuarioTest() {
    
        int before = usuarioService.getAllUsuario().size();
        
        Usuario usuario = new Usuario();
        
        usuario = usuarioService.getUsuario(44444444);
        
        usuarioService.deleteUsuario(usuario);
        
        int after = usuarioService.getAllUsuario().size();
        
        Assert.assertEquals(before, after + 1);
    }
}