package cl.utem.informatica.alumnos.nigue.modelo;

import java.util.Date;

public class Acceso extends BaseBean {
    
    private int usuario;
    private String ip;
    private Date fecha;

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
}
