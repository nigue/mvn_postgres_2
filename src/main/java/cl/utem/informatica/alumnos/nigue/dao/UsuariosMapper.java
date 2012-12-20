package cl.utem.informatica.alumnos.nigue.dao;

import cl.utem.informatica.alumnos.nigue.modelo.Usuario;
import java.util.List;

public interface UsuariosMapper {
    
    Usuario getUsuariosByRut(int rut);
    
    void insertUsuarios(Usuario usuarios);
    
    void updateUsuarios(Usuario usuarios);
    
    void deleteUsuarios(Usuario usuarios);
    
    List<Usuario> getAllUsuarios();
    
}
