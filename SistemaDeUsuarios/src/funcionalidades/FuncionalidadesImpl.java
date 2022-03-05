package funcionalidades;

import Datos.DatosImpl;
import domain.Usuario;
import excepciones.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FuncionalidadesImpl implements IFuncionalidades {
    
    private final DatosImpl manejoDato=new DatosImpl();
    
    @Override
    public void añadirUsuario(String nombreUsuario, String passwordUsuario) {
        Usuario usuario=new Usuario(nombreUsuario,passwordUsuario);
        try {
            manejoDato.escribir(usuario, NOMBRE_RECURSO, true);
            System.out.println("Se añadio el nuevo usuario " + nombreUsuario +"a la base de datos");
        } catch (EscrituraDatosEx ex) {
            Logger.getLogger(FuncionalidadesImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public String validacion(String nombreUsuario, String PasswordUsuario) {
        try {
            List<Usuario> lista=manejoDato.listar(NOMBRE_RECURSO);
            int i=0;
            boolean validation;
            while(true){
                if(lista.get(i).getNombre().contentEquals(nombreUsuario) && lista.get(i).getNombre() != null ){
                    System.out.println("se encontro el usuario" + nombreUsuario);
                    if(lista.get(i).getContrasena().contentEquals(PasswordUsuario)){
                        return "true";
                    }else{
                        System.out.println("Contraseña equivocada");
                        return "IncorrectPassword";
                    }
                }else if(lista.get(i)==null){
                    System.out.println("no se encontro el usuario");
                    return "noUser";
                }
                i++;
            }
        } catch (LecturaDatosEx ex) {
            Logger.getLogger(FuncionalidadesImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "noUser";
    }

    @Override
    public void listarUsuarios() {
        try {
            for(Usuario elemento : manejoDato.listar(NOMBRE_RECURSO)){
                System.out.println("USUARIO = " + elemento.toString());
            }
        } catch (LecturaDatosEx ex) {
            Logger.getLogger(FuncionalidadesImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void iniciarArchivo() {  
        try {
            if(manejoDato.existe(NOMBRE_RECURSO)){
                manejoDato.borrar(NOMBRE_RECURSO);
                manejoDato.crear(NOMBRE_RECURSO);
            }else{
                manejoDato.crear(NOMBRE_RECURSO);
            }
        } catch (AcsesoDatosEx ex) {
            Logger.getLogger(FuncionalidadesImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean exist(String nameUsser){
        List<Usuario> usuarios;
        try {
            usuarios = manejoDato.listar(NOMBRE_RECURSO);
            for(int i=0;i<usuarios.size();i++){
            if(usuarios.get(i).getNombre().equalsIgnoreCase(nameUsser)){
                return true;
            }
        }
        
        } catch (LecturaDatosEx ex) {
            Logger.getLogger(FuncionalidadesImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
