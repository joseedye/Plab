package DTO;

import DTO.Administrador;
import DTO.Profesor;
import DTO.TipoUsuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-11T11:53:45")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile ListAttribute<Usuario, Administrador> administradorList;
    public static volatile SingularAttribute<Usuario, TipoUsuario> idTipoUsuario;
    public static volatile SingularAttribute<Usuario, String> foto;
    public static volatile SingularAttribute<Usuario, String> correo;
    public static volatile SingularAttribute<Usuario, Date> lastAccess;
    public static volatile SingularAttribute<Usuario, Integer> id;
    public static volatile ListAttribute<Usuario, Profesor> profesorList;
    public static volatile SingularAttribute<Usuario, String> nombres;
    public static volatile SingularAttribute<Usuario, String> contraseña;
    public static volatile SingularAttribute<Usuario, Boolean> status;

}