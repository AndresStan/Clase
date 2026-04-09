// Crear una promesa
const miPromesa = new Promise((resolve, reject) => {
    // Codigo asíncrono
    setTimeout( () => {
        const exito = true
          if (exito) {
        resolve("Exito!, aqui estan los datos")
    } else {
        reject("Error: algo salio mal!")
    }
    }, 2000)
  
})

// Usar esta promesa

console.log("Inicio")

miPromesa
    .then(resultado => {console.log(resultado)

    })
    .catch( error => {
        console.log(error)
    })