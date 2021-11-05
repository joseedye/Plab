/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.Conexion;
import DAO.ProfesorJpaController;
import DTO.Profesor;
import DTO.Usuario;
import Util.Utileria;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rozo-
 */
@WebServlet(name = "EditProfesor", urlPatterns = {"/EditProfesor.do"})
public class EditProfesor extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   protected void processRequest(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
       res.setCharacterEncoding("UTF-8");

        Map<String, String> user = (Map<String, String>) req.getSession().getAttribute("user");
        try {
            EntityManagerFactory emf = Conexion.getConexion().getBd();
            int idProfesor = Integer.valueOf(req.getParameter("id"));
             ProfesorJpaController profesorDao = new ProfesorJpaController(emf);
              Profesor profesorDto = new Profesor(); 
             profesorDto = profesorDao.findProfesor(idProfesor);
            Usuario usuario = profesorDto.getIdUsuario();     
             
              Map<String, String> mapProfesor =  Utileria.profesorToMap(profesorDto, usuario);
              req.getSession().setAttribute("profesor", mapProfesor);
              req.getSession().setAttribute("idd", idProfesor+"");
             res.sendRedirect("./administrador/registrar_profesor.jsp");

        } catch (Exception e) {
            req.getSession().setAttribute("msg", "Error, al editar el profesor");
            res.sendRedirect(user.get("TipoUsuario") + "/edita_profesor.jsp");
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
