fun main() {

    // 24. Dado un texto, cuenta cuántas palabras distintas tiene.

    val texto = "Hola muy buenas, estoy estudiante kotlin en mi casa".trim()

    var palabras = 1

    for ( (index) in texto.withIndex()){
        if (texto[index] == ' '){
            if (texto[index+1] != ' '){
                palabras++
            }
        }
    }

    println(palabras)
}