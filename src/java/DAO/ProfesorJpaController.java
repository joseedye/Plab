/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.exceptions.IllegalOrphanException;
import DAO.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import DTO.Usuario;
import DTO.ActividadProfesor;
import DTO.Profesor;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Leonardo
 */
public class ProfesorJpaController implements Serializable {

    public ProfesorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Profesor profesor) {
        if (profesor.getActividadProfesorList() == null) {
            profesor.setActividadProfesorList(new ArrayList<ActividadProfesor>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario idUsuario = profesor.getIdUsuario();
            if (idUsuario != null) {
                idUsuario = em.getReference(idUsuario.getClass(), idUsuario.getId());
                profesor.setIdUsuario(idUsuario);
            }
            List<ActividadProfesor> attachedActividadProfesorList = new ArrayList<ActividadProfesor>();
            for (ActividadProfesor actividadProfesorListActividadProfesorToAttach : profesor.getActividadProfesorList()) {
                actividadProfesorListActividadProfesorToAttach = em.getReference(actividadProfesorListActividadProfesorToAttach.getClass(), actividadProfesorListActividadProfesorToAttach.getActividadProfesorPK());
                attachedActividadProfesorList.add(actividadProfesorListActividadProfesorToAttach);
            }
            profesor.setActividadProfesorList(attachedActividadProfesorList);
            em.persist(profesor);
            if (idUsuario != null) {
                idUsuario.getProfesorList().add(profesor);
                idUsuario = em.merge(idUsuario);
            }
            for (ActividadProfesor actividadProfesorListActividadProfesor : profesor.getActividadProfesorList()) {
                Profesor oldProfesorOfActividadProfesorListActividadProfesor = actividadProfesorListActividadProfesor.getProfesor();
                actividadProfesorListActividadProfesor.setProfesor(profesor);
                actividadProfesorListActividadProfesor = em.merge(actividadProfesorListActividadProfesor);
                if (oldProfesorOfActividadProfesorListActividadProfesor != null) {
                    oldProfesorOfActividadProfesorListActividadProfesor.getActividadProfesorList().remove(actividadProfesorListActividadProfesor);
                    oldProfesorOfActividadProfesorListActividadProfesor = em.merge(oldProfesorOfActividadProfesorListActividadProfesor);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Profesor profesor) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Profesor persistentProfesor = em.find(Profesor.class, profesor.getId());
            Usuario idUsuarioOld = persistentProfesor.getIdUsuario();
            Usuario idUsuarioNew = profesor.getIdUsuario();
            List<ActividadProfesor> actividadProfesorListOld = persistentProfesor.getActividadProfesorList();
            List<ActividadProfesor> actividadProfesorListNew = profesor.getActividadProfesorList();
            List<String> illegalOrphanMessages = null;
            for (ActividadProfesor actividadProfesorListOldActividadProfesor : actividadProfesorListOld) {
                if (!actividadProfesorListNew.contains(actividadProfesorListOldActividadProfesor)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain ActividadProfesor " + actividadProfesorListOldActividadProfesor + " since its profesor field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idUsuarioNew != null) {
                idUsuarioNew = em.getReference(idUsuarioNew.getClass(), idUsuarioNew.getId());
                profesor.setIdUsuario(idUsuarioNew);
            }
            List<ActividadProfesor> attachedActividadProfesorListNew = new ArrayList<ActividadProfesor>();
            for (ActividadProfesor actividadProfesorListNewActividadProfesorToAttach : actividadProfesorListNew) {
                actividadProfesorListNewActividadProfesorToAttach = em.getReference(actividadProfesorListNewActividadProfesorToAttach.getClass(), actividadProfesorListNewActividadProfesorToAttach.getActividadProfesorPK());
                attachedActividadProfesorListNew.add(actividadProfesorListNewActividadProfesorToAttach);
            }
            actividadProfesorListNew = attachedActividadProfesorListNew;
            profesor.setActividadProfesorList(actividadProfesorListNew);
            profesor = em.merge(profesor);
            if (idUsuarioOld != null && !idUsuarioOld.equals(idUsuarioNew)) {
                idUsuarioOld.getProfesorList().remove(profesor);
                idUsuarioOld = em.merge(idUsuarioOld);
            }
            if (idUsuarioNew != null && !idUsuarioNew.equals(idUsuarioOld)) {
                idUsuarioNew.getProfesorList().add(profesor);
                idUsuarioNew = em.merge(idUsuarioNew);
            }
            for (ActividadProfesor actividadProfesorListNewActividadProfesor : actividadProfesorListNew) {
                if (!actividadProfesorListOld.contains(actividadProfesorListNewActividadProfesor)) {
                    Profesor oldProfesorOfActividadProfesorListNewActividadProfesor = actividadProfesorListNewActividadProfesor.getProfesor();
                    actividadProfesorListNewActividadProfesor.setProfesor(profesor);
                    actividadProfesorListNewActividadProfesor = em.merge(actividadProfesorListNewActividadProfesor);
                    if (oldProfesorOfActividadProfesorListNewActividadProfesor != null && !oldProfesorOfActividadProfesorListNewActividadProfesor.equals(profesor)) {
                        oldProfesorOfActividadProfesorListNewActividadProfesor.getActividadProfesorList().remove(actividadProfesorListNewActividadProfesor);
                        oldProfesorOfActividadProfesorListNewActividadProfesor = em.merge(oldProfesorOfActividadProfesorListNewActividadProfesor);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = profesor.getId();
                if (findProfesor(id) == null) {
                    throw new NonexistentEntityException("The profesor with id " + id + " no longer exists.");
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
            Profesor profesor;
            try {
                profesor = em.getReference(Profesor.class, id);
                profesor.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The profesor with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<ActividadProfesor> actividadProfesorListOrphanCheck = profesor.getActividadProfesorList();
            for (ActividadProfesor actividadProfesorListOrphanCheckActividadProfesor : actividadProfesorListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Profesor (" + profesor + ") cannot be destroyed since the ActividadProfesor " + actividadProfesorListOrphanCheckActividadProfesor + " in its actividadProfesorList field has a non-nullable profesor field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Usuario idUsuario = profesor.getIdUsuario();
            if (idUsuario != null) {
                idUsuario.getProfesorList().remove(profesor);
                idUsuario = em.merge(idUsuario);
            }
            em.remove(profesor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Profesor> findProfesorEntities() {
        return findProfesorEntities(true, -1, -1);
    }

    public List<Profesor> findProfesorEntities(int maxResults, int firstResult) {
        return findProfesorEntities(false, maxResults, firstResult);
    }

    private List<Profesor> findProfesorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Profesor.class));
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

    public Profesor findProfesor(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Profesor.class, id);
        } finally {
            em.close();
        }
    }

    public int getProfesorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Profesor> rt = cq.from(Profesor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    //New Methods
    public Profesor findProfesorByUsuario(Integer idUsuario) {
        EntityManager em = getEntityManager();
        try {
            return (Profesor) em.createNativeQuery("SELECT * FROM profesor WHERE id_usuario='"+idUsuario+"'",Profesor.class).getResultList().get(0);
        } finally {
            em.close();
        }
    }
    
}
