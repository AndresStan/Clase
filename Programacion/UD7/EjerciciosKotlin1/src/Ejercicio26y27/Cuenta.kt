package Ejercicio26y27

data class Cuenta (
    var id: Int,
    var dinero: Double
) {

    fun consultar(): Double{
        return this.dinero
    }

    fun retirar(a: Double): Boolean{
        try {

            if (this.dinero-a < 0){
               throw saldoInsufiente()
                return false
            } else {
                this.dinero -= a
            }
            return true
        } catch (e: Exception) {
            println(e)
            return false
        }
    }

    fun depositar(a: Double): Boolean {
        try {
            this.dinero += a
            return true
        } catch (e: Exception) {
            println(e)
            return false
        }
    }

    class saldoInsufiente() : Exception("Dinero mal")

}
