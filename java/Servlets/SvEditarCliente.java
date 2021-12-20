
package Servlets;

import Logica.Cliente;
import Logica.Controladora;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "SvEditarCliente", urlPatterns = {"/SvEditarCliente"})
public class SvEditarCliente extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
        
        String fecha = request.getParameter("nacimiento");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        Date parsed = null;
        try {
            parsed = format.parse(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(SvCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Controladora control = new Controladora();
        Cliente cliente = control.traerCliente(request.getParameter("id"));
        cliente.setNombre(request.getParameter("nombre"));
        cliente.setApellido(request.getParameter("apellido"));
        cliente.setDireccion(request.getParameter("direccion"));
        cliente.setDni(request.getParameter("dni"));
        cliente.setNacionalidad(request.getParameter("nacionalidad"));
        cliente.setCelular(request.getParameter("celular"));
        cliente.setEmail(request.getParameter("email"));
        cliente.setFechaNacimiento(parsed);
        
        try {
            control.modificarCliente(cliente);
        } catch (Exception ex) {
            Logger.getLogger(SvEditarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getSession().setAttribute("lista",control.traerClientes());
        response.sendRedirect("listaClientes.jsp");
        
        
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String id = request.getParameter("id");
        Controladora control = new Controladora();
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("cliente", control.traerCliente(id));
        response.sendRedirect("editarClientes.jsp");
        System.out.println(control.traerCliente(id).getFechaNacimientoString());
        
        
        
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
