<template>
  <div class="login">
    <h1>Login</h1>
    <form action="">
      <label for="id">ID</label>
      <input type="text" name="userid" id="id" v-model="userid" placeholder="id" />
      <label for="pwd">PASSWORD</label>
      <input type="password" name="userpwd" id="pwd" v-model="password" placeholder="password" />
      <button type="button" @click="login">login</button>
    </form>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import { postLogin } from '../apis/api';
import { goPage } from '../utils/pages';

const userid = ref('');
const password = ref('');
const state = history.state;

const login = async () => {
  try {
    const member = await postLogin(userid.value, password.value);
    sessionStorage.setItem('member', JSON.stringify(member));
    state.login = false;
    goPage('/');
  } catch (e) {
    console.error(e);
  }
};
</script>

<style scoped>
.login {
  height: 100vh;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

h1 {
  font-size: 64px;
}

form {
  display: flex;
  flex-direction: column;
  gap: 8px;
  font-size: 24px;
  width: 60%;
}

input {
  /* height: 48px; */
  font-size: 32px;
  padding: 8px 20px;
}

button {
  font-size: 24px;
  border: 1px solid var(--light-blue);
  background: var(--blue);
  color: white;
  padding: 20px 60px;
  width: fit-content;
  margin: auto;
  border-radius: 16px;
  margin-top: 64px;
}
</style>
