// Me sirve para operar con arrays y con objetos, me permite expandirlos
const numeros = [1,2,3,4]
const listaNumeros = [ ...numeros, 7,8, ...numeros]

console.log(listaNumeros)

const listaCopiada = [...listaNumeros]

const persona = {
    nombre: "Alberto",
    edad: 40,
}

const personaCompleta = {
    ...persona,
    ciudad: "Teruel",
    codigoPostal: 44002,
    email: "Alberto@gmail.com",
}

personaCompleta.email = "hola@dam.com"

console.log(personaCompleta)