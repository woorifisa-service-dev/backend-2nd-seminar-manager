<template>
  <div>
    <h1>estimation select</h1>
    <div>
      class select
      <select name="class" id="class" v-model="selectedClass">
        <option value="none" disabled selected>다음 중 하나를 선택해주세요</option>
        <option v-for="(type, index) in classTypes" :key="index" :value="type">
          {{ type }}
        </option>
      </select>
    </div>
    <div>
      seminar type select
      <select name="class" id="class" v-model="selectedType">
        <option value="none" disabled selected>다음 중 하나를 선택해주세요</option>
        <option v-for="(type, index) in seminarTypes[selectedClass]" :key="index" :value="type">
          {{ type }}
        </option>
      </select>
    </div>
    <div>
      <button @click="() => goPage(`/estimation`)">평가하러 가기</button>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import { goPage } from '../utils/pages.js';

const classTypes = ref(['service', 'engineering', 'ai']);
const seminarTypes = ref({
  none: ['다음 중 하나를 선택해주세요'],
  service: ['front', 'back', 'cloud'],
  engineering: ['1', '2', '3'],
  ai: ['1', '2', '3']
});
const selectedClass = ref('none');
const selectedType = ref('none');
</script>

<style lang="scss" scoped></style>
