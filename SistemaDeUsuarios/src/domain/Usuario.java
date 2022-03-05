package domain;
public class Usuario {
    
    private String nombre;
    private String contrasena;
    private static int contadorUsuarios;
    
    
    public Usuario(){
        Usuario.contadorUsuarios++;
    }
    
    public Usuario(String nombre,String contrasena){
        super();
        this.nombre=nombre;
        this.contrasena=contrasena;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contraseña) {
        this.contrasena = contraseña;
    }

    @Override
    public String toString() {
        return this.nombre + "-" + this.contrasena;
    }
}