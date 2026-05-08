fun factorial(num: Int): Int{
        if (num <= 1) return 1
        return num * factorial(num-1)
}

fun main(){
        println("Dime el numero el cual deseas calcular el factorial")
       println(factorial(4))
}
