package Util;

import DTO.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public final class Utileria {

    private static String dateToString(Date date) {
        if (date == null) {
            return null;
        }

        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        return formato.format(date);
    }

    public static Map<String, String> usuarioToMap(Usuario user) {
        Map<String, String> map = new HashMap<>();
        map.put("idUsuario", user.getId().toString());
        map.put("foto", user.getFoto());
        map.put("fecLasAccess", dateToString(user.getLastAccess()));
        map.put("TipoUsuario", user.getIdTipoUsuario().getDesTipoUsuario()); 
        map.put("nombres", user.getNombres());
        map.put("email", user.getCorreo());
        map.put("activo", user.getStatus() + "");
        map.put("contra", user.getContraseña());

        return map;
    }
    
    public static Map<String, String> docenciaToMap(Docencia docencia, Actividad actividad) {
        Map<String, String> map = new HashMap<>();
        map.put("id", String.valueOf(actividad.getId()));
        map.put("nombre", actividad.getNombre());
        map.put("hsemana", String.valueOf(actividad.getHorasSemana()));
        
        map.put("codigo", docencia.getCodigo());
        map.put("grupo", docencia.getGrupo());
        map.put("creditos", docencia.getCreditos()+"");
        map.put("nivel", docencia.getNivel());
        map.put("nestudiantes", docencia.getNumEstudiantes()+"");
        map.put("hsemestre", docencia.getHorasSemestre()+"");
        map.put("hp", docencia.getHP()+"");
        map.put("htp", docencia.getHTP()+"");
        map.put("ht", docencia.getHT()+"");
        return map;
    }
    
    public static Map<String, String> administracionToMap(Administracion administracion, Actividad actividad) {
        Map<String, String> map = new HashMap<>();
        map.put("id", String.valueOf(actividad.getId()));
        map.put("nombre", actividad.getNombre());
        map.put("hsemana", String.valueOf(actividad.getHorasSemana()));
        
        map.put("cargo", administracion.getCargo());
        map.put("hsemestre", administracion.getHorasSemestre()+"");
        return map;
    }
    
    public static Map<String, String> extensionToMap(Extension extension, Actividad actividad) {
        Map<String, String> map = new HashMap<>();
        map.put("id", String.valueOf(actividad.getId()));
        map.put("nombre", actividad.getNombre());
        map.put("hsemana", String.valueOf(actividad.getHorasSemana()));
                
        map.put("responsabilidades", extension.getResponsabilidades());
        map.put("codigo", extension.getCodigo());
        map.put("unidad", extension.getUnidad());
        map.put("hsemestre", extension.getHorasSemestre()+"");
        map.put("hejecucion", extension.getHEjecucion()+"");
        map.put("hprogramacion", extension.getHProgramacion()+"");
        map.put("programa", extension.getPrograma());
        return map;
    }
    
    public static Map<String, String> investigacionToMap(Investigacion investigacion, Actividad actividad) {
        Map<String, String> map = new HashMap<>();
        map.put("id", String.valueOf(actividad.getId()));
        map.put("nombre", actividad.getNombre());
        map.put("hsemana", String.valueOf(actividad.getHorasSemana()));
                
        map.put("codigo", investigacion.getCodigo());
        map.put("responsabilidad", investigacion.getResponsabilidad());        
        map.put("unidad", investigacion.getUnidadInv());
        map.put("institucion", investigacion.getInstitucion());
        return map;
    }
    
    public static Map<String, String> otrasToMap(Otras otras, Actividad actividad) {
        Map<String, String> map = new HashMap<>();
        map.put("id", String.valueOf(actividad.getId()));
        map.put("nombre", actividad.getNombre());
        map.put("hsemana", String.valueOf(actividad.getHorasSemana()));
                
        map.put("hsemestre", otras.getHorasSemestre()+"");     
        return map;
    }
    
    public static Map<String, String> profesorToMap(Profesor profesor, Usuario usuario) {
        Map<String, String> map = new HashMap<>();
        map.put("id", String.valueOf(profesor.getId()));
        map.put("nombre", usuario.getNombres());
        map.put("email", usuario.getCorreo());
        map.put("codigo", profesor.getCodigo()+"");
        map.put("hsemana", profesor.getHorasSemana()+"");
        map.put("tipo", "Planta"); 
        return map;
    }
    
    
    

    public static String randomString() {
        String chars = "abcdefghijklmnopqrstuvwxyz";
        Random rand = new Random();
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            buf.append(chars.charAt(rand.nextInt(chars.length())));
        }
        return buf.toString();

    }

    
    public static boolean enviarCorreo(String destino, String titulo, String cuerpo) {
        try {
            String emailUsuarioEmisor = "avecsoporte@gmail.com";
            String clave = "bsoahrfjazycfark";
            ServiceEmail email = new ServiceEmail(emailUsuarioEmisor, clave);
            email.enviarEmail(destino, titulo, cuerpo);

        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static int token() {
        int numero = (int) (Math.random() * 999999) + 100000;
        return numero;
    }
/*
    public static String msgExPersistence(String cause) {
        int inicio = cause.indexOf("entry") + 5;
        int fin = cause.indexOf("for");
        return cause.substring(inicio, fin);
    }

    public static String getPeriodoYearCurrent(Date date) {
        String periodo = "";

        int year = date.getYear() + 1900;
        int month = date.getMonth();

        return (month <= 7) ? year + "-1" : year + "-2";
    }

    public static ArrayList<String[]> getListEstudiantes(String rutaFile) {
        ArrayList<String[]> listEstudiantes = new ArrayList<>();

        try {
            ExcelReader doc1 = new ExcelReader();

            ArrayList<String[]> arrayDatos = doc1.guardarexcelenarray(new File(rutaFile));

            int r = 0;
            for (String[] next : arrayDatos) {
                for (int c = 0; c < next.length; c++) {
                    if (c == 5 && (next[c].equals("1330605.0") || next[c].equals("1330703.0"))) {
                        next[3] = next[3].substring(0, 7);
                        next[7] = next[7].substring(0, 7);
                        next[8] = next[8].substring(0, 1);
                        next[c] = next[c].substring(0, 7);

                        listEstudiantes.add(next);
                    }
                }
            }

        } catch (Exception e) {
        }

        return listEstudiantes;
    }
*/
}
