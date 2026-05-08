import java.util.Scanner
import kotlin.math.sqrt

fun esPrimo(num: Int): Boolean{
    if (num <= 1) {
        return false
    } else {
        for (i in 2..sqrt(num.toDouble()).toInt()){
            if (num % i == 0){
                return false
            }
        }
    }
    return true
}

fun listaNumerosPrimos(num: Int){
    for (a in 2..num){
        var es: Boolean = true
        for (i in 2..sqrt(num.toDouble()).toInt()){
                if (a % i == 0){
                    es = false
                }
        }
        if (es) {
            print("$a ")
        }

    }

}



fun main() {
    var sc = Scanner(System.`in`)
    println("Dime el numero a verificar si es primo")
    var numero = sc.nextInt()
    if (esPrimo(numero)){
        println("Es primo")
    } else{
        println("No es primo")
    }
    println("Ahora pongo la lista de primos hasta el numero indicado")
    listaNumerosPrimos(numero)

}