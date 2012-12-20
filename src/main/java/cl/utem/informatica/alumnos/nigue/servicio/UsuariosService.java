package cl.utem.informatica.alumnos.nigue.servicio;

import cl.utem.informatica.alumnos.nigue.dao.UsuariosMapper;
import cl.utem.informatica.alumnos.nigue.modelo.Usuario;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("usuariosService")
public class UsuariosService {

    private static final Logger LOGGER = Logger.getLogger(UsuariosService.class);
    
    @Autowired
    private UsuariosMapper usuariosMapper;

    public Usuario getUsuarios(int rut) {
        
        LOGGER.debug("/////////////UsuariosService - rut: " + rut);
        
        return usuariosMapper.getUsuariosByRut(rut);
    }

    @Transactional
    public void insertUsuarios(Usuario usuarios) {
        usuariosMapper.insertUsuarios(usuarios);
    }

    @Transactional
    public void updateUsuarios(Usuario usuarios) {
        usuariosMapper.updateUsuarios(usuarios);
    }

    @Transactional
    public void deleteUsuarios(Usuario usuarios) {
        usuariosMapper.deleteUsuarios(usuarios);
    }

    public List<Usuario> getAllUsuarios() {
        return usuariosMapper.getAllUsuarios();
    }
}
