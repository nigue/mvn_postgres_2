package cl.utem.informatica.alumnos.nigue.servicio;

import cl.utem.informatica.alumnos.nigue.dao.AccesoMapper;
import cl.utem.informatica.alumnos.nigue.modelo.Acceso;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("accesoService")
public class AccesoService {
    
    @Autowired
    private AccesoMapper accesoMapper;
    
    @Transactional
    public void insertAcceso(Acceso acceso){
        accesoMapper.insertAcceso(acceso);
    }
    
    public List<Acceso> getAllAcceso(){
        return accesoMapper.getAllAcceso();
    }
}
