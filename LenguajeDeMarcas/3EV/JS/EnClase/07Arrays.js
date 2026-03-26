// Crear un array
const frutas = ["manzana", "pera", "melocoton"]

console.log(frutas[1])

// Nos devuelve el tamaño del array
console.log(frutas.length)

// Ver el ultimo dato
console.log(frutas[frutas.length-1])

const carrito = ["raton", "monitor"]
console.log(carrito)

// Con pop eliminamos el ultimo dato
carrito.pop()
console.log(carrito)

// unshift añade al principio
carrito.unshift("Webcam")
console.log(carrito)

// shift quita el primer elemento
const lista2 = carrito.shift()

console.log(`Lista 2 es: ${carrito}`)