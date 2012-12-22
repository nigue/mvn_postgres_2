package cl.utem.informatica.alumnos.nigue.servicio;

import cl.utem.informatica.alumnos.nigue.dao.UsuarioMapper;
import cl.utem.informatica.alumnos.nigue.modelo.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("usuarioService")
public class UsuarioService {
    
    @Autowired
    private UsuarioMapper usuarioMapper;

    public Usuario getUsuario(int rut) {
        return usuarioMapper.getUsuarioByRut(rut);
    }

    @Transactional
    public void insertUsuario(Usuario usuario) {
        usuarioMapper.insertUsuario(usuario);
    }

    @Transactional
    public void updateUsuario(Usuario usuario) {
        usuarioMapper.updateUsuario(usuario);
    }

    @Transactional
    public void deleteUsuario(Usuario usuario) {
        usuarioMapper.deleteUsuario(usuario);
    }

    public List<Usuario> getAllUsuario() {
        return usuarioMapper.getAllUsuario();
    }
}
