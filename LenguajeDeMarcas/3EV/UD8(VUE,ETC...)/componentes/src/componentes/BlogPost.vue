<script setup>
import BotonContador from './BotonContador.vue';


    // defineProps(['title', 'contenido', 'id'])
    const props = defineProps({
        title: String,
        id: Number,
        contenido: {
            type: String,
            default: 'Sin descripción'
        }
    })
   
</script>
<template>
    <div class="card">
        <div class="card-body">
            <h4 class="card-title">
                {{ title }}
            </h4>
            <p>
              {{ id }} - {{contenido}} 
            </p>
            <button @click="$emit('cambiarFavorito', title)" class="btn btn-outline-primary">
                Mi favorito
            </button>
            <BotonContador></BotonContador>
        </div>
    </div>
</template>
