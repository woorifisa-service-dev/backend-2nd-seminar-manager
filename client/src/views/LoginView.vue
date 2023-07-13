<template>
  <div>
    <h1>Login</h1>
    <form action="">
      <label for="id">ID</label>
      <input type="text" name="userid" id="id" v-model="userid" />
      <label for="pwd">PASSWORD</label>
      <input type="password" name="userpwd" id="pwd" v-model="password" />
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
    await postLogin(userid.value, password.value);
    state.login = false;
    goPage('/');
  } catch (e) {
    console.error(e);
  }
};
</script>

<style lang="scss" scoped></style>
