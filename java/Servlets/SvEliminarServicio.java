package Servlets;

import Logica.Controladora;
import Persistencia.exceptions.NonexistentEntityException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "SvEliminarServicio", urlPatterns = {"/SvEliminarServicio"})
public class SvEliminarServicio extends HttpServlet {

   
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
        String id = request.getParameter("id");
        int idInt = Integer.parseInt(id);
        Controladora control = new Controladora();
        try {
            control.borrarServicio(idInt);
        } catch (Exception ex) {
            Logger.getLogger(SvEliminarServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.getSession().setAttribute("lista", control.traerServicios());
        response.sendRedirect("listaServicios.jsp");
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
