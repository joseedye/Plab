package Controlador;

import DAO.*;
import DTO.*;
import java.io.IOException;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.codec.digest.DigestUtils;

public class PassChange extends HttpServlet {

    protected void processRequest(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setCharacterEncoding("UTF-8");

        EntityManagerFactory emf = Conexion.getConexion().getBd();

        try {
            String token = req.getSession().getAttribute("token").toString();
            String pass = req.getParameter("pass");

            RecoveryJpaController recoveryjpa = new RecoveryJpaController(emf);
            UsuarioJpaController usuarioDao = new UsuarioJpaController(emf);

            Recovery recovery = recoveryjpa.findRecovery(Integer.valueOf(token));
            
            if (recovery != null) {
                String user = recovery.getUser();
                Usuario usuario = usuarioDao.findUsuario(user);
                

                String newContraseñaEncrypted = DigestUtils.sha1Hex(pass);
                usuario.setContraseña(newContraseñaEncrypted);
                usuarioDao.edit(usuario);
                recoveryjpa.destroy(Integer.valueOf(token));

                req.getSession().setAttribute("msg", "Contraseña cambiada exitosamente. Inicia Sesión!");
                req.getSession().setAttribute("user", user);
                req.getSession().setAttribute("pass", pass);
                
                res.sendRedirect("SignIn.do");
                
            } else {
                req.getSession().setAttribute("msg", "Error, al cambiar la contraseña");
                res.sendRedirect("recuperacion/cambio_clave.jsp");
            }

        } catch (Exception e) {
            req.getSession().setAttribute("msg", "Error, al cambiar la contraseña");
            res.sendRedirect("recuperacion/cambio_clave.jsp");
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
