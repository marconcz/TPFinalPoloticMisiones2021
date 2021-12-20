package Servlets;

import Logica.Cliente;
import Logica.Controladora;
import Logica.Empleado;
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


@WebServlet(name = "SvEditarEmpleado", urlPatterns = {"/SvEditarEmpleado"})
public class SvEditarEmpleado extends HttpServlet {

  
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
        Empleado empleado = control.traerEmpleados(request.getParameter("id"));
        
        empleado.setSueldo(Double.parseDouble(request.getParameter("sueldo")));
        empleado.setCargo(request.getParameter("cargo"));
        empleado.setNombre(request.getParameter("nombre"));
        empleado.setApellido(request.getParameter("apellido"));
        empleado.setDireccion(request.getParameter("direccion"));
        empleado.setDni(request.getParameter("dni"));
        empleado.setNacionalidad(request.getParameter("nacionalidad"));
        empleado.setCelular(request.getParameter("celular"));
        empleado.setEmail(request.getParameter("email"));
        
        empleado.setFechaNacimiento(parsed);
        
        
        try {
            control.modificarEmpleado(empleado);
        } catch (Exception ex) {
            Logger.getLogger(SvEditarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getSession().setAttribute("lista",control.traerEmpleados());
        response.sendRedirect("listaEmpleados.jsp");
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String id = request.getParameter("id");
        Controladora control = new Controladora();
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("empleado", control.traerEmpleados(id));
        response.sendRedirect("editarEmpleados.jsp");
        
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
