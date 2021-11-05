package Controlador;

import DAO.*;
import DTO.*;
import Util.Utileria;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class QueryProfesor extends HttpServlet {

    protected void processRequest(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setCharacterEncoding("UTF-8");

        try {
            EntityManagerFactory emf = Conexion.getConexion().getBd();
            UsuarioJpaController usuarioDao = new UsuarioJpaController(emf);
            ProfesorJpaController profesorDao = new ProfesorJpaController(emf);

            List<Profesor> profesores = profesorDao.findProfesorEntities();

            Map<String, Object> mapProfesores = new HashMap<>();

            for (int i = 0; i < profesores.size(); i++) {

                Profesor profesor = profesores.get(i);
                Usuario usuario = profesor.getIdUsuario();                
                mapProfesores.put(i + "", Utileria.profesorToMap(profesor, usuario));
            }

            req.getSession().setAttribute("profesores", mapProfesores);
            
            String page = req.getParameter("page");
            
            if(page != null){
                res.sendRedirect("administrador/progreso.jsp");
            }
            else{
                res.sendRedirect("administrador/editar_profesor.jsp");
            }

        } catch (Exception e) {
            req.getSession().setAttribute("msg", "Error, al consultar profesores");
            res.sendRedirect("administrador/progreso.jsp");
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
