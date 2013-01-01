package cl.utem.informatica.alumnos.nigue.modelo;

import java.sql.Timestamp;

public class Acceso extends BaseBean {
    
    private String ip;
    private Timestamp fecha;
    private String nombre;

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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
