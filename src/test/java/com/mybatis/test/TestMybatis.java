package com.mybatis.test;

import net.sourceforge.stripes.integration.spring.SpringBean;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.tarea.domain.Usuarios;
import org.mybatis.tarea.service.UsuariosService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:dataSourceTestContext.xml", "classpath:testContext.xml"})
public class TestMybatis {

    private static final Logger LOGGER = Logger.getLogger(TestMybatis.class);
    @SpringBean
    private transient UsuariosService usuariosService;

    @Test
    public void testLog() {

        LOGGER.debug("/////////////Inicio de TEST: TestMybatis");

        Usuarios usuarios;
        
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
