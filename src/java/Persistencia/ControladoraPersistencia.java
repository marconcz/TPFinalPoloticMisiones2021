package Persistencia;

import Logica.Cliente;
import Logica.Empleado;
import Logica.Paquete;
import Logica.Servicio;
import Logica.Usuario;
import Logica.Venta;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {

    ClienteJpaController controladoraCliente = new ClienteJpaController();

    EmpleadoJpaController controladoraEmpleado = new EmpleadoJpaController();

    UsuarioJpaController controladoraUsuario = new UsuarioJpaController();
    
    ServicioJpaController controladoraServicio = new ServicioJpaController();
    
    PaqueteJpaController controladoraPaquete = new PaqueteJpaController();
    
    VentaJpaController controladoraVenta = new VentaJpaController();
    
    

    public void crearCliente(Cliente cliente, Usuario usu) {
        try {
            controladoraUsuario.create(usu);
            controladoraCliente.create(cliente);

        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearEmpleado(Empleado empleado, Usuario usu) {
        try {
            controladoraUsuario.create(usu);
            controladoraEmpleado.create(empleado);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearEmpleado(Empleado empleado) {
        try {

            controladoraEmpleado.create(empleado);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Empleado> traerEmpleados() {
        return controladoraEmpleado.findEmpleadoEntities();
    }

    public void borrarEmpleado(String id) throws NonexistentEntityException, Exception {
        Empleado emple = controladoraEmpleado.findEmpleado(id);
        emple.setHabilitado(false);
        controladoraEmpleado.edit(emple);
        //controladoraEmpleado.destroy(id);
    }

    public void borrarUsuario(String id) throws NonexistentEntityException, Exception {
        Usuario usuario = controladoraUsuario.findUsuario(id);
        usuario.setHabilitado(false);
        controladoraUsuario.edit(usuario);
        //controladoraUsuario.destroy(id);
    }

    public Empleado traerEmpleados(String id) {
        return controladoraEmpleado.findEmpleado(id);
    }

    public List<Cliente> traerClientes() {
        return controladoraCliente.findClienteEntities();
    }

    public Cliente traerClientes(String id) {
        return controladoraCliente.findCliente(id);
    }

    public void borrarCliente(String id) throws NonexistentEntityException, Exception {
        Cliente cliente = controladoraCliente.findCliente(id);
        cliente.setHabilitado(false);
        controladoraCliente.edit(cliente);
        //controladoraCliente.destroy(id);
    }

    public void modificarCliente(Cliente cliente) throws Exception {
        controladoraCliente.edit(cliente);
    }

    public void modificarEmpleado(Empleado empleado) throws Exception {
        controladoraEmpleado.edit(empleado);
    }

    public void crearServicio(Servicio servicio) {
        controladoraServicio.create(servicio);
    }

    public List<Servicio> traerServicios() {
         return controladoraServicio.findServicioEntities();
    }

    public void borrarServicio(int idInt) throws NonexistentEntityException, Exception {
        Servicio servicio = controladoraServicio.findServicio(idInt);
        servicio.deshabilitar();
        controladoraServicio.edit(servicio);
        //controladoraServicio.destroy(idInt);
    }

    public Servicio traerServicio(int id) {
        return controladoraServicio.findServicio(id);
    }

    public void modificarServicio(Servicio serv) throws Exception {
        controladoraServicio.edit(serv);
    }

    public void crearPaquete(Paquete paquete) {
        controladoraPaquete.create(paquete);
    }

    public List<Paquete> traerPaquetes() {
        return controladoraPaquete.findPaqueteEntities();
    }

    public Paquete traerPaquete(int idInt) {
        return controladoraPaquete.findPaquete(idInt);
    }

    public void modificarPaquete(Paquete paq) throws Exception {
        controladoraPaquete.edit(paq);
    }

    public void borrarPaquete(int idInt) throws Exception {
        Paquete paquete = controladoraPaquete.findPaquete(idInt);
        paquete.deshabilitar();
        controladoraPaquete.edit(paquete);
    }

    public void crearVenta(Venta venta) {
        controladoraVenta.create(venta);
    }

    public List<Venta> traerVentas() {
        return controladoraVenta.findVentaEntities();
    }

    public Venta traerVentas(int idInt) {
       return controladoraVenta.findVenta(idInt);
    }

    public void eliminarVenta(int idInt) throws Exception {
        Venta venta = controladoraVenta.findVenta(idInt);
        venta.setHabilitado(false);
        controladoraVenta.edit(venta);
    }

    public void modificarVenta(Venta ven) throws Exception {
        controladoraVenta.edit(ven);
    }

    public Usuario traerUsuario(String usuario) {
      return  controladoraUsuario.findUsuario(usuario);
    }

    
    
    
    
}
