package Datos;

import domain.Usuario;
import excepciones.AcsesoDatosEx;
import excepciones.EscrituraDatosEx;
import excepciones.LecturaDatosEx;
import java.util.List;

public interface IDatos {
    
    boolean existe(String nombreArchivo) throws AcsesoDatosEx;

    List<Usuario> listar(String nombre) throws LecturaDatosEx;

    void escribir(Usuario pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx;

    String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx;

    void crear(String nombreArchivo) throws AcsesoDatosEx;

    void borrar(String nombreArchivo) throws AcsesoDatosEx;

}
