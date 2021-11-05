/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.exceptions.IllegalOrphanException;
import DAO.exceptions.NonexistentEntityException;
import DTO.Actividad;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import DTO.Investigacion;
import DTO.Docencia;
import DTO.Extension;
import DTO.Otras;
import DTO.Administracion;
import DTO.ActividadProfesor;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Leonardo
 */
public class ActividadJpaController implements Serializable {

    public ActividadJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Actividad actividad) {
        if (actividad.getActividadProfesorList() == null) {
            actividad.setActividadProfesorList(new ArrayList<ActividadProfesor>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Investigacion investigacion = actividad.getInvestigacion();
            if (investigacion != null) {
                investigacion = em.getReference(investigacion.getClass(), investigacion.getIdActividad());
                actividad.setInvestigacion(investigacion);
            }
            Docencia docencia = actividad.getDocencia();
            if (docencia != null) {
                docencia = em.getReference(docencia.getClass(), docencia.getIdActividad());
                actividad.setDocencia(docencia);
            }
            Extension extension = actividad.getExtension();
            if (extension != null) {
                extension = em.getReference(extension.getClass(), extension.getIdActividad());
                actividad.setExtension(extension);
            }
            Otras otras = actividad.getOtras();
            if (otras != null) {
                otras = em.getReference(otras.getClass(), otras.getIdActividad());
                actividad.setOtras(otras);
            }
            Administracion administracion = actividad.getAdministracion();
            if (administracion != null) {
                administracion = em.getReference(administracion.getClass(), administracion.getIdActividad());
                actividad.setAdministracion(administracion);
            }
            List<ActividadProfesor> attachedActividadProfesorList = new ArrayList<ActividadProfesor>();
            for (ActividadProfesor actividadProfesorListActividadProfesorToAttach : actividad.getActividadProfesorList()) {
                actividadProfesorListActividadProfesorToAttach = em.getReference(actividadProfesorListActividadProfesorToAttach.getClass(), actividadProfesorListActividadProfesorToAttach.getActividadProfesorPK());
                attachedActividadProfesorList.add(actividadProfesorListActividadProfesorToAttach);
            }
            actividad.setActividadProfesorList(attachedActividadProfesorList);
            em.persist(actividad);
            if (investigacion != null) {
                Actividad oldActividadOfInvestigacion = investigacion.getActividad();
                if (oldActividadOfInvestigacion != null) {
                    oldActividadOfInvestigacion.setInvestigacion(null);
                    oldActividadOfInvestigacion = em.merge(oldActividadOfInvestigacion);
                }
                investigacion.setActividad(actividad);
                investigacion = em.merge(investigacion);
            }
            if (docencia != null) {
                Actividad oldActividadOfDocencia = docencia.getActividad();
                if (oldActividadOfDocencia != null) {
                    oldActividadOfDocencia.setDocencia(null);
                    oldActividadOfDocencia = em.merge(oldActividadOfDocencia);
                }
                docencia.setActividad(actividad);
                docencia = em.merge(docencia);
            }
            if (extension != null) {
                Actividad oldActividadOfExtension = extension.getActividad();
                if (oldActividadOfExtension != null) {
                    oldActividadOfExtension.setExtension(null);
                    oldActividadOfExtension = em.merge(oldActividadOfExtension);
                }
                extension.setActividad(actividad);
                extension = em.merge(extension);
            }
            if (otras != null) {
                Actividad oldActividadOfOtras = otras.getActividad();
                if (oldActividadOfOtras != null) {
                    oldActividadOfOtras.setOtras(null);
                    oldActividadOfOtras = em.merge(oldActividadOfOtras);
                }
                otras.setActividad(actividad);
                otras = em.merge(otras);
            }
            if (administracion != null) {
                Actividad oldActividadOfAdministracion = administracion.getActividad();
                if (oldActividadOfAdministracion != null) {
                    oldActividadOfAdministracion.setAdministracion(null);
                    oldActividadOfAdministracion = em.merge(oldActividadOfAdministracion);
                }
                administracion.setActividad(actividad);
                administracion = em.merge(administracion);
            }
            for (ActividadProfesor actividadProfesorListActividadProfesor : actividad.getActividadProfesorList()) {
                Actividad oldActividadOfActividadProfesorListActividadProfesor = actividadProfesorListActividadProfesor.getActividad();
                actividadProfesorListActividadProfesor.setActividad(actividad);
                actividadProfesorListActividadProfesor = em.merge(actividadProfesorListActividadProfesor);
                if (oldActividadOfActividadProfesorListActividadProfesor != null) {
                    oldActividadOfActividadProfesorListActividadProfesor.getActividadProfesorList().remove(actividadProfesorListActividadProfesor);
                    oldActividadOfActividadProfesorListActividadProfesor = em.merge(oldActividadOfActividadProfesorListActividadProfesor);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Actividad actividad) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Actividad persistentActividad = em.find(Actividad.class, actividad.getId());
            Investigacion investigacionOld = persistentActividad.getInvestigacion();
            Investigacion investigacionNew = actividad.getInvestigacion();
            Docencia docenciaOld = persistentActividad.getDocencia();
            Docencia docenciaNew = actividad.getDocencia();
            Extension extensionOld = persistentActividad.getExtension();
            Extension extensionNew = actividad.getExtension();
            Otras otrasOld = persistentActividad.getOtras();
            Otras otrasNew = actividad.getOtras();
            Administracion administracionOld = persistentActividad.getAdministracion();
            Administracion administracionNew = actividad.getAdministracion();
            List<ActividadProfesor> actividadProfesorListOld = persistentActividad.getActividadProfesorList();
            List<ActividadProfesor> actividadProfesorListNew = actividad.getActividadProfesorList();
            List<String> illegalOrphanMessages = null;
            if (investigacionOld != null && !investigacionOld.equals(investigacionNew)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain Investigacion " + investigacionOld + " since its actividad field is not nullable.");
            }
            if (docenciaOld != null && !docenciaOld.equals(docenciaNew)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain Docencia " + docenciaOld + " since its actividad field is not nullable.");
            }
            if (extensionOld != null && !extensionOld.equals(extensionNew)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain Extension " + extensionOld + " since its actividad field is not nullable.");
            }
            if (otrasOld != null && !otrasOld.equals(otrasNew)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain Otras " + otrasOld + " since its actividad field is not nullable.");
            }
            if (administracionOld != null && !administracionOld.equals(administracionNew)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain Administracion " + administracionOld + " since its actividad field is not nullable.");
            }
            for (ActividadProfesor actividadProfesorListOldActividadProfesor : actividadProfesorListOld) {
                if (!actividadProfesorListNew.contains(actividadProfesorListOldActividadProfesor)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain ActividadProfesor " + actividadProfesorListOldActividadProfesor + " since its actividad field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (investigacionNew != null) {
                investigacionNew = em.getReference(investigacionNew.getClass(), investigacionNew.getIdActividad());
                actividad.setInvestigacion(investigacionNew);
            }
            if (docenciaNew != null) {
                docenciaNew = em.getReference(docenciaNew.getClass(), docenciaNew.getIdActividad());
                actividad.setDocencia(docenciaNew);
            }
            if (extensionNew != null) {
                extensionNew = em.getReference(extensionNew.getClass(), extensionNew.getIdActividad());
                actividad.setExtension(extensionNew);
            }
            if (otrasNew != null) {
                otrasNew = em.getReference(otrasNew.getClass(), otrasNew.getIdActividad());
                actividad.setOtras(otrasNew);
            }
            if (administracionNew != null) {
                administracionNew = em.getReference(administracionNew.getClass(), administracionNew.getIdActividad());
                actividad.setAdministracion(administracionNew);
            }
            List<ActividadProfesor> attachedActividadProfesorListNew = new ArrayList<ActividadProfesor>();
            for (ActividadProfesor actividadProfesorListNewActividadProfesorToAttach : actividadProfesorListNew) {
                actividadProfesorListNewActividadProfesorToAttach = em.getReference(actividadProfesorListNewActividadProfesorToAttach.getClass(), actividadProfesorListNewActividadProfesorToAttach.getActividadProfesorPK());
                attachedActividadProfesorListNew.add(actividadProfesorListNewActividadProfesorToAttach);
            }
            actividadProfesorListNew = attachedActividadProfesorListNew;
            actividad.setActividadProfesorList(actividadProfesorListNew);
            actividad = em.merge(actividad);
            if (investigacionNew != null && !investigacionNew.equals(investigacionOld)) {
                Actividad oldActividadOfInvestigacion = investigacionNew.getActividad();
                if (oldActividadOfInvestigacion != null) {
                    oldActividadOfInvestigacion.setInvestigacion(null);
                    oldActividadOfInvestigacion = em.merge(oldActividadOfInvestigacion);
                }
                investigacionNew.setActividad(actividad);
                investigacionNew = em.merge(investigacionNew);
            }
            if (docenciaNew != null && !docenciaNew.equals(docenciaOld)) {
                Actividad oldActividadOfDocencia = docenciaNew.getActividad();
                if (oldActividadOfDocencia != null) {
                    oldActividadOfDocencia.setDocencia(null);
                    oldActividadOfDocencia = em.merge(oldActividadOfDocencia);
                }
                docenciaNew.setActividad(actividad);
                docenciaNew = em.merge(docenciaNew);
            }
            if (extensionNew != null && !extensionNew.equals(extensionOld)) {
                Actividad oldActividadOfExtension = extensionNew.getActividad();
                if (oldActividadOfExtension != null) {
                    oldActividadOfExtension.setExtension(null);
                    oldActividadOfExtension = em.merge(oldActividadOfExtension);
                }
                extensionNew.setActividad(actividad);
                extensionNew = em.merge(extensionNew);
            }
            if (otrasNew != null && !otrasNew.equals(otrasOld)) {
                Actividad oldActividadOfOtras = otrasNew.getActividad();
                if (oldActividadOfOtras != null) {
                    oldActividadOfOtras.setOtras(null);
                    oldActividadOfOtras = em.merge(oldActividadOfOtras);
                }
                otrasNew.setActividad(actividad);
                otrasNew = em.merge(otrasNew);
            }
            if (administracionNew != null && !administracionNew.equals(administracionOld)) {
                Actividad oldActividadOfAdministracion = administracionNew.getActividad();
                if (oldActividadOfAdministracion != null) {
                    oldActividadOfAdministracion.setAdministracion(null);
                    oldActividadOfAdministracion = em.merge(oldActividadOfAdministracion);
                }
                administracionNew.setActividad(actividad);
                administracionNew = em.merge(administracionNew);
            }
            for (ActividadProfesor actividadProfesorListNewActividadProfesor : actividadProfesorListNew) {
                if (!actividadProfesorListOld.contains(actividadProfesorListNewActividadProfesor)) {
                    Actividad oldActividadOfActividadProfesorListNewActividadProfesor = actividadProfesorListNewActividadProfesor.getActividad();
                    actividadProfesorListNewActividadProfesor.setActividad(actividad);
                    actividadProfesorListNewActividadProfesor = em.merge(actividadProfesorListNewActividadProfesor);
                    if (oldActividadOfActividadProfesorListNewActividadProfesor != null && !oldActividadOfActividadProfesorListNewActividadProfesor.equals(actividad)) {
                        oldActividadOfActividadProfesorListNewActividadProfesor.getActividadProfesorList().remove(actividadProfesorListNewActividadProfesor);
                        oldActividadOfActividadProfesorListNewActividadProfesor = em.merge(oldActividadOfActividadProfesorListNewActividadProfesor);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = actividad.getId();
                if (findActividad(id) == null) {
                    throw new NonexistentEntityException("The actividad with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Actividad actividad;
            try {
                actividad = em.getReference(Actividad.class, id);
                actividad.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The actividad with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
//            Investigacion investigacionOrphanCheck = actividad.getInvestigacion();
//            if (investigacionOrphanCheck != null) {
//                if (illegalOrphanMessages == null) {
//                    illegalOrphanMessages = new ArrayList<String>();
//                }
//                illegalOrphanMessages.add("This Actividad (" + actividad + ") cannot be destroyed since the Investigacion " + investigacionOrphanCheck + " in its investigacion field has a non-nullable actividad field.");
//            }
//            Docencia docenciaOrphanCheck = actividad.getDocencia();
//            if (docenciaOrphanCheck != null) {
//                if (illegalOrphanMessages == null) {
//                    illegalOrphanMessages = new ArrayList<String>();
//                }
//                illegalOrphanMessages.add("This Actividad (" + actividad + ") cannot be destroyed since the Docencia " + docenciaOrphanCheck + " in its docencia field has a non-nullable actividad field.");
//            }
//            Extension extensionOrphanCheck = actividad.getExtension();
//            if (extensionOrphanCheck != null) {
//                if (illegalOrphanMessages == null) {
//                    illegalOrphanMessages = new ArrayList<String>();
//                }
//                illegalOrphanMessages.add("This Actividad (" + actividad + ") cannot be destroyed since the Extension " + extensionOrphanCheck + " in its extension field has a non-nullable actividad field.");
//            }
//            Otras otrasOrphanCheck = actividad.getOtras();
//            if (otrasOrphanCheck != null) {
//                if (illegalOrphanMessages == null) {
//                    illegalOrphanMessages = new ArrayList<String>();
//                }
//                illegalOrphanMessages.add("This Actividad (" + actividad + ") cannot be destroyed since the Otras " + otrasOrphanCheck + " in its otras field has a non-nullable actividad field.");
//            }
//            Administracion administracionOrphanCheck = actividad.getAdministracion();
//            if (administracionOrphanCheck != null) {
//                if (illegalOrphanMessages == null) {
//                    illegalOrphanMessages = new ArrayList<String>();
//                }
//                illegalOrphanMessages.add("This Actividad (" + actividad + ") cannot be destroyed since the Administracion " + administracionOrphanCheck + " in its administracion field has a non-nullable actividad field.");
//            }
//            List<ActividadProfesor> actividadProfesorListOrphanCheck = actividad.getActividadProfesorList();
//            for (ActividadProfesor actividadProfesorListOrphanCheckActividadProfesor : actividadProfesorListOrphanCheck) {
//                if (illegalOrphanMessages == null) {
//                    illegalOrphanMessages = new ArrayList<String>();
//                }
//                illegalOrphanMessages.add("This Actividad (" + actividad + ") cannot be destroyed since the ActividadProfesor " + actividadProfesorListOrphanCheckActividadProfesor + " in its actividadProfesorList field has a non-nullable actividad field.");
//            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(actividad);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Actividad> findActividadEntities() {
        return findActividadEntities(true, -1, -1);
    }

    public List<Actividad> findActividadEntities(int maxResults, int firstResult) {
        return findActividadEntities(false, maxResults, firstResult);
    }

    private List<Actividad> findActividadEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Actividad.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Actividad findActividad(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Actividad.class, id);
        } finally {
            em.close();
        }
    }

    public int getActividadCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Actividad> rt = cq.from(Actividad.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }  
    
    //new methods
    public Actividad getActividadLast() {
        EntityManager em = getEntityManager();
        try {
            return (Actividad) em.createNativeQuery("Select * from actividad order by id desc limit 1", Actividad.class).getResultList().get(0);
        } finally {
            em.close();
        }
    }
    
}
