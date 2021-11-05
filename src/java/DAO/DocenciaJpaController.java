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
import DTO.Docencia;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Leonardo
 */
public class DocenciaJpaController implements Serializable {

    public DocenciaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Docencia docencia) throws IllegalOrphanException, PreexistingEntityException, Exception {
        List<String> illegalOrphanMessages = null;
        Actividad actividadOrphanCheck = docencia.getActividad();
        if (actividadOrphanCheck != null) {
            Docencia oldDocenciaOfActividad = actividadOrphanCheck.getDocencia();
            if (oldDocenciaOfActividad != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("The Actividad " + actividadOrphanCheck + " already has an item of type Docencia whose actividad column cannot be null. Please make another selection for the actividad field.");
            }
        }
        if (illegalOrphanMessages != null) {
            throw new IllegalOrphanException(illegalOrphanMessages);
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Actividad actividad = docencia.getActividad();
            if (actividad != null) {
                actividad = em.getReference(actividad.getClass(), actividad.getId());
                docencia.setActividad(actividad);
            }
            em.persist(docencia);
            if (actividad != null) {
                actividad.setDocencia(docencia);
                actividad = em.merge(actividad);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDocencia(docencia.getIdActividad()) != null) {
                throw new PreexistingEntityException("Docencia " + docencia + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Docencia docencia) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Docencia persistentDocencia = em.find(Docencia.class, docencia.getIdActividad());
            Actividad actividadOld = persistentDocencia.getActividad();
            Actividad actividadNew = docencia.getActividad();
            List<String> illegalOrphanMessages = null;
            if (actividadNew != null && !actividadNew.equals(actividadOld)) {
                Docencia oldDocenciaOfActividad = actividadNew.getDocencia();
                if (oldDocenciaOfActividad != null) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("The Actividad " + actividadNew + " already has an item of type Docencia whose actividad column cannot be null. Please make another selection for the actividad field.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (actividadNew != null) {
                actividadNew = em.getReference(actividadNew.getClass(), actividadNew.getId());
                docencia.setActividad(actividadNew);
            }
            docencia = em.merge(docencia);
            if (actividadOld != null && !actividadOld.equals(actividadNew)) {
                actividadOld.setDocencia(null);
                actividadOld = em.merge(actividadOld);
            }
            if (actividadNew != null && !actividadNew.equals(actividadOld)) {
                actividadNew.setDocencia(docencia);
                actividadNew = em.merge(actividadNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = docencia.getIdActividad();
                if (findDocencia(id) == null) {
                    throw new NonexistentEntityException("The docencia with id " + id + " no longer exists.");
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
            Docencia docencia;
            try {
                docencia = em.getReference(Docencia.class, id);
                docencia.getIdActividad();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The docencia with id " + id + " no longer exists.", enfe);
            }
            Actividad actividad = docencia.getActividad();
            if (actividad != null) {
                actividad.setDocencia(null);
                actividad = em.merge(actividad);
            }
            em.remove(docencia);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Docencia> findDocenciaEntities() {
        return findDocenciaEntities(true, -1, -1);
    }

    public List<Docencia> findDocenciaEntities(int maxResults, int firstResult) {
        return findDocenciaEntities(false, maxResults, firstResult);
    }

    private List<Docencia> findDocenciaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Docencia.class));
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

    public Docencia findDocencia(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Docencia.class, id);
        } finally {
            em.close();
        }
    }

    public int getDocenciaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Docencia> rt = cq.from(Docencia.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
