package Ejercicio2;

public class Main {
    public static void main(String[] args) {

        Vehiculo[] vehiculos = new Vehiculo[3];

        vehiculos[0] = new Auto();
        vehiculos[1] = new Motocicleta();
        vehiculos[2] = new Camion();

        for (Vehiculo v : vehiculos) {
            v.describirVehiculo();
        }
    }
}

