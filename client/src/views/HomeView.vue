<template>
  <main>
    <h1>기술 세미나 평가</h1>
    <button v-show="isLogin" @click="() => goPage({ name: 'login', state: { login: isLogin } })">
      로그인
    </button>
    <div class="btn_wrap" v-show="!isLogin">
      <button @click="onClickLogout">로그아웃</button>
      <button @click="() => goPage(`/estimation/select`)">평가하기</button>
      <button @click="() => goPage(`/result`)">결과보기</button>
    </div>
  </main>
</template>

<script setup>
import { ref } from 'vue';
import { goPage } from '../utils/pages.js';
import { logout } from '../apis/api.js';

const isLogin = ref(false);
const onClickLogout = async () => {
  isLogin.value = true;
  await logout();
};
</script>

<style scoped>
main {
  width: 100%;
  height: 100vh;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
h1 {
  font-size: 5rem;
  font-weight: 700;
}
button {
  border: 1px solid black;
  padding: 20px 40px;
  border-radius: 30px;
  background: blue;
  color: white;
  font-size: 24px;
  cursor: pointer;
  margin: 20px;
}
</style>
