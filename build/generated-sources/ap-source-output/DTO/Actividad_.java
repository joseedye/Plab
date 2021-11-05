package DTO;

import DTO.ActividadProfesor;
import DTO.Administracion;
import DTO.Docencia;
import DTO.Extension;
import DTO.Investigacion;
import DTO.Otras;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-11T11:53:45")
@StaticMetamodel(Actividad.class)
public class Actividad_ { 

    public static volatile SingularAttribute<Actividad, Investigacion> investigacion;
    public static volatile SingularAttribute<Actividad, Docencia> docencia;
    public static volatile SingularAttribute<Actividad, Extension> extension;
    public static volatile ListAttribute<Actividad, ActividadProfesor> actividadProfesorList;
    public static volatile SingularAttribute<Actividad, Integer> id;
    public static volatile SingularAttribute<Actividad, Integer> horasSemana;
    public static volatile SingularAttribute<Actividad, String> nombre;
    public static volatile SingularAttribute<Actividad, Otras> otras;
    public static volatile SingularAttribute<Actividad, Administracion> administracion;

}