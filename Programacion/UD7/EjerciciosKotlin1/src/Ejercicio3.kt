fun main() {
    println("Ingresa la palabra:")
    var palabra = readLine();
    palabra = palabra?.trim();
    if (palabra != "" && palabra == palabra?.reversed()){
        println("La palabra: $palabra es palindroma")
    } else{
        println("La palabra $palabra no es palindroma")
    }
}