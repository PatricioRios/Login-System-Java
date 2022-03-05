package funcionalidades;

public interface IFuncionalidades {
    
    final String NOMBRE_RECURSO= "archivo.txt" ;
    
    void añadirUsuario(String nuevoUsuario,String passwordUsuario);
    String validacion(String nombreUsuario,String PasswordUsuario);
    void listarUsuarios();
    void iniciarArchivo();
    
    
}
