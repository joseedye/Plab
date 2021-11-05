package DTO;

import DTO.Actividad;
import DTO.ActividadProfesorPK;
import DTO.Profesor;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-11T11:53:45")
@StaticMetamodel(ActividadProfesor.class)
public class ActividadProfesor_ { 

    public static volatile SingularAttribute<ActividadProfesor, Date> fechaIngreso;
    public static volatile SingularAttribute<ActividadProfesor, ActividadProfesorPK> actividadProfesorPK;
    public static volatile SingularAttribute<ActividadProfesor, Profesor> profesor;
    public static volatile SingularAttribute<ActividadProfesor, String> semestre;
    public static volatile SingularAttribute<ActividadProfesor, Actividad> actividad;

}