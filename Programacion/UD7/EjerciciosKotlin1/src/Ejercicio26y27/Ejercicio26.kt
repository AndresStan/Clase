package Ejercicio26y27

fun main() {

    // 26. Simula una cuenta bancaria con métodos para depositar, retirar y consultar saldo.

    var cuenta1 = Cuenta(1, 2.0)

    cuenta1.depositar(260.00)
    cuenta1.retirar(3.0)
    println(cuenta1.consultar())



}