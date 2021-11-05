/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.ActividadJpaController;
import DAO.ActividadProfesorJpaController;
import DAO.AdministracionJpaController;
import DAO.Conexion;
import DAO.DocenciaJpaController;
import DAO.ExtensionJpaController;
import DAO.InvestigacionJpaController;
import DAO.OtrasJpaController;
import DAO.ProfesorJpaController;
import DTO.ActividadProfesorPK;
import DTO.Administracion;
import DTO.Docencia;
import DTO.Extension;
import DTO.Investigacion;
import DTO.Otras;
import DTO.Profesor;
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
public class DeleteActivity extends HttpServlet {

    protected void processRequest(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setCharacterEncoding("UTF-8");

        Map<String, String> user = (Map<String, String>) req.getSession().getAttribute("user");
        try {
            EntityManagerFactory emf = Conexion.getConexion().getBd();

            int verificador = Integer.valueOf(req.getParameter("verificador"));
            int idActividadD = Integer.valueOf(req.getParameter("id"));
            ActividadJpaController actividadDao = new ActividadJpaController(emf);
            ActividadProfesorJpaController actividadProfesorDao = new ActividadProfesorJpaController(emf);
            ActividadProfesorPK actividadProfesor = new ActividadProfesorPK();
            ProfesorJpaController profesorDao = new ProfesorJpaController(emf);
            int idUsuario = Integer.valueOf(user.get("idUsuario"));
            Profesor profesor = profesorDao.findProfesorByUsuario(idUsuario);            
            int idProfesor = profesor.getId();
            int idActividad = 0;

            switch (verificador) {
                case 0:
                    DocenciaJpaController docenciaDao = new DocenciaJpaController(emf);

                    Docencia d = docenciaDao.findDocencia(idActividadD);
                    idActividad = d.getActividad().getId();
                    docenciaDao.destroy(idActividadD);
                    break;

                case 1:
                    InvestigacionJpaController investifgacionDao = new InvestigacionJpaController(emf);
                    Investigacion i = investifgacionDao.findInvestigacion(idActividadD);
                    idActividad = i.getActividad().getId();
                    investifgacionDao.destroy(idActividadD);
                    break;
                case 2:
                    ExtensionJpaController extencionDao = new ExtensionJpaController(emf);
                    Extension e = extencionDao.findExtension(idActividadD);
                    idActividad = e.getActividad().getId();
                    extencionDao.destroy(idActividadD);
                    break;
                case 3:
                    AdministracionJpaController administracionDao = new AdministracionJpaController(emf);
                    Administracion a = administracionDao.findAdministracion(idActividadD);
                    idActividad = a.getActividad().getId();
                    administracionDao.destroy(idActividadD);
                    break;
                case 4:
                    OtrasJpaController otrasDao = new OtrasJpaController(emf);
                    Otras o = otrasDao.findOtras(idActividadD);
                    idActividad = o.getActividad().getId();
                    otrasDao.destroy(idActividadD);
                    break;

            }

            actividadProfesor.setIdActividad(idActividad);
            actividadProfesor.setIdProfesor(idProfesor);
            actividadProfesorDao.destroy(actividadProfesor);
            actividadDao.destroy(idActividad);

            req.getSession().setAttribute("msg", "Actividad eliminada con éxito!");
            res.sendRedirect("QueryActivity.do");

        } catch (Exception e) {
            req.getSession().setAttribute("msg", "Error, al eliminar la actividad");
            res.sendRedirect(user.get("TipoUsuario") + "/mis_actividades.jsp");
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
