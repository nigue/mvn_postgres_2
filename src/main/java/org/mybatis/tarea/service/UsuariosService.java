package org.mybatis.tarea.service;

import java.util.List;
import org.apache.log4j.Logger;
import org.mybatis.tarea.domain.Usuarios;
import org.mybatis.tarea.persistence.UsuariosMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuariosService {

    private static final Logger LOGGER = Logger.getLogger(UsuariosService.class);
    
    @Autowired
    private UsuariosMapper usuariosMapper;

    public Usuarios getUsuarios(int rut) {
        
        LOGGER.debug("/////////////UsuariosService - rut: " + rut);
        
        return usuariosMapper.getUsuariosByRut(rut);
    }

    @Transactional
    public void insertUsuarios(Usuarios usuarios) {
        usuariosMapper.insertUsuarios(usuarios);
    }

    @Transactional
    public void updateUsuarios(Usuarios usuarios) {
        usuariosMapper.updateUsuarios(usuarios);
    }

    @Transactional
    public void deleteUsuarios(Usuarios usuarios) {
        usuariosMapper.deleteUsuarios(usuarios);
    }

    public List<Usuarios> getAllUsuarios() {
        return usuariosMapper.getAllUsuarios();
    }
}
