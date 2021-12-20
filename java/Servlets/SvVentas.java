package Servlets;

import Logica.Cliente;
import Logica.Controladora;
import Logica.Empleado;
import Logica.Paquete;
import Logica.Servicio;
import Logica.Venta;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvVentas", urlPatterns = {"/SvVentas"})
public class SvVentas extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Controladora control = new Controladora();
        List<Paquete> lista = control.traerPaquetes();
        List<Servicio> listaServ = control.traerServicios();
        List<Cliente> listaClie = control.traerClientes();
        List<Empleado> listaVend = control.traerEmpleados();

        HttpSession sesion = request.getSession();
        sesion.setAttribute("lista", lista);
        sesion.setAttribute("lista2", listaServ);
        sesion.setAttribute("lista3", listaClie);
        sesion.setAttribute("lista4", listaVend);
        response.sendRedirect("venta.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Controladora control = new Controladora();
        String medioPago = request.getParameter("medio");
        String cliente = request.getParameter("cliente");
        String vendedor = request.getParameter("vendedor");
        String paquete = request.getParameter("paquete");
        String tipo = paquete.substring(0,1);
        int id = Integer.parseInt(paquete.substring(1));
        
        Venta venta = new Venta();
        
        if(tipo.equals("p")){
            Paquete paqueteVenta = control.traerPaquete(id);
            venta.setPaquete(paqueteVenta);
        } else{
            Servicio servicioVenta = control.traerServicio(id);
            venta.setServicio(servicioVenta);
        }
        venta.setHabilitado(true);
        venta.setMedioPago(medioPago);
        venta.setCliente(control.traerCliente(cliente));
        venta.setVendedor(control.traerEmpleados(vendedor));
        
        String fecha = request.getParameter("fecha");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        Date parsed = null;
        try {
            parsed = format.parse(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(SvCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        venta.setFecha(parsed);
        
        control.crearVenta(venta);
        
        //control.crearEmpleado(usuario,contra,nombre, apellido, direccion, dni, nacionalidad, celular, email,cargo,sueldo, parsed);
        response.sendRedirect("index2.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
