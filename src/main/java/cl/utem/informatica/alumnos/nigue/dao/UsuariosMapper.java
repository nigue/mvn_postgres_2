package cl.utem.informatica.alumnos.nigue.dao;

import cl.utem.informatica.alumnos.nigue.modelo.Usuario;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UsuariosMapper {
    
    @Select("SELECT rut, password FROM usuarios WHERE rut = #{rut};")
    Usuario getUsuariosByRut(@Param("rut") int rut);
    
    @Insert("INSERT INTO usuarios (rut, password) VALUES (#{usuarios.rut}, #{usuarios.password});")
    void insertUsuarios(@Param("usuarios") Usuario usuarios);
    
    @Update("UPDATE usuarios SET password = #{usuarios.password} WHERE rut = #{usuarios.rut};")
    void updateUsuarios(@Param("usuarios") Usuario usuarios);
    
    @Delete("DELETE FROM usuarios WHERE rut = #{usuarios.rut};")
    void deleteUsuarios(@Param("usuarios") Usuario usuarios);
    
    @Select("SELECT rut, password FROM usuarios;")
    List<Usuario> getAllUsuarios();
    
}