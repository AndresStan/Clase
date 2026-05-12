package Ejercicio14

data class Empleado(
    var nombre: String,
    var edad: Int



) {
    fun calcularAniosParaJubilacion(): String{
        var años = 65-this.edad
        return "Te faltan $años para jubilarte"
    }

}