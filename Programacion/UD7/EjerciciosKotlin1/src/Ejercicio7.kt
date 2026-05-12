import java.util.Scanner
import kotlin.streams.toList

fun main() {

    val sc = Scanner(System.`in`)
    var lista = mutableListOf<String>()
    println("Ve introduciendo los String a la lista, escribe 'fin' para acabar")
    var palabra = sc.nextLine()
    while (palabra != "fin"){
        lista.add(palabra.trim())
        palabra = sc.nextLine()
    }
    lista = lista.stream().sorted().toList()
    println(lista)
}