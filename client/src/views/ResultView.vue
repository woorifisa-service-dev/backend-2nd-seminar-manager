<template>
  <div>
    <h1 class="header">[ 클라우드 서비스 개발 세미나 결과 ]</h1>
    <div class="container">
      <div class="nav">
        <RouterLink
          :to="{ name: 'FeResult', replace: true }"
          active-class="active"
          style="text-decoration: none"
        >
          <div class="nav-item">FRONTEND</div>
        </RouterLink>
        <RouterLink
          :to="{ name: 'BeResult', replace: true }"
          active-class="active"
          style="text-decoration: none"
        >
          <div class="nav-item">BACKEND</div>
        </RouterLink>
        <RouterLink
          :to="{ name: 'CloudResult', replace: true }"
          active-class="active"
          style="text-decoration: none"
        >
          <div class="nav-item">CLOUD</div>
        </RouterLink>
      </div>
      <RouterView></RouterView>
    </div>
  </div>
</template>

<script setup></script>

<style scoped>
.header {
  text-align: center;
  font-weight: 700;
}
.container {
  width: 1200px;
  height: 100vh;
  margin: 0 auto;
  margin-top: 40px;
}
.nav {
  display: flex;
  justify-content: space-between;
  align-items: center;
  width: 1200px;
  background-color: #96b5ff;
}

.nav-item {
  font-size: 20px;
  width: 400px;
  text-align: center;
}

.active {
  color: white;
  background-color: #6149ff;
}
</style>
