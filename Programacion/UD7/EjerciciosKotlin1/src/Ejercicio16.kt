fun identificarTipo(valor: Any) {
    when (valor) {
        is String -> println("Es un String y su longitud es ${valor.length}")
        is Int -> println("Es un número entero: $valor")
        is Boolean -> println("Es un booleano: ${if (valor) "Verdadero" else "Falso"}")
        is Double -> println("Es un número decimal (Double): $valor")
        else -> println("Tipo de dato desconocido")
    }
}

fun main() {
    identificarTipo("Hola Kotlin")
    identificarTipo(100)
    identificarTipo(true)
    identificarTipo(3.14)
}