package DTO;

import DTO.Actividad;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-11T11:53:45")
@StaticMetamodel(Docencia.class)
public class Docencia_ { 

    public static volatile SingularAttribute<Docencia, String> codigo;
    public static volatile SingularAttribute<Docencia, Integer> idActividad;
    public static volatile SingularAttribute<Docencia, Integer> hTP;
    public static volatile SingularAttribute<Docencia, String> grupo;
    public static volatile SingularAttribute<Docencia, Integer> hP;
    public static volatile SingularAttribute<Docencia, Integer> creditos;
    public static volatile SingularAttribute<Docencia, Integer> horasSemestre;
    public static volatile SingularAttribute<Docencia, Integer> hT;
    public static volatile SingularAttribute<Docencia, String> nivel;
    public static volatile SingularAttribute<Docencia, Integer> numEstudiantes;
    public static volatile SingularAttribute<Docencia, Actividad> actividad;

}