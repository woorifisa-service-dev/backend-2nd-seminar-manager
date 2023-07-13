<template>
  <div class="estimation_select">
    <h1>estimation select</h1>
    <div class="select_wrap_wrap">
      <div class="select_wrap">
        <h2>class select</h2>
        <select name="class" id="class" v-model="selectedClass">
          <option value="none" disabled selected>다음 중 하나를 선택해주세요</option>
          <option v-for="(type, index) in classTypes" :key="index" :value="type">
            {{ type }}
          </option>
        </select>
      </div>
      <div class="select_wrap">
        <h2>seminar type select</h2>
        <select name="class" id="type" v-model="selectedType">
          <option value="none" disabled selected>다음 중 하나를 선택해주세요</option>
          <option v-for="(type, index) in seminarTypes[selectedClass]" :key="index" :value="type">
            {{ type }}
          </option>
        </select>
      </div>
    </div>
    <button
      :disabled="selectedClass === 'none' || selectedType === 'none'"
      @click="
        () =>
          goPage({ name: `estimation list`, state: { clazz: selectedClass, type: selectedType } })
      "
    >
      평가하러 가기
    </button>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import { goPage } from '../utils/pages.js';

const classTypes = ref(['service', 'engineering', 'ai']);
const seminarTypes = ref({
  service: ['front', 'back', 'cloud'],
  engineering: ['1', '2', '3'],
  ai: ['1', '2', '3']
});
const selectedClass = ref('none');
const selectedType = ref('none');
</script>

<style scoped>
.estimation_select {
  height: 100vh;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  gap: 16px;
}
.estimation_select > h1 {
  font-size: 48px;
  font-weight: 700;
}

.select_wrap_wrap {
  display: flex;
  gap: 64px;
  flex-direction: row;
}
.select_wrap {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.select_wrap > h2 {
  font-size: 32px;
}
.select_wrap > select {
  height: 32px;
}

button {
  border: 1px solid black;
  padding: 10px 20px;
  border-radius: 30px;
  background: blue;
  color: white;
  font-size: 24px;
  cursor: pointer;
  margin: 20px;
}

button:disabled {
  border: 1px solid black;
  padding: 10px 20px;
  border-radius: 30px;
  background: rgb(133, 133, 152);
  color: white;
  font-size: 24px;
  margin: 20px;
  cursor: not-allowed;
}
</style>
