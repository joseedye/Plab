/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.Conexion;
import DAO.ProfesorJpaController;
import DAO.TipoUsuarioJpaController;
import DAO.UsuarioJpaController;
import DTO.Profesor;
import DTO.TipoUsuario;
import DTO.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author rozo-
 */
@WebServlet(name = "UpdateProfesor", urlPatterns = {"/UpdateProfesor.do"})
public class UpdateProfesor extends HttpServlet {

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
            UsuarioJpaController usuarioDao = new UsuarioJpaController(emf);
            ProfesorJpaController profesorDao = new ProfesorJpaController(emf);
            TipoUsuarioJpaController tipoUsuarioDao = new TipoUsuarioJpaController(emf);

            //get data vista
            int id = Integer.valueOf(req.getParameter("id"));
            String nombre = req.getParameter("nombre");
            int codigo = Integer.valueOf(req.getParameter("codigo"));
            String correo = req.getParameter("correo");
            int horasSemana = Integer.valueOf(req.getParameter("horas"));

           
            Profesor profesor = profesorDao.findProfesor(id);
            Usuario usuario = usuarioDao.findUsuario(profesor.getIdUsuario().getId());
           
          usuario.setCorreo(correo);
          usuario.setNombres(nombre);
          profesor.setCodigo(codigo);
          profesor.setHorasSemana(horasSemana);
           
          usuarioDao.edit(usuario);
          profesorDao.edit(profesor);
          
           

            req.getSession().setAttribute("msg", "Profesor " + nombre + ", actualizado con éxito.");
            res.sendRedirect("QueryProfesor.do");

        } catch (Exception e) {
            req.getSession().setAttribute("msg", "Error, al actualizar profesor!");
            res.sendRedirect(user.get("TipoUsuario") + "/registrar_profesor.jsp");
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
