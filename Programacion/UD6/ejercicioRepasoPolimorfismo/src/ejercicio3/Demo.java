package ejercicio3;

import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {

        ArrayList<Vehiculo> vehiculos = new ArrayList<>();

        Coche bmwe39 = new Coche("bmw", "e39");
        Coche bmw1 = new Coche("bmw", "1");
        Motocicleta yamaha125 = new Motocicleta("yamaha", "125");
        Vehiculo audi14 = new Coche("audi", "a4");

        vehiculos.add(bmwe39);
        vehiculos.add(yamaha125);
        vehiculos.add(audi14);

        bmwe39.abrirMaletero();
        yamaha125.hacerCaballito();
        bmwe39.arrancar();








    }
}
