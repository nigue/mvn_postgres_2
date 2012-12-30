package cl.utem.informatica.alumnos.nigue.dao;

import cl.utem.informatica.alumnos.nigue.modelo.Usuario;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UsuarioMapper {
    
    @Select("SELECT rut, nombre, password FROM usuarios WHERE rut = #{rut};")
    Usuario getUsuarioByRut(@Param("rut") int rut);
    
    @Insert("INSERT INTO usuarios (rut, nombre, password) VALUES (#{usuario.rut}, #{usuario.nombre}, #{usuario.password});")
    void insertUsuario(@Param("usuario") Usuario usuario);
    
    @Update("UPDATE usuarios SET password = #{usuario.password} WHERE rut = #{usuario.rut};")
    void updateUsuario(@Param("usuario") Usuario usuario);
    
    @Delete("DELETE FROM usuarios WHERE rut = #{usuario.rut};")
    void deleteUsuario(@Param("usuario") Usuario usuario);
    
    @Select("SELECT rut, nombre, password FROM usuarios;")
    List<Usuario> getAllUsuario();
    
}