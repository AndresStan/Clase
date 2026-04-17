<script setup>
  const nombre = "La clase de Dam 1"
  const styleColor = "color: blue;"
  const active = true
  const colores = ["blue", "red", "green"]
</script>



<template>

  <!--Directiva v-bind-->

  <h1>Hola {{ nombre }}</h1>
  <hr>
  <h2 v-bind:style="styleColor"> Hola {{ nombre }}</h2>
  <hr>
  <h2 v-bind:style="styleColor"> Hola {{ nombre }}</h2>
  <hr>
  <h2>{{active ? "Estoy activo" : "Estoy inactivo" }} </h2>
  <hr>
  <h2>{{colores}}</h2>
  <hr>
  <h2 :style="`color: ${colores[2]}`">Color con array</h2>
  <hr>

  <!--Directiva V-IF-->

  <h2 v-if="active"> v-if en acción</h2>
  <hr>
  <h2 v-if="!active"> v-if vale falso</h2>
  <h2 v-else> v-if accion else</h2>
  <hr>

  <!--Directiva v-show-->
  <h2 v-show="active" >Active vale true</h2>

</template>


<style>
h1 {
  color: red;
}
</style>