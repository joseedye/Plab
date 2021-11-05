package DTO;

import DTO.Actividad;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-11T11:53:45")
@StaticMetamodel(Investigacion.class)
public class Investigacion_ { 

    public static volatile SingularAttribute<Investigacion, String> codigo;
    public static volatile SingularAttribute<Investigacion, String> responsabilidad;
    public static volatile SingularAttribute<Investigacion, Integer> idActividad;
    public static volatile SingularAttribute<Investigacion, String> institucion;
    public static volatile SingularAttribute<Investigacion, String> unidadInv;
    public static volatile SingularAttribute<Investigacion, Actividad> actividad;

}