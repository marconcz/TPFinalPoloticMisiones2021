package Servlets;

import Logica.Controladora;
import Logica.Empleado;
import Logica.Servicio;
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


@WebServlet(name = "SvEditarServicio", urlPatterns = {"/SvEditarServicio"})
public class SvEditarServicio extends HttpServlet {

 
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
        Servicio serv = control.traerServicio(Integer.parseInt(request.getParameter("id")));
        
        serv.setCosto(Double.parseDouble(request.getParameter("precio")));
        serv.setNombre(request.getParameter("nombre"));
        serv.setDescripcion(request.getParameter("descripcion"));
        serv.setDestino(request.getParameter("destino"));
        
        serv.setFecha(parsed);
        
        
        try {
            control.modificarServicio(serv);
        } catch (Exception ex) {
            Logger.getLogger(SvEditarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        request.getSession().setAttribute("lista",control.traerServicios());
        response.sendRedirect("listaServicios.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        int idInt = Integer.parseInt(id);
        
        Controladora control = new Controladora();
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("servicio", control.traerServicio(idInt));
        response.sendRedirect("editarServicios.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
