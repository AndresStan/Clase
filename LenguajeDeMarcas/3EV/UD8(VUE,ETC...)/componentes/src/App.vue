<script setup>
import { ref } from 'vue';
import BlogPost from './componentes/BlogPost.vue';
import BotonContador from './componentes/BotonContador.vue';

const posts = ref([
  {id: 1, title:"Post 01", contenido:"Contenido del post 01"},
  {id: 2, title:"Post 02", contenido:"Contenido del post 02"},
  {id: 3, title:"Post 03", contenido:"Contenido del post 03"},
  {id: 4, title:"Post 03", contenido:"Contenido del post 04"},
  {id: 5, title:"Post 05"}
])

</script>

<template>
  <h1>DAM 1 - 2026</h1>
  <BotonContador></BotonContador>
  <hr>
  <div class="container">
      <BlogPost v-for="post in posts" :key="post.id"
      :title="post.title" :contenido="post.contenido" :id="post.id"/>
  </div>
 
</template>

<style scoped></style>
