package ejercicio3;

public class Motocicleta extends Vehiculo{

    public Motocicleta(String marca, String modelo) {
        super(marca, modelo);
    }

    public void hacerCaballito(){
        System.out.println("Caballito " + super.getMarca() + " " + super.getModelo()+ " hecho");
    }


}
