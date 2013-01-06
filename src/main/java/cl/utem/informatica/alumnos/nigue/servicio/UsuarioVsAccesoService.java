package cl.utem.informatica.alumnos.nigue.servicio;

import cl.utem.informatica.alumnos.nigue.dao.UsuarioVsAccesoMapper;
import cl.utem.informatica.alumnos.nigue.modelo.graphics.sql.UsuarioVsAcceso;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("usuarioVsAccesoService")
public class UsuarioVsAccesoService {

    @Autowired
    private UsuarioVsAccesoMapper usuarioVsAccesoMapper;

    public List<UsuarioVsAcceso> getAllUsuarioVsAcceso() {
        return usuarioVsAccesoMapper.getAllUsuarioVsAcceso();
    }
}
