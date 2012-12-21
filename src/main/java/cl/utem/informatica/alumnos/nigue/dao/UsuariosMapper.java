package cl.utem.informatica.alumnos.nigue.dao;

import cl.utem.informatica.alumnos.nigue.modelo.Usuario;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UsuariosMapper {
    
    @Select("SELECT rut, password FROM usuarios WHERE rut = #{rut};")
    Usuario getUsuariosByRut(@Param("rut") int rut);
    
    void insertUsuarios(Usuario usuarios);
    
    void updateUsuarios(Usuario usuarios);
    
    void deleteUsuarios(Usuario usuarios);
    
    List<Usuario> getAllUsuarios();
    
}