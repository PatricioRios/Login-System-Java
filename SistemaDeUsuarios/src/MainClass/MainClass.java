package MainClass;

import java.util.Scanner;
import funcionalidades.FuncionalidadesImpl;

public class MainClass {
    public static void main(String[] args) {
        FuncionalidadesImpl fnControl = new FuncionalidadesImpl();
        System.out.println("PROGRAMA DE USUARIOS\n"+"Hecho por patricioRios");
        while(true){
        System.out.println("Elige una opcion");
        System.out.println("1). iniciar secion\n"
                + "2). Añadir nuevo usuario \n"
                + "3). Listar todos los usuarios\n"
                + "4). iniciar archivo nuevo\n"
                + "5). salir de el programa");
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        int opcion=sc.nextInt();
        switch (opcion) {
            case 1:
                while(true){
                String usuario,contraseña;
                sc.nextLine();
                System.out.println("Dame el nombre de usuario");
                usuario=sc.nextLine();
                sc.nextLine();
                System.out.println("Dame la contraseña");
                contraseña=sc.nextLine();
                    if(fnControl.validacion(usuario, contraseña)=="true"){
                        System.out.println("Secion iniciada correctamente3");
                        break;
                    }else if(fnControl.validacion(usuario, contraseña)=="IncorrectPassword"){
                        System.out.println("Quieres volver a intentarlo ?");
                        System.out.println("1). Si\n"
                                + "2). No");
                        opcion=sc.nextInt();
                        if(opcion==1){
                            continue;
                        }else if(opcion==2){
                            break;
                        }
                    }else if(fnControl.validacion(usuario, contraseña)=="noUser"){
                        System.out.println("puedes añadir un nuevo usuario desde el panel de inicio");
                        break;
                    }
                }
                break;
            case 2:
                String usuario,contraseña;
                System.out.println("Dame el nombre de usuario");
                sc.nextLine();
                while(true){
                    usuario=sc.nextLine();
                    if(fnControl.exist(usuario)){
                        System.out.println("ese nombre de usuario ya fue utilizado, utiliza otro");
                    }else{
                        break;
                    }
                }
                System.out.println("Dame la contraseña");
                contraseña=sc.nextLine();
                fnControl.añadirUsuario(usuario, contraseña);
                break;
            case 3:
                fnControl.listarUsuarios();
                break;
            case 4:
                fnControl.iniciarArchivo();
                break;
            case 5:
                break;
            default:
                throw new AssertionError();
        }
        if(opcion==5)
            break;
        }
    }
}
