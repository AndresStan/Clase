<script setup>
import { computed, ref } from 'vue'

 const favoritos = ref([])

    const manejarClick = (asd) => {
        console.log(asd)
    }
    const manejarClick2 = () => {
        console.log('Click 2')
    }
    const manejarClick3 = () => {
        console.log('Solo va con el Click Derecho')
    }
    const contador = ref(0)
    const ClaseContador = computed(() => {
        if (contador.value === 0) {
            return 'zero'
        } 
        return contador.value > 0 ? 'verde' : 'rojo'
    })
    const incrementar = () => {
        contador.value++;
        if (ref < 0) {
            
        }
    }
    const disminuar = () => {
        contador.value--;
    }
    const resetear = () => {
        contador.value = 0;
    }

    const favorito = () => {
        favoritos.value.push(contador.value)
    }


</script>



<template>
    <div class="container py-4 text-center">
        <button v-on:click="manejarClick('Click 1 por parametro')" >Click Aqui</button>
        <button @click="manejarClick2()" >Click Aqui</button> 
        <button @click.right="manejarClick3()">Boton 3 (Solo Click derecho)</button>  
        <hr>
        <h1>Contador</h1>
        <h1 :class="ClaseContador">{{ contador }}</h1>
        <button @click="incrementar()" class="btn btn-success">Aumentar</button>
        <button @click="disminuar()" class="btn btn-danger"> Disminuir</button>
        <button @click="resetear()" class="btn btn-primary">Reiniciar</button>
        <button @click="favorito()" class="btn btn-info">Favorito</button>
        <ul>
            <li v-for="n in favoritos">
                {{ n }}
            </li>
        </ul>
    </div>
</template>

<style>
    .rojo {
        color: red;
    }
    .verde {
        color: green;
    }
    .zero {
        color: yellow;
    }
</style>