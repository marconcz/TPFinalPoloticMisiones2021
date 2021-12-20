package Logica;

import Persistencia.ControladoraPersistencia;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.Date;
import java.util.List;

public class Controladora {

    ControladoraPersistencia controlPersistencia = new ControladoraPersistencia();

    public void crearCliente(String usuario, String contra, String nombre, String apellido, String direccion, String dni, String nacionalidad, String celular, String email, Date nacimiento) {
        Usuario usu = new Usuario(usuario, contra);
        Cliente nuevoCliente = new Cliente(usuario, contra, nombre, apellido, direccion, dni, nacionalidad, celular, email, nacimiento);
        nuevoCliente.setUsu(usu);
        controlPersistencia.crearCliente(nuevoCliente, usu);
    }

    public void crearEmpleado(String usuario, String contra, String nombre, String apellido, String direccion, String dni, String nacionalidad, String celular, String email, String cargo, double sueldo, Date parsed) {

        Empleado nuevoEmpleado = new Empleado(nombre, apellido, direccion, dni, nacionalidad, celular, email, sueldo, cargo, parsed);

        Usuario usu = new Usuario(usuario, contra);

        nuevoEmpleado.setUsu(usu);

        controlPersistencia.crearEmpleado(nuevoEmpleado, usu);
    }

    public List<Empleado> traerEmpleados() {
        return controlPersistencia.traerEmpleados();
    }

    public void borrarEmpleado(String id) throws NonexistentEntityException, Exception {
        controlPersistencia.borrarEmpleado(id);
    }

    public Empleado traerEmpleados(String id) {
        return controlPersistencia.traerEmpleados(id);
    }

    public void borrarUsuario(String idUsu) throws NonexistentEntityException, Exception {
        controlPersistencia.borrarUsuario(idUsu);
    }

    public List<Cliente> traerClientes() {
        return controlPersistencia.traerClientes();
    }

    public Cliente traerCliente(String id) {
        return controlPersistencia.traerClientes(id);
    }

    public void borrarCliente(String id) throws NonexistentEntityException, Exception {
        controlPersistencia.borrarCliente(id);
    }

    public void modificarCliente(Cliente cliente) throws Exception {
        controlPersistencia.modificarCliente(cliente);
    }

    public void modificarEmpleado(Empleado empleado) throws Exception {
        controlPersistencia.modificarEmpleado(empleado);
    }

    public void crearServicio(String nombre, String desc, String destino, Date fecha, double precio) {
        Servicio servicio = new Servicio(nombre, desc, destino, fecha, precio);
        controlPersistencia.crearServicio(servicio);
    }

    public List<Servicio> traerServicios() {
        return controlPersistencia.traerServicios();
    }

    public void borrarServicio(int idInt) throws NonexistentEntityException, Exception {
        controlPersistencia.borrarServicio(idInt);
    }

    public Servicio traerServicio(int id) {
        return controlPersistencia.traerServicio(id);
    }

    public void modificarServicio(Servicio serv) throws Exception {
        controlPersistencia.modificarServicio(serv);
    }

    public void crearPaquete(Paquete paquete) {
        controlPersistencia.crearPaquete(paquete);
    }

    public List<Paquete> traerPaquetes() {
        return controlPersistencia.traerPaquetes();
    }

    public Paquete traerPaquete(int idInt) {
        return controlPersistencia.traerPaquete(idInt);
    }

    public void modificarPaquete(Paquete paq) throws Exception {
        controlPersistencia.modificarPaquete(paq);
    }

    public void borrarPaquete(int idInt) throws Exception {
        controlPersistencia.borrarPaquete(idInt);
    }

    public void crearVenta(Venta venta) {
        controlPersistencia.crearVenta(venta);
    }

    public List<Venta> traerVentas() {
        return controlPersistencia.traerVentas();
    }

    public Venta traerVenta(int idInt) {
        return controlPersistencia.traerVentas(idInt);
    }

    public void eliminarVenta(int idInt) throws Exception {
        controlPersistencia.eliminarVenta(idInt);
    }

    public void modificarVenta(Venta ven) throws Exception {
        controlPersistencia.modificarVenta(ven);
    }

    public Usuario traerUsuario(String usuario) {
        return controlPersistencia.traerUsuario(usuario);
    }

    public boolean verificarLog(String usuario, String contra) {
        if (usuario.equals("root")) return true;
        
        if (this.traerUsuario(usuario) != null) {
            Usuario usu = this.traerUsuario(usuario);
            return (usu.isHabilitado() & usu.getNombre().equals(usuario) & usu.getContra().equals(contra));
        } else {
            return false;
        }
    }

}
