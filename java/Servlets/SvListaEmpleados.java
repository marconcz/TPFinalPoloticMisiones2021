package Servlets;

import Logica.Controladora;
import Logica.Empleado;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvListaEmpleados", urlPatterns = {"/SvListaEmpleados"})
public class SvListaEmpleados extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Controladora control = new Controladora();
        List<Empleado> lista = control.traerEmpleados();

        HttpSession sesion = request.getSession();
        sesion.setAttribute("lista", lista);
        response.sendRedirect("listaEmpleados.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
