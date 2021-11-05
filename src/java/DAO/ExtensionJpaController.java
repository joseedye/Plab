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
import DTO.Extension;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Leonardo
 */
public class ExtensionJpaController implements Serializable {

    public ExtensionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Extension extension) throws IllegalOrphanException, PreexistingEntityException, Exception {
        List<String> illegalOrphanMessages = null;
        Actividad actividadOrphanCheck = extension.getActividad();
        if (actividadOrphanCheck != null) {
            Extension oldExtensionOfActividad = actividadOrphanCheck.getExtension();
            if (oldExtensionOfActividad != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("The Actividad " + actividadOrphanCheck + " already has an item of type Extension whose actividad column cannot be null. Please make another selection for the actividad field.");
            }
        }
        if (illegalOrphanMessages != null) {
            throw new IllegalOrphanException(illegalOrphanMessages);
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Actividad actividad = extension.getActividad();
            if (actividad != null) {
                actividad = em.getReference(actividad.getClass(), actividad.getId());
                extension.setActividad(actividad);
            }
            em.persist(extension);
            if (actividad != null) {
                actividad.setExtension(extension);
                actividad = em.merge(actividad);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findExtension(extension.getIdActividad()) != null) {
                throw new PreexistingEntityException("Extension " + extension + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Extension extension) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Extension persistentExtension = em.find(Extension.class, extension.getIdActividad());
            Actividad actividadOld = persistentExtension.getActividad();
            Actividad actividadNew = extension.getActividad();
            List<String> illegalOrphanMessages = null;
            if (actividadNew != null && !actividadNew.equals(actividadOld)) {
                Extension oldExtensionOfActividad = actividadNew.getExtension();
                if (oldExtensionOfActividad != null) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("The Actividad " + actividadNew + " already has an item of type Extension whose actividad column cannot be null. Please make another selection for the actividad field.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (actividadNew != null) {
                actividadNew = em.getReference(actividadNew.getClass(), actividadNew.getId());
                extension.setActividad(actividadNew);
            }
            extension = em.merge(extension);
            if (actividadOld != null && !actividadOld.equals(actividadNew)) {
                actividadOld.setExtension(null);
                actividadOld = em.merge(actividadOld);
            }
            if (actividadNew != null && !actividadNew.equals(actividadOld)) {
                actividadNew.setExtension(extension);
                actividadNew = em.merge(actividadNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = extension.getIdActividad();
                if (findExtension(id) == null) {
                    throw new NonexistentEntityException("The extension with id " + id + " no longer exists.");
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
            Extension extension;
            try {
                extension = em.getReference(Extension.class, id);
                extension.getIdActividad();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The extension with id " + id + " no longer exists.", enfe);
            }
            Actividad actividad = extension.getActividad();
            if (actividad != null) {
                actividad.setExtension(null);
                actividad = em.merge(actividad);
            }
            em.remove(extension);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Extension> findExtensionEntities() {
        return findExtensionEntities(true, -1, -1);
    }

    public List<Extension> findExtensionEntities(int maxResults, int firstResult) {
        return findExtensionEntities(false, maxResults, firstResult);
    }

    private List<Extension> findExtensionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Extension.class));
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

    public Extension findExtension(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Extension.class, id);
        } finally {
            em.close();
        }
    }

    public int getExtensionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Extension> rt = cq.from(Extension.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
