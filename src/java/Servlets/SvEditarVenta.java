
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


@WebServlet(name = "SvEditarVenta", urlPatterns = {"/SvEditarVenta"})
public class SvEditarVenta extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Controladora control = new Controladora();
        
        Venta ven = control.traerVenta(Integer.parseInt(request.getParameter("id")));
        
        String medioPago = request.getParameter("medio");
        ven.setMedioPago(medioPago);
        
        String idCliente = request.getParameter("cliente");
        ven.setCliente(control.traerCliente(idCliente));
        
        String idVendedor = request.getParameter("vendedor");
        ven.setVendedor(control.traerEmpleados(idVendedor));
        
        //Set fecha
        String fecha = request.getParameter("fecha");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        Date parsed = null;
        try {
            parsed = format.parse(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(SvCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        ven.setFecha(parsed);
        
        //Set paquete o servicio
        String paquete = request.getParameter("paquete");
        String tipo = paquete.substring(0,1);
        int id = Integer.parseInt(paquete.substring(1));
       
        if(tipo.equals("p")){
            Paquete paqueteVenta = control.traerPaquete(id);
            ven.setPaquete(paqueteVenta);
            ven.setServicio(null);
        } else{
            Servicio servicioVenta = control.traerServicio(id);
            ven.setServicio(servicioVenta);
            ven.setPaquete(null);
        }
        
       
        try {
            control.modificarVenta(ven);
        } catch (Exception ex) {
            Logger.getLogger(SvEditarVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        HttpSession sesion = request.getSession();
        sesion.setAttribute("lista", control.traerVentas());
        response.sendRedirect("listaVentas.jsp");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String id = request.getParameter("id");
        int idInt = Integer.parseInt(id);
        
        Controladora control = new Controladora();
        
        List <Servicio> servicios = control.traerServicios();
        List <Cliente> clientes = control.traerClientes();
        List <Empleado> empleados = control.traerEmpleados();
        List <Paquete> paquetes = control.traerPaquetes();
         
        HttpSession sesion = request.getSession();
        sesion.setAttribute("venta", control.traerVenta(idInt));
        sesion.setAttribute("servicios", servicios);
        sesion.setAttribute("clientes", clientes);
        sesion.setAttribute("empleados", empleados);
        sesion.setAttribute("paquetes", paquetes);
        response.sendRedirect("editarVenta.jsp");
    }
   

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
