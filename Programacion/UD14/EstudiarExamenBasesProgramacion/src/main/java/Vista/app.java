package Vista;
import Controlador.Conexion;
import Controlador.Consultas;
import Modelo.Estudiante;

import java.sql.Connection;
import java.util.Scanner;


public class app {

    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {

    // insertarEstudiante();
    // mostrarEstudiantes();
    // cambiarEdadEstudiante();
        eliminarEstudiante();

    }

    public static void eliminarEstudiante(){
        System.out.println("Que estudiante desea eliminar? (introduzca el id)");
        mostrarEstudiantes();
        int id = sc.nextInt();
        sc.nextLine();

        if (Consultas.eliminarEstudiante(id)){
            System.out.println("Estudiante eliminado correctamente");
        } else {
            System.out.println("Ha ocurrido un error eliminando al estudiante");
        }


    }

    public static void cambiarEdadEstudiante(){
        System.out.println("¿Que estudiante deseas cambiarle la edad? (Inserta el ID)");
        mostrarEstudiantes();
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("¿Que edad desea?");
        int edad = sc.nextInt();
        if (Consultas.actualizarEdadEstudiante(id, edad)){
            System.out.println("Edad del estudiante actualizado correctamente");
        } else {
            System.out.println("Ha ocurrido un error actualizando la edad del estudiante");
        }
    }

    public static void mostrarEstudiantes(){
        for (String s : Consultas.mostrarEstudiantesMasNombreCurso()){
            System.out.println(s);
        }
    }


    public static void insertarEstudiante(){
        System.out.println("Dime el nombre del estudiante");
        String nombre = sc.nextLine();
        System.out.println("Dime la edad del estudiante");
        int edad = sc.nextInt();
        sc.nextLine();
        System.out.println("Dime a que curso lo quieres insertar:");
        for (String s : Consultas.selectCursos()){
            System.out.println(s);
        }
        int curso = sc.nextInt();
        sc.nextLine();

        if (Consultas.insertarEstudiante(new Estudiante(nombre,edad,curso))){
            System.out.println("Estudiante insertado correctamente");
        } else {
            System.out.println("Ha ocurrido un error insertando un estudiante");
        }



    }
}
