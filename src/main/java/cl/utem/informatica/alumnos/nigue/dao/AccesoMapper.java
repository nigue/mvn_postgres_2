package cl.utem.informatica.alumnos.nigue.dao;

import cl.utem.informatica.alumnos.nigue.modelo.Acceso;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface AccesoMapper {
    
    @Insert("INSERT INTO accesos (usuario, ip, fecha) VALUES (${acceso.usuario}, ${acceso.ip}, ${acceso.fecha});")
    void insertAcceso(@Param("acceso") Acceso acceso);
    
    @Select("SELECT usuario, ip, fecha FROM accesos;")
    List<Acceso> getAllAcceso();
}
