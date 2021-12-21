
package Servlets;

import Logica.Controladora;
import Logica.Venta;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "SvEliminarVenta", urlPatterns = {"/SvEliminarVenta"})
public class SvEliminarVenta extends HttpServlet {

    
   
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
        Controladora control = new Controladora();
        String id = request.getParameter("id");
        int idInt = Integer.parseInt(id);
        
        try {
            control.eliminarVenta(idInt);
        } catch (Exception ex) {
            Logger.getLogger(SvEliminarVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getSession().setAttribute("lista", control.traerVentas());
        response.sendRedirect("listaVentas.jsp");
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
