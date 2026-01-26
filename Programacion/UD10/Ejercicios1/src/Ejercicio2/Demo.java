package Ejercicio2;

public class Demo {

    public static void main(String[] args) {

        Auto a1 = new Auto();
        Motocicleta m1 = new Motocicleta();
        Camion c1 = new Camion();

        Vehiculo[] concesionario = new Vehiculo[3];

        concesionario[0] = a1;
        concesionario[1] = m1;
        concesionario[2] = c1;

        for (Vehiculo c : concesionario){
            System.out.println(c.describirVehiculo());
        }

    }

}
