import kotlin.random.Random

fun main() {

    var dado1 = 1
    var dado2 = 1

    var suma = 0

    while (suma != 12){
        dado1 = Random.nextInt(1,7)
        dado2 = Random.nextInt(1,7)
        suma = dado1 + dado2
    }

    println("Dados: $dado1 $dado2")

}