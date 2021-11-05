package DTO;

import DTO.Actividad;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-11T11:53:45")
@StaticMetamodel(Administracion.class)
public class Administracion_ { 

    public static volatile SingularAttribute<Administracion, Integer> idActividad;
    public static volatile SingularAttribute<Administracion, String> cargo;
    public static volatile SingularAttribute<Administracion, Integer> horasSemestre;
    public static volatile SingularAttribute<Administracion, Actividad> actividad;

}