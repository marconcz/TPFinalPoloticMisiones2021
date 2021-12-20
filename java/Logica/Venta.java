
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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Venta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int numeroVenta;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic
    private String medioPago;
    private boolean habilitado;
    @ManyToOne
    private Cliente cliente;
    @ManyToOne
    private Paquete paquete;
    @ManyToOne
    private Servicio servicio;
    @ManyToOne
    private Empleado vendedor;

    public Venta() {
    }

    public Venta(Date fecha, String medioPago, Cliente cliente, Paquete paquete, Servicio servicio, Empleado vendedor) {
        this.habilitado=true;
        this.fecha = fecha;
        this.medioPago = medioPago;
        this.cliente = cliente;
        this.paquete = paquete;
        this.servicio = servicio;
        this.vendedor = vendedor;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public int getNumeroVenta() {
        return numeroVenta;
    }

    public void setNumeroVenta(int numeroVenta) {
        this.numeroVenta = numeroVenta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Empleado getVendedor() {
        return vendedor;
    }

    public void setVendedor(Empleado vendedor) {
        this.vendedor = vendedor;
    }
    
     public String getFechaStr() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
        String strDate = dateFormat.format(this.getFecha()); 
        return strDate;
    }
    
    
    
    
    
}
