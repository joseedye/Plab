
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


public class QueryActivity extends HttpServlet {
    
    protected void processRequest(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setCharacterEncoding("UTF-8");
        
            Map<String, String> user = (Map<String, String>) req.getSession().getAttribute("user");
            try {
                EntityManagerFactory emf = Conexion.getConexion().getBd();
                UsuarioJpaController usuarioDao = new UsuarioJpaController(emf);
                
                Usuario usuario = usuarioDao.findUsuario(user.get("email"));
                Profesor profesor = usuario.getProfesorList().get(0);
                
                List<ActividadProfesor> actividades = profesor.getActividadProfesorList();
                 
                int hsemana = profesor.getHorasSemana();
                int hsemestre = 0;
                Map<String, Object> mapDocencia = new HashMap<>(); 
                Map<String, Object> mapAdministracion = new HashMap<>(); 
                Map<String, Object> mapExtension = new HashMap<>(); 
                Map<String, Object> mapInvestigacion = new HashMap<>(); 
                Map<String, Object> mapOtras = new HashMap<>();   
                
                for (int i = 0; i < actividades.size(); i++) {
                    
                    Docencia docencia = actividades.get(i).getActividad().getDocencia();
                    Administracion administracion = actividades.get(i).getActividad().getAdministracion();
                    Extension extension = actividades.get(i).getActividad().getExtension();
                    Investigacion investigacion = actividades.get(i).getActividad().getInvestigacion();
                    Otras otras = actividades.get(i).getActividad().getOtras();
                    
                    if(docencia!=null){
                        mapDocencia.put(i+"", Utileria.docenciaToMap(docencia,actividades.get(i).getActividad()));
                        hsemestre += docencia.getHorasSemestre();
                    }
                    if(administracion!=null){
                        mapAdministracion.put(i+"", Utileria.administracionToMap(administracion,actividades.get(i).getActividad()));
                        hsemestre += administracion.getHorasSemestre();
                    }
                    if(extension!=null){
                        mapExtension.put(i+"", Utileria.extensionToMap(extension,actividades.get(i).getActividad()));
                        hsemestre += extension.getHorasSemestre();
                    }
                    if(investigacion!=null)
                        mapInvestigacion.put(i+"", Utileria.investigacionToMap(investigacion,actividades.get(i).getActividad()));
                    if(otras!=null){
                        mapOtras.put(i+"", Utileria.otrasToMap(otras,actividades.get(i).getActividad()));
                        hsemestre += otras.getHorasSemestre();
                    }
                }
                
                req.getSession().setAttribute("docencia", mapDocencia);
                req.getSession().setAttribute("administracion", mapAdministracion);
                req.getSession().setAttribute("investigacion", mapInvestigacion);
                req.getSession().setAttribute("extension", mapExtension);
                req.getSession().setAttribute("otras", mapOtras);    
                req.getSession().setAttribute("hsemana", hsemana+"");     
                req.getSession().setAttribute("hsemestre", hsemestre+""); 
                                
                res.sendRedirect(user.get("TipoUsuario")+"/mis_actividades.jsp");                 
                
        } catch (Exception e) {
            req.getSession().setAttribute("msg", "Error, al consultar actividades");
            res.sendRedirect(user.get("TipoUsuario")+"/mis_actividades.jsp");
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
