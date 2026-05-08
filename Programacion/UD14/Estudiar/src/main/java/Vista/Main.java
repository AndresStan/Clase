package Vista;

import Controlador.Sentencias;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {



        // Mostrar estudiantes
        // mostrarEstudiantes();

        // Mostrar cursos
        // mostrarCursos();

        // Eliminar estudiante
        eliminarEstudiante();






    }

    public static void eliminarEstudiante(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime el id del estudiante");
        int id = sc.nextInt();
        sc.nextLine();
        if (Sentencias.eliminarEstudiante(id)){
            System.out.println("Se ha elimnado correctamente");
        } else {
            System.out.println("Ha ocurrido un error eliminando un estudiante");
        }
    }


    public static void mostrarCursos(){
        for (String s: Sentencias.mostrarCursos()){
            System.out.println(s);
        }
    }

    public static void mostrarEstudiantes(){
        for (String s : Sentencias.mostrarEstudiantesConCurso()){
            System.out.println(s);
        }
    }

}


