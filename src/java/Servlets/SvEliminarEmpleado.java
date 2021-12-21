
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


@WebServlet(name = "SvEliminarEmpleado", urlPatterns = {"/SvEliminarEmpleado"})
public class SvEliminarEmpleado extends HttpServlet {


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
        Controladora control = new Controladora();
        try {
            String idUsu = control.traerEmpleados(id).getUsu().getNombre();
            control.borrarEmpleado(id);
            control.borrarUsuario(idUsu);
            
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(SvEliminarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(SvEliminarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.getSession().setAttribute("lista", control.traerEmpleados());
        response.sendRedirect("listaEmpleados.jsp");
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
