package org.mybatis.tarea.persistence;

import java.util.List;
import org.mybatis.tarea.domain.Usuarios;

public interface UsuariosMapper {
    
    Usuarios getUsuariosByRut(int rut);
    
    void insertUsuarios(Usuarios usuarios);
    
    void updateUsuarios(Usuarios usuarios);
    
    void deleteUsuarios(Usuarios usuarios);
    
    List<Usuarios> getAllUsuarios();
    
}
