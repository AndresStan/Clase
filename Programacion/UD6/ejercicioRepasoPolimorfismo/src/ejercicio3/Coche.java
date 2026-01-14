package ejercicio3;

public class Coche extends Vehiculo{

    public Coche(String marca, String modelo) {
        super(marca, modelo);
    }

    public void abrirMaletero(){
        System.out.println("Maletero " + super.getMarca() + " " + super.getModelo() + " abierto ");
    }

}
