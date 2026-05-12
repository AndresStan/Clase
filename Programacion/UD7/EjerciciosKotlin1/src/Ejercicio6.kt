import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)
    println("Introduce la frase")
    val frase = sc.nextLine();
    val lista = devolverNumeroDeLetras(frase.trim())
    println(lista)
}

fun devolverNumeroDeLetras(frase: String): MutableMap<Char, Int> {

    var lista = mutableMapOf<Char, Int>()
    for (letra in frase){
        if (letra != ' '){
            lista[letra] = lista.getOrDefault(letra, 0) + 1
        }

    }
    return lista

}