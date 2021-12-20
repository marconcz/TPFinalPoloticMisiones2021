
package Servlets;

import Logica.Controladora;
import Logica.Paquete;
import Logica.Servicio;
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


@WebServlet(name = "SvPaquete", urlPatterns = {"/SvPaquete"})
public class SvPaquete extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Controladora control = new Controladora();
        List<Servicio> lista = control.traerServicios();

        HttpSession sesion = request.getSession();
        sesion.setAttribute("lista", lista);
        response.sendRedirect("paquete.jsp");
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String nombre = "servicio";
        Controladora control = new Controladora();
        List <Servicio> lista = new ArrayList <Servicio>();
        
        String nombrePaquete = request.getParameter("nombrep");
        
        for(int i=1;i<6;i++){
            if(Integer.parseInt(request.getParameter(nombre + i))!= -1){
                Servicio serv = control.traerServicio(Integer.parseInt(request.getParameter(nombre + i)));
                lista.add(serv);
            }
        }
        Paquete paquete = new Paquete(nombrePaquete,lista);
        control.crearPaquete(paquete);
        
        
        //control.crearEmpleado(usuario,contra,nombre, apellido, direccion, dni, nacionalidad, celular, email,cargo,sueldo, parsed);
        response.sendRedirect("index2.jsp");
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
