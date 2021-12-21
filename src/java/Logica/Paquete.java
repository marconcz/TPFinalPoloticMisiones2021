package Logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Paquete implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo;

    @ManyToMany
    List<Servicio> servicios;
    @Basic
    private String nombre;
    private boolean habilitado;

    public Paquete() {
    }


    public Paquete(String nombrePaquete, List<Servicio> lista) {
        this.habilitado = true;
        this.servicios = lista;
        this.nombre = nombrePaquete;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void agregarServicio(Servicio serv) {
        servicios.add(serv);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public void deshabilitar() {
        this.habilitado = false;
    }
    
    public Double getCosto(){
        //descuento = 1 - Rebaja del precio , si el precio es 10% menos entonces 1 - 0.1
        Double descuento = 0.9;
        Double costo = 0.0;
        for (Servicio ser : this.servicios){
            costo = costo + ser.getCosto();
        }
     return costo* descuento;
    }

}
