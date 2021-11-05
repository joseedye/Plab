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
import DTO.Investigacion;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Leonardo
 */
public class InvestigacionJpaController implements Serializable {

    public InvestigacionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Investigacion investigacion) throws IllegalOrphanException, PreexistingEntityException, Exception {
        List<String> illegalOrphanMessages = null;
        Actividad actividadOrphanCheck = investigacion.getActividad();
        if (actividadOrphanCheck != null) {
            Investigacion oldInvestigacionOfActividad = actividadOrphanCheck.getInvestigacion();
            if (oldInvestigacionOfActividad != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("The Actividad " + actividadOrphanCheck + " already has an item of type Investigacion whose actividad column cannot be null. Please make another selection for the actividad field.");
            }
        }
        if (illegalOrphanMessages != null) {
            throw new IllegalOrphanException(illegalOrphanMessages);
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Actividad actividad = investigacion.getActividad();
            if (actividad != null) {
                actividad = em.getReference(actividad.getClass(), actividad.getId());
                investigacion.setActividad(actividad);
            }
            em.persist(investigacion);
            if (actividad != null) {
                actividad.setInvestigacion(investigacion);
                actividad = em.merge(actividad);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findInvestigacion(investigacion.getIdActividad()) != null) {
                throw new PreexistingEntityException("Investigacion " + investigacion + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Investigacion investigacion) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Investigacion persistentInvestigacion = em.find(Investigacion.class, investigacion.getIdActividad());
            Actividad actividadOld = persistentInvestigacion.getActividad();
            Actividad actividadNew = investigacion.getActividad();
            List<String> illegalOrphanMessages = null;
            if (actividadNew != null && !actividadNew.equals(actividadOld)) {
                Investigacion oldInvestigacionOfActividad = actividadNew.getInvestigacion();
                if (oldInvestigacionOfActividad != null) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("The Actividad " + actividadNew + " already has an item of type Investigacion whose actividad column cannot be null. Please make another selection for the actividad field.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (actividadNew != null) {
                actividadNew = em.getReference(actividadNew.getClass(), actividadNew.getId());
                investigacion.setActividad(actividadNew);
            }
            investigacion = em.merge(investigacion);
            if (actividadOld != null && !actividadOld.equals(actividadNew)) {
                actividadOld.setInvestigacion(null);
                actividadOld = em.merge(actividadOld);
            }
            if (actividadNew != null && !actividadNew.equals(actividadOld)) {
                actividadNew.setInvestigacion(investigacion);
                actividadNew = em.merge(actividadNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = investigacion.getIdActividad();
                if (findInvestigacion(id) == null) {
                    throw new NonexistentEntityException("The investigacion with id " + id + " no longer exists.");
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
            Investigacion investigacion;
            try {
                investigacion = em.getReference(Investigacion.class, id);
                investigacion.getIdActividad();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The investigacion with id " + id + " no longer exists.", enfe);
            }
            Actividad actividad = investigacion.getActividad();
            if (actividad != null) {
                actividad.setInvestigacion(null);
                actividad = em.merge(actividad);
            }
            em.remove(investigacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Investigacion> findInvestigacionEntities() {
        return findInvestigacionEntities(true, -1, -1);
    }

    public List<Investigacion> findInvestigacionEntities(int maxResults, int firstResult) {
        return findInvestigacionEntities(false, maxResults, firstResult);
    }

    private List<Investigacion> findInvestigacionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Investigacion.class));
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

    public Investigacion findInvestigacion(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Investigacion.class, id);
        } finally {
            em.close();
        }
    }

    public int getInvestigacionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Investigacion> rt = cq.from(Investigacion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
