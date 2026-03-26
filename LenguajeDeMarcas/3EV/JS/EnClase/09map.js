const numeros = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

//const dobles = numeros.map((numero) => {
  //  console.log(`procesando: ${numero}`)
  //  //return numero*2
//})

console.log(numeros)
//console.log(dobles)

// Necesito que todos los valores del array numeros que sean divisibles por dos me los multipliques por 100
const problema = numeros.map( n => {
    if (n % 2 == 0) {
        return n*100
    }
    return n
})
console.log(problema)

// caso real
const usuariosDesdeServidor = [
    {id: 1, nombre: "Ana", edad: 28},
    {id: 2, nombre: "Daniel", edad: 25},
    {id: 3, nombre: "Hecproll", edad: 17},
]

// Necesitamos en la UI solo los nombres

const nombreUsuario = usuariosDesdeServidor.map ( n => {
    return n.nombre
})

console.log(nombreUsuario)

// Puedo crear objetos transformados
const usuariosFormateados = usuariosDesdeServidor.map( n => ({
    label: n.nombre,
    valor: n.id,    
    esAdulto: n.edad>=18,
}))

usuariosFormateados.forEach(n => {
    console.log(n)
});

