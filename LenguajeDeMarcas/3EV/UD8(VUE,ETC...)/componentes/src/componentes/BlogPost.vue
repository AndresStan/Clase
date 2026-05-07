<script setup>

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
              {{ id }} {{contenido}} 
            </p>
        </div>
    </div>
</template>