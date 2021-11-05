
package Controlador;

import DAO.Conexion;
import DAO.UsuarioJpaController;
import DTO.Usuario;
import java.io.IOException;
import java.util.Map;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.codec.digest.DigestUtils;

public class UpdatePassword extends HttpServlet {


    protected void processRequest(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setCharacterEncoding("UTF-8");

        try {
            EntityManagerFactory emf = Conexion.getConexion().getBd();
            Map<String, String> user = (Map<String, String>) req.getSession().getAttribute("user");
            
            String oldPasswordInput = req.getParameter("oldPassword");
            String newPasswordInput = req.getParameter("newPassword");
            
            String oldPasswordInputEncrypted = DigestUtils.sha1Hex(oldPasswordInput);
            String newPasswordInputEncrypted = DigestUtils.sha1Hex(newPasswordInput);
            
            
            String currentPassword = user.get("contra");            

            if (oldPasswordInputEncrypted.equals(currentPassword)) {
                UsuarioJpaController usuarioDao = new UsuarioJpaController(emf);
                Usuario usuario = usuarioDao.findUsuario(user.get("email"));
                usuario.setContraseña(newPasswordInputEncrypted);
                usuarioDao.edit(usuario);
                
                //set map user
                user.replace("contra", newPasswordInputEncrypted);
                req.getSession().setAttribute("user", user);
                
                req.getSession().setAttribute("msg", "Contraseña cambiada exitosamente!");
                res.sendRedirect("profesor/ajustes.jsp");
            } else {
                req.getSession().setAttribute("msg", "Error, es posible que la contraseña anterior no sea correcta!");
                res.sendRedirect("profesor/ajustes.jsp");
            }

        } catch (Exception e) {
            req.getSession().setAttribute("msg", "Error, no se ha podido cambiar la contraseña");
            res.sendRedirect("profesor/ajustes.jsp");
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
