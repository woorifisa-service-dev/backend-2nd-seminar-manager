<template>
  <div>
    <h1>클라우드 서비스 개발 세미나 결과</h1>
    <div class="container">
      <div class="nav">
        <RouterLink to="/result/fe" active-class="active" style="text-decoration: none">
          <div class="nav-item">프론트엔드</div>
        </RouterLink>
        <RouterLink to="/result/be" active-class="active" style="text-decoration: none">
          <div class="nav-item">백엔드</div>
        </RouterLink>
        <RouterLink to="/result/cloud" active-class="active" style="text-decoration: none">
          <div class="nav-item">클라우드</div>
        </RouterLink>
      </div>
      <RouterView></RouterView>
    </div>
  </div>
</template>

<script setup></script>

<style scoped>
.container {
  width: 1200px;
  height: 100vh;
  margin: 0 auto;
}
.nav {
  display: flex;
  justify-content: space-between;
  align-items: center;
  width: 1200px;
  background-color: #eee;
}

.nav-item {
  color: black;
  font-size: 20px;
  width: 400px;
  text-align: center;
}

.active {
  background-color: rgb(71, 71, 252);
}
</style>
