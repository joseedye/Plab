
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

public class RegisterInvestigacion extends HttpServlet {

    
    protected void processRequest(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        
        res.setCharacterEncoding("UTF-8");
        
        Map<String, String> user = (Map<String, String>) req.getSession().getAttribute("user");
        try {
            EntityManagerFactory emf = Conexion.getConexion().getBd();
            UsuarioJpaController usuarioDao = new UsuarioJpaController(emf);
            ActividadJpaController actividadDao = new ActividadJpaController(emf);
            InvestigacionJpaController investigacionDao = new InvestigacionJpaController(emf);
            ActividadProfesorJpaController actividadPDao = new ActividadProfesorJpaController(emf);
            ProfesorJpaController profesorDao = new ProfesorJpaController(emf);

            Usuario usuario = usuarioDao.findUsuario(user.get("email"));
            Profesor profesor = usuario.getProfesorList().get(0);

            //get data vista
            String nombre = req.getParameter("inombre");
            String codigo = req.getParameter("icodigo");
            String responsabilidad = req.getParameter("iresponsabilidad");
            String unidad = req.getParameter("iunidad");
            String institucion = req.getParameter("iinstitucion");
            int hsemana = Integer.valueOf(req.getParameter("ihsemana"));

            //Obtiene el ultimo registro de la tabla actividades
            int auto_increment = 1;
            try {
                auto_increment = actividadDao.getActividadLast().getId() + 1;
            } catch (Exception e) {
            }

            //Creacion entity
            Actividad actividad = new Actividad(auto_increment, nombre, hsemana);
            Investigacion investigacion = new Investigacion(auto_increment, codigo, responsabilidad, unidad, institucion);
            ActividadProfesorPK actiPK = new ActividadProfesorPK(profesor.getId(), auto_increment);
            ActividadProfesor actividadP = new ActividadProfesor(actiPK, new Date(), "");
            actividadP.setActividad(actividad);
            actividadP.setProfesor(profesor);
            
            //Creacion persistencia from entity
            actividadDao.create(actividad);
            investigacion.setActividad(actividad);
            investigacionDao.create(investigacion);
            actividadPDao.create(actividadP);
            
            int hsemanaCurrent = profesor.getHorasSemana();
            profesor.setHorasSemana(hsemana+hsemanaCurrent);
            profesor.getActividadProfesorList().add(actividadP);
            
            //edit persistencia
            profesorDao.edit(profesor);
            
            req.getSession().setAttribute("msg", "Actividad: "+nombre+", registrada con éxito.");
            res.sendRedirect(user.get("TipoUsuario") + "/registrar_actividad.jsp");

        } catch (Exception e) {
            req.getSession().setAttribute("msg", "Error, al registrar actividad!");
            res.sendRedirect(user.get("TipoUsuario") + "/registrar_actividad.jsp");
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
