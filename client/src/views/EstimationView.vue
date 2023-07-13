<template>
  <div class="estimation">
    <h1>평가하기</h1>
    <div class="title">
      <h2>{{ clazz }} | {{ type }}</h2>
    </div>
    <form action="">
      <div v-for="(item, index) in itmes" :key="item.name">
        <label :for="itmes.name">{{ item.text }}</label>
        <input
          type="range"
          :name="item.name"
          :id="item.name"
          v-model="score[index]"
          min="0"
          max="10"
          step="1"
        />
        <span>{{ score[index] }}</span>
      </div>
      <button type="submit">제출하기</button>
    </form>
  </div>
</template>

<script setup>
import { ref } from 'vue';

const { clazz, type, order } = history.state;
const itmes = ref([
  {
    text: 'no 1',
    name: 1
  },
  {
    text: 'no 2',
    name: 3
  },
  {
    text: 'no 3',
    name: 3
  }
]);
const score = ref(new Array(itmes.value.length).fill().map(() => 0));
</script>

<style scoped>
.estimation {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  height: 100vh;
  width: 100%;
}
.estimation > h1 {
  font-size: 64px;
  font-weight: 600;
}
.title {
  display: flex;
  justify-content: center;
  margin: 0 64px;
  margin-bottom: 10px;
}

form {
  width: 80%;
  display: flex;
  flex-direction: column;
  gap: 20px;
}

form > div {
  display: flex;
  flex-direction: column;
}

label {
  font-size: 24px;
  padding: 8px 10px;
}
input[type='range'] {
  overflow: hidden;
  height: 30px;
  -webkit-appearance: none;
  margin: 10px 0;
  width: 100%;
  background: transparent;
}

input[type='range']:focus {
  outline: none;
}

input[type='range']::-webkit-slider-runnable-track {
  width: 100%;
  height: 100%;
  cursor: pointer;
  border-radius: 5px;
  border: 2px solid #96b5ff;
}

input[type='range']::-webkit-slider-thumb {
  -webkit-appearance: none;
  width: 30px;
  height: 30px;
  background: #6149ff;
  box-shadow: 1px 1px 7px #6c6ad1;
  cursor: pointer;
  box-shadow: -100vw 0 0 100vw #96b5ff;
}
button {
  width: fit-content;
  border: 1px solid #96b5ff;
  background: #6149ff;
  color: white;
  padding: 20px 40px;
  border-radius: 10px;
  margin: auto;
}
</style>
