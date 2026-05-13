package Ejercicio25

import java.time.LocalDate
import kotlin.streams.toList

fun main() {

    // 25. Crea un programa que ordene una lista de data class Libro(titulo, autor, año) por año de
    // publicación.

    var lista = mutableListOf<Libro>()

    lista.add(Libro("Pacman", "Andres", LocalDate.of(2001, 1, 1)))
    lista.add(Libro("Pacman 2", "Luis ", LocalDate.of(2011, 9, 12)))
    lista.add(Libro("Pacman 3", "Jose", LocalDate.of(2021, 12, 22)))
    lista.add(Libro("Pacman 4", "Mario", LocalDate.of(2000, 5, 4)))

    lista = lista.stream().sorted(compareBy { s-> s.anio }).toList()

    println(lista)

}