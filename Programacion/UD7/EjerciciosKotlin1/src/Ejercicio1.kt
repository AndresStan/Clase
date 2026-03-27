import com.sun.tools.javac.Main
import java.util.Scanner

fun main() {

    var sc = Scanner(System.`in`)

    println("Dime el primer numero")
    var num1: Int = sc.nextInt()
    println("Dime el segundo numero")
    var num2: Int = sc.nextInt()

    if (num1 == num2){
        println("Son iguales")
    } else {
        if (num1 > num2){
            println("$num1 es mayor que $num2")
        } else {
            println("$num2 es mayor que $num1")
        }
    }


}
