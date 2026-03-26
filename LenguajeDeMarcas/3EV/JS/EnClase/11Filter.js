// filter selecciona elementos que cumplen una condicion
const numeros = [5 , 12 , 8 , 20 , 3 , 15]
// Necesito numeros mayores de 10
const mayoresDe10 = numeros.filter(n => n>10)
console.log(mayoresDe10)
// Necesito los pares
const pares = numeros.filter(n => n % 2 === 0)
console.log(pares)
// Caso real
const alumnos = [
    {nombre: "Dylan", nota: 5},
    {nombre: "Dani Remon", nota: 4},
    {nombre: "Andres", nota:10},
]
// mostrar aprobados
const alumnosAprobados = alumnos.filter( a => a.nota>=5)

alumnosAprobados.forEach(element => {
    console.log(element)
});

// mostrar suspensos

const alumnosSuspensos = alumnos.filter( a => a.nota<5)

alumnosSuspensos.forEach(element => {
    console.log(element)
});