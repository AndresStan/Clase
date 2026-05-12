
fun String.soloVocales(): String {
    val vocales = "aeiouAEIOU"
    val resultado = StringBuilder()

    for (caracter in this) {
        if (caracter in vocales) {
            resultado.append(caracter)
        }
    }
    return resultado.toString()
}

fun main() {
    val frase = "iker lozano"

    val resultado = frase.soloVocales()

    println("Original: $frase")
    println("Solo vocales: $resultado")
}