import java.time.LocalDate

// 21. Dado un mapa de personas con sus fechas de nacimiento (LocalDate), muestra quién es
//mayor.

fun main() {

    var personas = mutableMapOf<Int, LocalDate>()

    personas[1] = LocalDate.of(2007, 12, 28)
    personas[2] = LocalDate.of(2009, 5, 4)
    personas[3] = LocalDate.of(2005, 11, 11)
    personas[4] = LocalDate.of(2010, 3, 25)

    var mayor = personas.entries.first()

    for (i in personas){
        if (i.value.isBefore(mayor.value)){
            mayor = i
        }

    }

    println(mayor)

}