<script setup>
import { ref } from 'vue';
import BlogPost from './componentes/BlogPost.vue';
import BotonContador from './componentes/BotonContador.vue';
import contactos from './componentes/contactos.vue';

const posts = ref([
  {id: 1, title:"Post 01", contenido:"Contenido del post 01"},
  {id: 2, title:"Post 02", contenido:"Contenido del post 02"},
  {id: 3, title:"Post 03", contenido:"Contenido del post 03"},
  {id: 4, title:"Post 04", contenido:"Contenido del post 04"},
  {id: 5, title:"Post 05", contenido:"Contenido del post 05"}
])

const contacts = ref([
  {nombre: "Juan Perez", email: "juan@gmail.com", trabajo: "Desarrollador"},
  {nombre: "María García", email: "maria@gmail.com", trabajo: "Diseñadora"},
  {nombre: "Carlos Lopez", email: "carlos@gmail.com", trabajo: "Usuario"}
])

const miFavorito = ref("")
const miContacto = ref("")

const cambiarContacto = (nombre) => {
  miContacto.value = nombre;
}
const cambiarFavorito = (title) => {
  miFavorito.value = title;
}

</script>

<template>
  <h1>DAM 1 - 2026</h1>
  <BotonContador></BotonContador>
  <hr>
  <h2>Contactar con: {{ miContacto }}</h2>


   <div class="container">
      <div class="row">
        <contactos v-for="contacto in contacts" :key="contacto.nombre"
        :nombre="contacto.nombre" 
        :email="contacto.email"
        :trabajo="contacto.trabajo"
        @cambiarContacto="cambiarContacto"
        class="mb-2"
        />
      </div>
      
  </div>
  <hr>
  <h2>Mi post Favorito: {{miFavorito}}</h2>
  <hr>
  <div class="container">
      <BlogPost v-for="post in posts" :key="post.id"
      :title="post.title" 
      :contenido="post.contenido"
      :id="post.id"
      @cambiarFavorito="cambiarFavorito"
      class="mb-2"
       />
       
  </div> 
 
</template>

<style scoped></style>
