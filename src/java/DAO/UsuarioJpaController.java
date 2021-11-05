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
import DTO.TipoUsuario;
import DTO.Administrador;
import java.util.ArrayList;
import java.util.List;
import DTO.Profesor;
import DTO.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Leonardo
 */
public class UsuarioJpaController implements Serializable {

    public UsuarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Usuario usuario) {
        if (usuario.getAdministradorList() == null) {
            usuario.setAdministradorList(new ArrayList<Administrador>());
        }
        if (usuario.getProfesorList() == null) {
            usuario.setProfesorList(new ArrayList<Profesor>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TipoUsuario idTipoUsuario = usuario.getIdTipoUsuario();
            if (idTipoUsuario != null) {
                idTipoUsuario = em.getReference(idTipoUsuario.getClass(), idTipoUsuario.getIdTipoUsuario());
                usuario.setIdTipoUsuario(idTipoUsuario);
            }
            List<Administrador> attachedAdministradorList = new ArrayList<Administrador>();
            for (Administrador administradorListAdministradorToAttach : usuario.getAdministradorList()) {
                administradorListAdministradorToAttach = em.getReference(administradorListAdministradorToAttach.getClass(), administradorListAdministradorToAttach.getId());
                attachedAdministradorList.add(administradorListAdministradorToAttach);
            }
            usuario.setAdministradorList(attachedAdministradorList);
            List<Profesor> attachedProfesorList = new ArrayList<Profesor>();
            for (Profesor profesorListProfesorToAttach : usuario.getProfesorList()) {
                profesorListProfesorToAttach = em.getReference(profesorListProfesorToAttach.getClass(), profesorListProfesorToAttach.getId());
                attachedProfesorList.add(profesorListProfesorToAttach);
            }
            usuario.setProfesorList(attachedProfesorList);
            em.persist(usuario);
            if (idTipoUsuario != null) {
                idTipoUsuario.getUsuarioList().add(usuario);
                idTipoUsuario = em.merge(idTipoUsuario);
            }
            for (Administrador administradorListAdministrador : usuario.getAdministradorList()) {
                Usuario oldIdUsuarioOfAdministradorListAdministrador = administradorListAdministrador.getIdUsuario();
                administradorListAdministrador.setIdUsuario(usuario);
                administradorListAdministrador = em.merge(administradorListAdministrador);
                if (oldIdUsuarioOfAdministradorListAdministrador != null) {
                    oldIdUsuarioOfAdministradorListAdministrador.getAdministradorList().remove(administradorListAdministrador);
                    oldIdUsuarioOfAdministradorListAdministrador = em.merge(oldIdUsuarioOfAdministradorListAdministrador);
                }
            }
            for (Profesor profesorListProfesor : usuario.getProfesorList()) {
                Usuario oldIdUsuarioOfProfesorListProfesor = profesorListProfesor.getIdUsuario();
                profesorListProfesor.setIdUsuario(usuario);
                profesorListProfesor = em.merge(profesorListProfesor);
                if (oldIdUsuarioOfProfesorListProfesor != null) {
                    oldIdUsuarioOfProfesorListProfesor.getProfesorList().remove(profesorListProfesor);
                    oldIdUsuarioOfProfesorListProfesor = em.merge(oldIdUsuarioOfProfesorListProfesor);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Usuario usuario) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario persistentUsuario = em.find(Usuario.class, usuario.getId());
            TipoUsuario idTipoUsuarioOld = persistentUsuario.getIdTipoUsuario();
            TipoUsuario idTipoUsuarioNew = usuario.getIdTipoUsuario();
            List<Administrador> administradorListOld = persistentUsuario.getAdministradorList();
            List<Administrador> administradorListNew = usuario.getAdministradorList();
            List<Profesor> profesorListOld = persistentUsuario.getProfesorList();
            List<Profesor> profesorListNew = usuario.getProfesorList();
            List<String> illegalOrphanMessages = null;
            for (Administrador administradorListOldAdministrador : administradorListOld) {
                if (!administradorListNew.contains(administradorListOldAdministrador)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Administrador " + administradorListOldAdministrador + " since its idUsuario field is not nullable.");
                }
            }
            for (Profesor profesorListOldProfesor : profesorListOld) {
                if (!profesorListNew.contains(profesorListOldProfesor)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Profesor " + profesorListOldProfesor + " since its idUsuario field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idTipoUsuarioNew != null) {
                idTipoUsuarioNew = em.getReference(idTipoUsuarioNew.getClass(), idTipoUsuarioNew.getIdTipoUsuario());
                usuario.setIdTipoUsuario(idTipoUsuarioNew);
            }
            List<Administrador> attachedAdministradorListNew = new ArrayList<Administrador>();
            for (Administrador administradorListNewAdministradorToAttach : administradorListNew) {
                administradorListNewAdministradorToAttach = em.getReference(administradorListNewAdministradorToAttach.getClass(), administradorListNewAdministradorToAttach.getId());
                attachedAdministradorListNew.add(administradorListNewAdministradorToAttach);
            }
            administradorListNew = attachedAdministradorListNew;
            usuario.setAdministradorList(administradorListNew);
            List<Profesor> attachedProfesorListNew = new ArrayList<Profesor>();
            for (Profesor profesorListNewProfesorToAttach : profesorListNew) {
                profesorListNewProfesorToAttach = em.getReference(profesorListNewProfesorToAttach.getClass(), profesorListNewProfesorToAttach.getId());
                attachedProfesorListNew.add(profesorListNewProfesorToAttach);
            }
            profesorListNew = attachedProfesorListNew;
            usuario.setProfesorList(profesorListNew);
            usuario = em.merge(usuario);
            if (idTipoUsuarioOld != null && !idTipoUsuarioOld.equals(idTipoUsuarioNew)) {
                idTipoUsuarioOld.getUsuarioList().remove(usuario);
                idTipoUsuarioOld = em.merge(idTipoUsuarioOld);
            }
            if (idTipoUsuarioNew != null && !idTipoUsuarioNew.equals(idTipoUsuarioOld)) {
                idTipoUsuarioNew.getUsuarioList().add(usuario);
                idTipoUsuarioNew = em.merge(idTipoUsuarioNew);
            }
            for (Administrador administradorListNewAdministrador : administradorListNew) {
                if (!administradorListOld.contains(administradorListNewAdministrador)) {
                    Usuario oldIdUsuarioOfAdministradorListNewAdministrador = administradorListNewAdministrador.getIdUsuario();
                    administradorListNewAdministrador.setIdUsuario(usuario);
                    administradorListNewAdministrador = em.merge(administradorListNewAdministrador);
                    if (oldIdUsuarioOfAdministradorListNewAdministrador != null && !oldIdUsuarioOfAdministradorListNewAdministrador.equals(usuario)) {
                        oldIdUsuarioOfAdministradorListNewAdministrador.getAdministradorList().remove(administradorListNewAdministrador);
                        oldIdUsuarioOfAdministradorListNewAdministrador = em.merge(oldIdUsuarioOfAdministradorListNewAdministrador);
                    }
                }
            }
            for (Profesor profesorListNewProfesor : profesorListNew) {
                if (!profesorListOld.contains(profesorListNewProfesor)) {
                    Usuario oldIdUsuarioOfProfesorListNewProfesor = profesorListNewProfesor.getIdUsuario();
                    profesorListNewProfesor.setIdUsuario(usuario);
                    profesorListNewProfesor = em.merge(profesorListNewProfesor);
                    if (oldIdUsuarioOfProfesorListNewProfesor != null && !oldIdUsuarioOfProfesorListNewProfesor.equals(usuario)) {
                        oldIdUsuarioOfProfesorListNewProfesor.getProfesorList().remove(profesorListNewProfesor);
                        oldIdUsuarioOfProfesorListNewProfesor = em.merge(oldIdUsuarioOfProfesorListNewProfesor);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = usuario.getId();
                if (findUsuario(id) == null) {
                    throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.");
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
            Usuario usuario;
            try {
                usuario = em.getReference(Usuario.class, id);
                usuario.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Administrador> administradorListOrphanCheck = usuario.getAdministradorList();
            for (Administrador administradorListOrphanCheckAdministrador : administradorListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Usuario (" + usuario + ") cannot be destroyed since the Administrador " + administradorListOrphanCheckAdministrador + " in its administradorList field has a non-nullable idUsuario field.");
            }
            List<Profesor> profesorListOrphanCheck = usuario.getProfesorList();
            for (Profesor profesorListOrphanCheckProfesor : profesorListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Usuario (" + usuario + ") cannot be destroyed since the Profesor " + profesorListOrphanCheckProfesor + " in its profesorList field has a non-nullable idUsuario field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            TipoUsuario idTipoUsuario = usuario.getIdTipoUsuario();
            if (idTipoUsuario != null) {
                idTipoUsuario.getUsuarioList().remove(usuario);
                idTipoUsuario = em.merge(idTipoUsuario);
            }
            em.remove(usuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Usuario> findUsuarioEntities() {
        return findUsuarioEntities(true, -1, -1);
    }

    public List<Usuario> findUsuarioEntities(int maxResults, int firstResult) {
        return findUsuarioEntities(false, maxResults, firstResult);
    }

    private List<Usuario> findUsuarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuario.class));
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

    public Usuario findUsuario(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuario.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuario> rt = cq.from(Usuario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    //New Methods
    public Usuario findUsuario(String user) {
        EntityManager em = getEntityManager();
        try {
            List<Usuario> listUsuarios = em.createNamedQuery("Usuario.findByCorreo", Usuario.class).setParameter("correo", user).getResultList();

            if (listUsuarios.isEmpty()) {
                return null;
            } else {
                return listUsuarios.get(0);
            }
        } finally {
            em.close();
        }
    }
	
	public Usuario autenticacion(Usuario usuario) {
        Usuario usuarioBD = findUsuario(usuario.getCorreo());
        String passEncrip = DigestUtils.sha1Hex(usuario.getContraseña());
        boolean isValido = usuarioBD != null ? (usuarioBD.getContraseña().equals(passEncrip)) && usuarioBD.getStatus() : false;
        return isValido ? usuarioBD : null;
    }
    
    public Usuario autenticacionGoogle(Usuario usuario) {
        Usuario usuarioBD = findUsuario(usuario.getCorreo());
        boolean isValido = usuarioBD != null ? usuarioBD.getStatus() : false;        
        return isValido ? usuarioBD : null;
    }
    
    public Usuario findUsuarioByEmail(String correo) {
        EntityManager em = getEntityManager();
        try {
            return (Usuario) em.createNamedQuery("Usuario.findByCorreo", Usuario.class).setParameter("correo", correo).getResultList().get(0);
        } finally {
            em.close();
        }
    }
    
}
