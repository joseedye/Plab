
package Test;

import DAO.*;
import DAO.Conexion;
import DTO.Profesor;
import DTO.Usuario;
import javax.persistence.EntityManagerFactory;

public class Test {
    public static void main(String[] args) throws Exception {
        
        
        

        EntityManagerFactory emf = Conexion.getConexion().getBd();
//
        //TipoUsuarioJpaController t = new TipoUsuarioJpaController(emf);
        //ActividadJpaController a = new ActividadJpaController(emf);
        UsuarioJpaController u = new UsuarioJpaController(emf);
        
        //Usuario usuario = u.findUsuario("joseeduardorm@ufps.edu.co");
        Usuario usuario = u.findUsuario("angelleonardovian@ufps.edu.co");
//        Profesor profesor = usuario.getProfesorList().get(0);
        
    //    System.out.println(t.findTipoUsuarioEntities());
       // System.out.println(u.findUsuarioEntities());
      //  System.out.println(a.findActividadEntities());

       
    }
    
}
