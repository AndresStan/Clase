import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)
    println("Mete numeros a la lista (99 para parar)")
    var lista = mutableListOf<Int>()
    var num = sc.nextInt()
    while (num != 99){
        lista.add(num)
        num = sc.nextInt()
    }

    println(lista)
    devolverSinDuplicados(lista)

}

fun devolverSinDuplicados(lista: MutableList<Int>) {
    println(lista.distinct())
}