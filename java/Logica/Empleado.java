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
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Empleado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Basic
    private boolean habilitado;
    private String nombre;
    private String apellido;
    private String direccion;
    private String dni;
    private String nacionalidad;
    private String celular;
    private String email;
    private double sueldo;
    private String cargo;
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @OneToOne
    Usuario usu;

    public Empleado() {
    }

    public Empleado(String nombre, String apellido, String direccion, String dni, String nacionalidad, String celular, String email, double sueldo, String cargo, Date fechaNacimiento) {
        this.habilitado = true;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.dni = dni;
        this.nacionalidad = nacionalidad;
        this.celular = celular;
        this.email = email;
        this.sueldo = sueldo;
        this.cargo = cargo;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Usuario getUsu() {
        return usu;
    }

    public void setUsu(Usuario usu) {
        this.usu = usu;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    String getUserID() {
        return usu.getNombre();
    }

    public String getFechaNacimientoString() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
        String strDate = dateFormat.format(this.getFechaNacimiento()); 
        return strDate;
    }

    public void setHabilitado(boolean b) {
        this.habilitado = b;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

}
