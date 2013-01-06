package cl.utem.informatica.alumnos.nigue.dao;

import cl.utem.informatica.alumnos.nigue.modelo.graphics.sql.UsuarioVsAcceso;
import java.util.List;
import org.apache.ibatis.annotations.Select;

public interface UsuarioVsAccesoMapper {

    @Select("SELECT usuarios.nombre, count(*) AS acceso"
    + " FROM usuarios"
    + " INNER JOIN accesos"
    + " ON usuarios.pk = accesos.usuario_fk"
    + " GROUP BY usuarios.nombre;")
    List<UsuarioVsAcceso> getAllUsuarioVsAcceso();
}
