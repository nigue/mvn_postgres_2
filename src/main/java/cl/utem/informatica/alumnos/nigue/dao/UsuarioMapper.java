package cl.utem.informatica.alumnos.nigue.dao;

import cl.utem.informatica.alumnos.nigue.modelo.Usuario;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UsuarioMapper {
    
    @Select("SELECT rut, password FROM usuario WHERE rut = #{rut};")
    Usuario getUsuarioByRut(@Param("rut") int rut);
    
    @Insert("INSERT INTO usuario (rut, password) VALUES (#{usuario.rut}, #{usuario.password});")
    void insertUsuario(@Param("usuario") Usuario usuario);
    
    @Update("UPDATE usuario SET password = #{usuario.password} WHERE rut = #{usuario.rut};")
    void updateUsuario(@Param("usuario") Usuario usuario);
    
    @Delete("DELETE FROM usuario WHERE rut = #{usuario.rut};")
    void deleteUsuario(@Param("usuario") Usuario usuario);
    
    @Select("SELECT rut, password FROM usuario;")
    List<Usuario> getAllUsuario();
    
}