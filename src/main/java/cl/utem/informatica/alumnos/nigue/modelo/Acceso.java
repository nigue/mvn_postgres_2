package cl.utem.informatica.alumnos.nigue.modelo;

import java.sql.Timestamp;

public class Acceso {
    
    private int usuario;
    private String ip;
    private Timestamp fecha;

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

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }
    
}
