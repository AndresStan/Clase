import Ejercicio11.Producto

fun main() {

    var producto1 = Producto("Platano", 0.80, 5)
    var producto2 = Producto("Melon", 1.80, 0)
    var producto3 = Producto("Sandia", 2.10, 2)

    var lista = mutableListOf<Producto>()
    lista.add(producto1)
    lista.add(producto2)
    lista.add(producto3)

    var suma = 0.0
    for (i in lista){
        if (i.stock>0){
            suma += i.precio
        }
    }

    println(suma)


}