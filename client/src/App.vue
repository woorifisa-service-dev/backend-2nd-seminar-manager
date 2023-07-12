<script setup>
import { RouterLink } from 'vue-router';
</script>

<template>
  <div>
    <nav>
      <RouterLink to="/">Home</RouterLink>
      <RouterLink to="/about">About</RouterLink>
    </nav>
    <router-view />
  </div>
</template>

<style scoped></style>
