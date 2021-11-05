package DTO;

import DTO.ActividadProfesor;
import DTO.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-11T11:53:45")
@StaticMetamodel(Profesor.class)
public class Profesor_ { 

    public static volatile SingularAttribute<Profesor, Integer> codigo;
    public static volatile SingularAttribute<Profesor, Date> fechaInicio;
    public static volatile ListAttribute<Profesor, ActividadProfesor> actividadProfesorList;
    public static volatile SingularAttribute<Profesor, Usuario> idUsuario;
    public static volatile SingularAttribute<Profesor, String> vinculacion;
    public static volatile SingularAttribute<Profesor, Integer> id;
    public static volatile SingularAttribute<Profesor, Integer> horasSemana;

}