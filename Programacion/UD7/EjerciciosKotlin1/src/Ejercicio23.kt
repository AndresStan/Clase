import java.time.LocalDate
import java.util.Scanner
import javax.swing.text.DateFormatter

fun main() {
    // Pide una fecha y determina el día de la semana en que cayó.
    var sc = Scanner(System.`in`)
    println("Dime la fecha en formato 2007-12-21")
    var fechaTexto = sc.nextLine()
    var fechaReal = LocalDate.parse(fechaTexto)

    println(fechaReal.dayOfWeek)


}