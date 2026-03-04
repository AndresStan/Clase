package Ejercicio2;

import java.util.ArrayList;

public class app {
    public static void main(String[] args) {

        Vehiculo bmw = new Auto();
        Vehiculo kawasaki = new Motocicleta();
        Vehiculo mercedes = new Camion();

        ArrayList<Vehiculo> concesionario = new ArrayList<>();

        concesionario.add(bmw);
        concesionario.add(kawasaki);
        concesionario.add(mercedes);

        for (Vehiculo v : concesionario){
            System.out.println(v.describirVehiculo());
        }






    }
}
