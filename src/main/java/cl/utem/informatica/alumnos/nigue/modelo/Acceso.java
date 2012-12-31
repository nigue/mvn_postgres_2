package cl.utem.informatica.alumnos.nigue.modelo;

import java.net.InetAddress;
import java.sql.Timestamp;

public class Acceso {
    
    private InetAddress ip;
    private Timestamp fecha;
    private String nombre;

    public InetAddress getIp() {
        return ip;
    }

    public void setIp(InetAddress ip) {
        this.ip = ip;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
