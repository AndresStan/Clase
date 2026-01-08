package ejercicio1;

public class Gato extends Animal{

    @Override
    public void hacerSonido() {
        super.sonido = "miau";
        super.hacerSonido();
    }
}
