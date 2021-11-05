/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import DAO.ActividadJpaController;
import DAO.Conexion;
import DAO.ProfesorJpaController;
import DAO.UsuarioJpaController;
import DTO.ActividadProfesor;
import DTO.Profesor;
import DTO.Usuario;
import java.io.IOException;
import java.util.Map;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rozo-
 */
public class DeleteProfesor extends HttpServlet {

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
            ActividadJpaController actividadDao = new ActividadJpaController(emf);
            UsuarioJpaController usuarioDao = new UsuarioJpaController(emf);
            
            Profesor p = profesorDao.findProfesor(idProfesor);             
            p.getActividadProfesorList();            
             
            for (ActividadProfesor ap : p.getActividadProfesorList()) {
                 actividadDao.destroy(ap.getActividad().getId());
            }
            profesorDao.destroy(idProfesor);
            //si el profesor pertenece al usuario administrador
            Usuario u = p.getIdUsuario();
            if(u.getIdTipoUsuario().getIdTipoUsuario()==2)
                usuarioDao.destroy(p.getIdUsuario().getId());
            
            res.sendRedirect("QueryProfesor.do");

        } catch (Exception e) {
            req.getSession().setAttribute("msg", "Error, al eliminar el profesor");
            res.sendRedirect(user.get("TipoUsuario") + "/editar_profesor.jsp");
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
