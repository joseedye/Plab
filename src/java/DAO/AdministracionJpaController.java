/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.exceptions.IllegalOrphanException;
import DAO.exceptions.NonexistentEntityException;
import DAO.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import DTO.Actividad;
import DTO.Administracion;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Leonardo
 */
public class AdministracionJpaController implements Serializable {

    public AdministracionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Administracion administracion) throws IllegalOrphanException, PreexistingEntityException, Exception {
        List<String> illegalOrphanMessages = null;
        Actividad actividadOrphanCheck = administracion.getActividad();
        if (actividadOrphanCheck != null) {
            Administracion oldAdministracionOfActividad = actividadOrphanCheck.getAdministracion();
            if (oldAdministracionOfActividad != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("The Actividad " + actividadOrphanCheck + " already has an item of type Administracion whose actividad column cannot be null. Please make another selection for the actividad field.");
            }
        }
        if (illegalOrphanMessages != null) {
            throw new IllegalOrphanException(illegalOrphanMessages);
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Actividad actividad = administracion.getActividad();
            if (actividad != null) {
                actividad = em.getReference(actividad.getClass(), actividad.getId());
                administracion.setActividad(actividad);
            }
            em.persist(administracion);
            if (actividad != null) {
                actividad.setAdministracion(administracion);
                actividad = em.merge(actividad);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAdministracion(administracion.getIdActividad()) != null) {
                throw new PreexistingEntityException("Administracion " + administracion + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Administracion administracion) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Administracion persistentAdministracion = em.find(Administracion.class, administracion.getIdActividad());
            Actividad actividadOld = persistentAdministracion.getActividad();
            Actividad actividadNew = administracion.getActividad();
            List<String> illegalOrphanMessages = null;
            if (actividadNew != null && !actividadNew.equals(actividadOld)) {
                Administracion oldAdministracionOfActividad = actividadNew.getAdministracion();
                if (oldAdministracionOfActividad != null) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("The Actividad " + actividadNew + " already has an item of type Administracion whose actividad column cannot be null. Please make another selection for the actividad field.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (actividadNew != null) {
                actividadNew = em.getReference(actividadNew.getClass(), actividadNew.getId());
                administracion.setActividad(actividadNew);
            }
            administracion = em.merge(administracion);
            if (actividadOld != null && !actividadOld.equals(actividadNew)) {
                actividadOld.setAdministracion(null);
                actividadOld = em.merge(actividadOld);
            }
            if (actividadNew != null && !actividadNew.equals(actividadOld)) {
                actividadNew.setAdministracion(administracion);
                actividadNew = em.merge(actividadNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = administracion.getIdActividad();
                if (findAdministracion(id) == null) {
                    throw new NonexistentEntityException("The administracion with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Administracion administracion;
            try {
                administracion = em.getReference(Administracion.class, id);
                administracion.getIdActividad();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The administracion with id " + id + " no longer exists.", enfe);
            }
            Actividad actividad = administracion.getActividad();
            if (actividad != null) {
                actividad.setAdministracion(null);
                actividad = em.merge(actividad);
            }
            em.remove(administracion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Administracion> findAdministracionEntities() {
        return findAdministracionEntities(true, -1, -1);
    }

    public List<Administracion> findAdministracionEntities(int maxResults, int firstResult) {
        return findAdministracionEntities(false, maxResults, firstResult);
    }

    private List<Administracion> findAdministracionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Administracion.class));
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

    public Administracion findAdministracion(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Administracion.class, id);
        } finally {
            em.close();
        }
    }

    public int getAdministracionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Administracion> rt = cq.from(Administracion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
