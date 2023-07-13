<template>
  <div>
    <h1>평가하기</h1>
    <div>
      <h2>{{ clazz }}</h2>
      <h2>{{ type }}</h2>
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

<style lang="scss" scoped></style>
