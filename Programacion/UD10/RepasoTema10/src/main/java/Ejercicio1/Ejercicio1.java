package Ejercicio1;

public class Ejercicio1 {

    public static void main(String[] args) {

        Empleado e1 = new Empleado("Luis", 2000);
        Gerente g1 = new Gerente("Javier", 2040, 300);


        System.out.println(e1.mostrarInfo());
        System.out.println(g1.mostrarInfo());



    }


}
