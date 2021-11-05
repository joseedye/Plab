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
import DTO.Otras;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Leonardo
 */
public class OtrasJpaController implements Serializable {

    public OtrasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Otras otras) throws IllegalOrphanException, PreexistingEntityException, Exception {
        List<String> illegalOrphanMessages = null;
        Actividad actividadOrphanCheck = otras.getActividad();
        if (actividadOrphanCheck != null) {
            Otras oldOtrasOfActividad = actividadOrphanCheck.getOtras();
            if (oldOtrasOfActividad != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("The Actividad " + actividadOrphanCheck + " already has an item of type Otras whose actividad column cannot be null. Please make another selection for the actividad field.");
            }
        }
        if (illegalOrphanMessages != null) {
            throw new IllegalOrphanException(illegalOrphanMessages);
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Actividad actividad = otras.getActividad();
            if (actividad != null) {
                actividad = em.getReference(actividad.getClass(), actividad.getId());
                otras.setActividad(actividad);
            }
            em.persist(otras);
            if (actividad != null) {
                actividad.setOtras(otras);
                actividad = em.merge(actividad);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findOtras(otras.getIdActividad()) != null) {
                throw new PreexistingEntityException("Otras " + otras + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Otras otras) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Otras persistentOtras = em.find(Otras.class, otras.getIdActividad());
            Actividad actividadOld = persistentOtras.getActividad();
            Actividad actividadNew = otras.getActividad();
            List<String> illegalOrphanMessages = null;
            if (actividadNew != null && !actividadNew.equals(actividadOld)) {
                Otras oldOtrasOfActividad = actividadNew.getOtras();
                if (oldOtrasOfActividad != null) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("The Actividad " + actividadNew + " already has an item of type Otras whose actividad column cannot be null. Please make another selection for the actividad field.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (actividadNew != null) {
                actividadNew = em.getReference(actividadNew.getClass(), actividadNew.getId());
                otras.setActividad(actividadNew);
            }
            otras = em.merge(otras);
            if (actividadOld != null && !actividadOld.equals(actividadNew)) {
                actividadOld.setOtras(null);
                actividadOld = em.merge(actividadOld);
            }
            if (actividadNew != null && !actividadNew.equals(actividadOld)) {
                actividadNew.setOtras(otras);
                actividadNew = em.merge(actividadNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = otras.getIdActividad();
                if (findOtras(id) == null) {
                    throw new NonexistentEntityException("The otras with id " + id + " no longer exists.");
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
            Otras otras;
            try {
                otras = em.getReference(Otras.class, id);
                otras.getIdActividad();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The otras with id " + id + " no longer exists.", enfe);
            }
            Actividad actividad = otras.getActividad();
            if (actividad != null) {
                actividad.setOtras(null);
                actividad = em.merge(actividad);
            }
            em.remove(otras);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Otras> findOtrasEntities() {
        return findOtrasEntities(true, -1, -1);
    }

    public List<Otras> findOtrasEntities(int maxResults, int firstResult) {
        return findOtrasEntities(false, maxResults, firstResult);
    }

    private List<Otras> findOtrasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Otras.class));
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

    public Otras findOtras(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Otras.class, id);
        } finally {
            em.close();
        }
    }

    public int getOtrasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Otras> rt = cq.from(Otras.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
