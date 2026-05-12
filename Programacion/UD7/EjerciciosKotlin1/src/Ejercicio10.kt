import java.util.Scanner

fun main() {
    println("Indica la cadena a hacer reversed")
    val sc = Scanner(System.`in`)
    var cadenaReversed = StringBuilder()
    val cadena = sc.nextLine().trim()
    for (i in cadena.length-1 downTo 0){
        cadenaReversed.append(cadena[i])
    }
    println(cadenaReversed)

}