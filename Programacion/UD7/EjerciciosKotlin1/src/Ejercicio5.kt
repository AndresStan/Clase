import java.util.Scanner

fun main() {

    var sc = Scanner(System.`in`)
    var lista = mutableListOf<Int>()

    println("Introduce los numero que deses, introduce 99 para parar.")
    var num = sc.nextInt()

    while (num != 99){
        lista.add(num)
        num = sc.nextInt()
    }
    
    lista = lista.stream().sorted().toList().reversed() as MutableList<Int>
    println(lista[1])
}