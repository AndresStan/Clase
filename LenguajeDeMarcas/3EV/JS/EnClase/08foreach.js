const alumnos = ["Hector", "Andres", "Pablo", "Daniel"]

// forma vieja

for(let i = 0; i<alumnos.length; i++){
    console.log(alumnos[i])
}

// forma moderna

alumnos.forEach((alumno) => {
    console.log(alumno)
})

// forma moderna con indice
alumnos.forEach((a, indice) => {
    console.log(`${indice +1} - ${a}`)
})