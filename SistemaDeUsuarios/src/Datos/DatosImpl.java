package Datos;

import domain.Usuario;
import excepciones.*;
import java.io.*;
import java.util.*;

public class DatosImpl implements IDatos {

    public DatosImpl() {
    }

    @Override
    public boolean existe(String nombreArchivo) throws AcsesoDatosEx {
        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }

    @Override
    public List<Usuario> listar(String nombre) throws LecturaDatosEx {
        File archivo = new File(nombre);
        List<Usuario> peliculas = new ArrayList<Usuario>();
        try {
            var entrada = new BufferedReader(new FileReader(archivo));

            String linea = null;
            linea = entrada.readLine();

            while (linea != null) {
                String usuario, password;
                usuario = returnUsser(linea);
                password = returnPassword(linea);
                var pelicula = new Usuario(usuario, password);
                peliculas.add(pelicula);
                linea = entrada.readLine();
                System.out.println(usuario + password);
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al listar peliculas:" + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al listar peliculas:" + ex.getMessage());
        }
        return peliculas;
    }

    public String returnUsser(String parametro) {
        int contador = 0;
        while (true) {
            if (parametro.charAt(contador) == '-') {
                break;
            }
            contador++;
        }
        char charReturn[] = new char[contador];
        for(int j=0;j<charReturn.length;j++){
            charReturn[j]=parametro.charAt(j);
        }
        String stringReturn = String.valueOf(charReturn);
        return stringReturn;
    }

    public String returnPassword(String parametro) {
        int contador = 0, i = 0;
        while (true) {
            if (parametro.charAt(contador) == '-') {
                break;
            }
            contador++;
        }
        int f=contador+1;
        char charReturn[] = new char[parametro.length() - (contador+1)];
        for (int j = 0; j < charReturn.length; j++) {
            charReturn[j] = parametro.charAt(f++);
        }
        String stringReturn = String.valueOf(charReturn);
        return stringReturn;
    }

    @Override
    public void escribir(Usuario pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(pelicula.toString());
            salida.close();
            System.out.println("Se escribio el nuevo usuario: " + returnUsser(pelicula.toString()));
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new EscrituraDatosEx("Excepcion al escribir usuarios:" + ex.getMessage());
        }

    }

    @Override
    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx {

        File archivo = new File(nombreArchivo);
        String linea = null, resultado = null;
        boolean encontrado = false;
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            linea = entrada.readLine();
            String apuntador;
            apuntador = returnUsser(linea);
            int nLinea = 0;
            while (apuntador != null) {
                if (buscar != null && buscar.equalsIgnoreCase(apuntador)) {
                    resultado = "Pelicula " + apuntador + " encontrada en el indice " + nLinea;
                    encontrado = true;
                    break;
                }
                linea = entrada.readLine();
                apuntador = returnUsser(linea);
                nLinea++;
            }
            System.out.println("LA PELICULA SE ENCONTRO EN LA LINEA NUMERO" + nLinea);
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al listar peliculas:" + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al listar peliculas:" + ex.getMessage());
        }
        if (encontrado) {
            return resultado;
        } else {
            return "no se encontro la pelicula buscada";
        }
    }

    @Override
    public void crear(String nombreArchivo) throws AcsesoDatosEx {
        var archivo = new File(nombreArchivo);
        try {
            var salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
            System.out.println("Se ha creado el archivo");
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new AcsesoDatosEx("Excepcion al crear archivo:" + ex.getMessage());

        }
    }

    @Override
    public void borrar(String nombreArchivo) throws AcsesoDatosEx {
        var archivo = new File(nombreArchivo);
        if (archivo.exists()) {
            archivo.delete();
        }
        System.out.println("Se ha borrado el archivo");
    }
}
