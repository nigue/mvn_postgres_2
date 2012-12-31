package cl.utem.informatica.alumnos.nigue.dao;

import cl.utem.informatica.alumnos.nigue.modelo.Acceso;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface AccesoMapper {

//    @Insert("INSERT INTO accesos (usuario_fk, ip, fecha)"
//    + "SELECT usuarios.pk, '#{acceso.ip}', '#{acceso.fecha}'"
//    + "FROM usuarios"
//    + "WHERE usuarios.nombre = #{acceso.nombre};")
//    void insertAcceso(@Param("acceso") Acceso acceso);
    
    @Insert("INSERT INTO accesos (usuario_fk, ip, fecha) VALUES (1, #{acceso.ip}, #{acceso.fecha});")
    void insertAcceso(@Param("acceso") Acceso acceso);

    @Select("SELECT accesos.ip, accesos.fecha, usuarios.nombre"
    + " FROM accesos"
    + " INNER JOIN usuarios"
    + " ON usuarios.pk = accesos.usuario_fk;")
    List<Acceso> getAllAcceso();
}
