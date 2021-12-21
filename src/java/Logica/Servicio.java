
package Logica;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Servicio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo;
    
    @Basic
    private String nombre;
    private String descripcion;
    private String destino;
    private Double costo;
    private boolean habilitado = true;
    
    @Temporal(TemporalType.DATE)
    private Date fecha;
    

    public Servicio() {
    }

    public Servicio(String nombre, String descripcion, String destino, Date fecha, Double costo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.destino = destino;
        this.fecha = fecha;
        this.costo = costo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getFecha() {
        return fecha;
    }
    
    public String getFechaStr(){
        Date fecha = this.fecha;
        DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");  
        String strDate = dateFormat.format(fecha); 
        return strDate;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public void deshabilitar() {
        this.habilitado = false;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }
    
    
    
    
    
}
