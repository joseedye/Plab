/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.exceptions.NonexistentEntityException;
import DAO.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import DTO.Actividad;
import DTO.ActividadProfesor;
import DTO.ActividadProfesorPK;
import DTO.Profesor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Leonardo
 */
public class ActividadProfesorJpaController implements Serializable {

    public ActividadProfesorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ActividadProfesor actividadProfesor) throws PreexistingEntityException, Exception {
        if (actividadProfesor.getActividadProfesorPK() == null) {
            actividadProfesor.setActividadProfesorPK(new ActividadProfesorPK());
        }
        actividadProfesor.getActividadProfesorPK().setIdProfesor(actividadProfesor.getProfesor().getId());
        actividadProfesor.getActividadProfesorPK().setIdActividad(actividadProfesor.getActividad().getId());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Actividad actividad = actividadProfesor.getActividad();
            if (actividad != null) {
                actividad = em.getReference(actividad.getClass(), actividad.getId());
                actividadProfesor.setActividad(actividad);
            }
            Profesor profesor = actividadProfesor.getProfesor();
            if (profesor != null) {
                profesor = em.getReference(profesor.getClass(), profesor.getId());
                actividadProfesor.setProfesor(profesor);
            }
            em.persist(actividadProfesor);
            if (actividad != null) {
                actividad.getActividadProfesorList().add(actividadProfesor);
                actividad = em.merge(actividad);
            }
            if (profesor != null) {
                profesor.getActividadProfesorList().add(actividadProfesor);
                profesor = em.merge(profesor);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findActividadProfesor(actividadProfesor.getActividadProfesorPK()) != null) {
                throw new PreexistingEntityException("ActividadProfesor " + actividadProfesor + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ActividadProfesor actividadProfesor) throws NonexistentEntityException, Exception {
        actividadProfesor.getActividadProfesorPK().setIdProfesor(actividadProfesor.getProfesor().getId());
        actividadProfesor.getActividadProfesorPK().setIdActividad(actividadProfesor.getActividad().getId());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ActividadProfesor persistentActividadProfesor = em.find(ActividadProfesor.class, actividadProfesor.getActividadProfesorPK());
            Actividad actividadOld = persistentActividadProfesor.getActividad();
            Actividad actividadNew = actividadProfesor.getActividad();
            Profesor profesorOld = persistentActividadProfesor.getProfesor();
            Profesor profesorNew = actividadProfesor.getProfesor();
            if (actividadNew != null) {
                actividadNew = em.getReference(actividadNew.getClass(), actividadNew.getId());
                actividadProfesor.setActividad(actividadNew);
            }
            if (profesorNew != null) {
                profesorNew = em.getReference(profesorNew.getClass(), profesorNew.getId());
                actividadProfesor.setProfesor(profesorNew);
            }
            actividadProfesor = em.merge(actividadProfesor);
            if (actividadOld != null && !actividadOld.equals(actividadNew)) {
                actividadOld.getActividadProfesorList().remove(actividadProfesor);
                actividadOld = em.merge(actividadOld);
            }
            if (actividadNew != null && !actividadNew.equals(actividadOld)) {
                actividadNew.getActividadProfesorList().add(actividadProfesor);
                actividadNew = em.merge(actividadNew);
            }
            if (profesorOld != null && !profesorOld.equals(profesorNew)) {
                profesorOld.getActividadProfesorList().remove(actividadProfesor);
                profesorOld = em.merge(profesorOld);
            }
            if (profesorNew != null && !profesorNew.equals(profesorOld)) {
                profesorNew.getActividadProfesorList().add(actividadProfesor);
                profesorNew = em.merge(profesorNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                ActividadProfesorPK id = actividadProfesor.getActividadProfesorPK();
                if (findActividadProfesor(id) == null) {
                    throw new NonexistentEntityException("The actividadProfesor with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(ActividadProfesorPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ActividadProfesor actividadProfesor;
            try {
                actividadProfesor = em.getReference(ActividadProfesor.class, id);
                actividadProfesor.getActividadProfesorPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The actividadProfesor with id " + id + " no longer exists.", enfe);
            }
            Actividad actividad = actividadProfesor.getActividad();
            if (actividad != null) {
                actividad.getActividadProfesorList().remove(actividadProfesor);
                actividad = em.merge(actividad);
            }
            Profesor profesor = actividadProfesor.getProfesor();
            if (profesor != null) {
                profesor.getActividadProfesorList().remove(actividadProfesor);
                profesor = em.merge(profesor);
            }
            em.remove(actividadProfesor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ActividadProfesor> findActividadProfesorEntities() {
        return findActividadProfesorEntities(true, -1, -1);
    }

    public List<ActividadProfesor> findActividadProfesorEntities(int maxResults, int firstResult) {
        return findActividadProfesorEntities(false, maxResults, firstResult);
    }

    private List<ActividadProfesor> findActividadProfesorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ActividadProfesor.class));
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

    public ActividadProfesor findActividadProfesor(ActividadProfesorPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ActividadProfesor.class, id);
        } finally {
            em.close();
        }
    }

    public int getActividadProfesorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ActividadProfesor> rt = cq.from(ActividadProfesor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
