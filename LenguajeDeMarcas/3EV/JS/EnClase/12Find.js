// Filter devuelve todos los elementos que cumplen una condicion
// find devuelve solo el primer elemento que cumple la condicion
const usuarios = [
    {id:1, nombre: "Ana"},
    {id:2, nombre: "Iker"},
    {id:3, nombre: "David"},
]

const resultado1 = usuarios.filter(u => u.id === 2)
console.log(resultado1)

const resultado2 = usuarios.find(u => u.id === 2)
console.log(resultado2)