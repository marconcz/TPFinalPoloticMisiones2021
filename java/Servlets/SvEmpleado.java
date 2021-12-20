
package Servlets;

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


@WebServlet(name = "SvEmpleado", urlPatterns = {"/SvEmpleado"})
public class SvEmpleado extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String contra = request.getParameter("contra"); 
        String usuario = request.getParameter("usuario"); 
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String direccion = request.getParameter("direccion");
        String dni = request.getParameter("dni");
        String nacionalidad = request.getParameter("nacionalidad");
        String celular = request.getParameter("celular");
        String email = request.getParameter("email");
        double sueldo = Double.parseDouble(request.getParameter("sueldo"));
        String cargo = request.getParameter("cargo");
        String fecha = request.getParameter("nacimiento");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        Date parsed = null;
        try {
            parsed = format.parse(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(SvCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Controladora control = new Controladora();
        control.crearEmpleado(usuario,contra,nombre, apellido, direccion, dni, nacionalidad, celular, email,cargo,sueldo, parsed);
        response.sendRedirect("index2.jsp");
    }
        
        
    

    
   @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
