package Datos;

import domain.Usuario;
import excepciones.LecturaDatosEx;
import java.util.List;


public class Test {
    public static void main(String[] args) throws LecturaDatosEx {
        
    
    DatosImpl datos = new DatosImpl();
    
    String in= "Patricio-Erika123";
    String outPassword,outUsser;
    outPassword = datos.returnPassword(in);
    outUsser=datos.returnUsser(in);
    System.out.println(outPassword);
    System.out.println(outUsser);
    List<Usuario> usuarios=datos.listar("archivo.txt");
    System.out.println(usuarios.get(0).getNombre());
    String nombreUsuario=usuarios.get(0).getNombre();
    
    System.out.println("nombre usuario = " + nombreUsuario );
        
    if(nombreUsuario.contentEquals("Patricio")){
        System.out.println("La comparacion funciono correctamente");
    }else{
        System.out.println("la validacion no se hizo");
    }
    }
}
