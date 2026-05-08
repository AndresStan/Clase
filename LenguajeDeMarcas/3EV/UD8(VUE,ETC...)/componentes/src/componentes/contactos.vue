<script setup>
const props = defineProps({
    nombre: String,
    email: String,
    trabajo: String,

})
</script>

<template>


            <div class="col">
                <div class="card-body border border-primary rounded p-3">
                    <h4 class="card-title">
                        {{ nombre }}
                    </h4>
                    <p class="mb-2">
                        {{ email }}
                    </p>
                    <button @click="$emit('cambiarContacto', nombre)" class="btn btn-outline-primary mb-2">
                        Contactar
                    </button>
                    <BotonContador></BotonContador>
                </div>
            </div>
    



</template>