import java.time.LocalDate

fun main() {
    // 22. Calcula cuántos días faltan para el próximo 1 de enero desde hoy.
    var hoy = LocalDate.now()
    var dias = 0
        while (!(hoy.dayOfMonth == 1 && hoy.monthValue == 1)){
            hoy = hoy.plusDays(1);
            dias ++
        }

    println(dias)
}