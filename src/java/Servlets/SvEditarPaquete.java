
package Servlets;

import Logica.Controladora;
import Logica.Paquete;
import Logica.Servicio;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "SvEditarPaquete", urlPatterns = {"/SvEditarPaquete"})
public class SvEditarPaquete extends HttpServlet {

   
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        Controladora control = new Controladora();
        Paquete paq = control.traerPaquete(Integer.parseInt(request.getParameter("id")));
        
        List <Servicio> lista = new ArrayList <Servicio>();
        
        String nombrePaquete = request.getParameter("nombrep");
        
        String nombre = "servicio";
        for(int i=1;i<6;i++){
            if(Integer.parseInt(request.getParameter(nombre + i))!= -1){
                Servicio serv = control.traerServicio(Integer.parseInt(request.getParameter(nombre + i)));
                lista.add(serv);
            }
        }
        
        paq.setNombre(nombrePaquete);
        paq.setServicios(lista);
        try {
            control.modificarPaquete(paq);
        } catch (Exception ex) {
            Logger.getLogger(SvEditarPaquete.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        response.sendRedirect("listaPaquetes.jsp");
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String id = request.getParameter("id");
        int idInt = Integer.parseInt(id);
        
        Controladora control = new Controladora();
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("paquete", control.traerPaquete(idInt));
        sesion.setAttribute("lista", control.traerServicios());
        response.sendRedirect("editarPaquetes.jsp");
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
