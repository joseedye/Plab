
package Controlador;

import DAO.*;
import DTO.*;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.codec.digest.DigestUtils;

public class RegisterProfesor extends HttpServlet {

    
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
            String nombre = req.getParameter("nombre");
            String codigo = req.getParameter("codigo");
            String correo = req.getParameter("correo");
            String vinculacion = "planta";
            int horasSemana = Integer.valueOf(req.getParameter("horas"));
            
            String contraseña = DigestUtils.sha1Hex(codigo);
            
            Usuario usuario = new Usuario(0, nombre, correo, contraseña, true, "", new Date());            
            Profesor profesor = new Profesor(0, new Date(), Integer.valueOf(codigo),horasSemana,vinculacion);
            TipoUsuario tipoUsuario = tipoUsuarioDao.findTipoUsuario(2);
            
            usuario.setIdTipoUsuario(tipoUsuario);
            profesor.setIdUsuario(usuario);
            usuarioDao.create(usuario);
            profesorDao.create(profesor);
            
            req.getSession().setAttribute("msg", "Profesor "+nombre+", registrado con éxito.");
            res.sendRedirect(user.get("TipoUsuario") + "/registrar_profesor.jsp");

        } catch (Exception e) {
            req.getSession().setAttribute("msg", "Error, al registrar profesor!");
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
