import com.sun.jdi.connect.spi.Connection;

import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {


        System.out.println("Bienvenido al programa de interacción con la base de datos");

        while (true){
            Scanner sc = new Scanner(System.in);
            int respuesta;
            System.out.println();
            System.out.println("1 -- Insertar un estudiante");
            System.out.println("2 -- Mostrar estudiantes");
            System.out.println("3 -- Cambiar edad de un estudiante");
            System.out.println("4 -- Eliminar un estudiante");
            System.out.println("5 -- Salir");

            respuesta = sc.nextInt();
            sc.nextLine();

            switch (respuesta){
                case 1: InsertarEstudiantes();  break;
                case 2: mostrarEstudiantes();  break;
                case 3: cambiarEdadEstudiante(); break;
                case 4: EliminarEstudiante();  break;
                case 5:
                    System.out.println("Hasta luego!");
                    return;
                default:
                    System.out.println("Porfavor indique un valor correcto");
            }
        }
    }
    public static void InsertarEstudiantes(){
           try {
               Scanner sc = new Scanner(System.in);
               System.out.println("Porfavor, indique el ID del estudiante");
               int id = sc.nextInt();
               sc.nextLine();
               System.out.println("Porfavor, indique el nombre del estudiante");
               String nombre = sc.nextLine();
               System.out.println("Porfavor, indique la edad del estudiante");
               int edad = sc.nextInt();
               sc.nextLine();
               System.out.println("Porfavor indique el id del curso al que pertenece");
               int id_curso = sc.nextInt();
               sc.nextLine();
               if (Controlador.InsertarEstudiante(new Estudiante(id, nombre, edad, id_curso))){
                   System.out.println("El estudiante ha sido insertado correctamente");
               } else {
                   System.out.println("No se ha insertado ningún estudiante debido a un error");
               }
           } catch (Exception e) {
               System.out.println("Ha ocurrido un error insertando los datos del estudiante, porfavor asegurese de insertar los datos correctos.");
           }


    }

    public static void mostrarEstudiantes(){
        for (String s : Controlador.ConsultarEstudiantes()){
            System.out.println(s);
        }
    }

    public static void cambiarEdadEstudiante(){

        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Porfavor indica el id del estudiante a modificar");
            int id = sc.nextInt();
            System.out.println("Porfavor indica la edad a actualizar");
            int edad = sc.nextInt();
            if (Controlador.CambiarEdadEstudiante(edad, id)){
                System.out.println("Edad cambiada correctamente");
            } else {
                System.out.println("No se ha detectado ningún estudiante con ese id");
            }
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error actualizando los datos del estudiante, porfavor asegurese de insertar los datos correctos.");
        }

    }

    public static void EliminarEstudiante(){
        try  {
            Scanner sc = new Scanner(System.in);
            System.out.println("Porfavor indica el id del estudiante a eliminar");
            int id = sc.nextInt();
            if (Controlador.EliminarEstudiante(id)){
                System.out.println("Estudiante eliminado correctamente");
            } else {
                System.out.println("No se ha encontrado ningún estudiante con ese id");
            }

        } catch (Exception e) {
            System.out.println("No se ha eliminado ningun estudiante");
        }

    }
}
