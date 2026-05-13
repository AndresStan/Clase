// Esta funcion recibe dos parametros y un lambda que es otra funcion, entonces le pasamos que quiere que haga

fun calcular(a: Int, b: Int, operacion: (Int, Int) -> Int): Int {
    return operacion(a, b)
}

fun main() {
    //Usamos la función para sumar
    val suma = calcular(5, 3) { x, y -> x + y }

    //Usamos la misma función para multiplicar
    val multi = calcular(5, 3) { x, y -> x * y }

    println("Suma: $suma")
    println("Multi: $multi") 
}