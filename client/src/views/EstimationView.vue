<template>
  <div class="estimation">
    <h1>평가하기</h1>
    <div class="title">
      <h2>{{ clazz }} | {{ type }}</h2>
    </div>
    <LoadingIcon v-show="complete" />
    <form>
      <div v-for="(item, index) in itmes" :key="item.id">
        <label :for="item.id">{{ item.title }}</label>
        <input
          type="range"
          :name="item.id"
          :id="item.id"
          v-model="score[index]"
          min="0"
          :max="item.score"
          step="1"
        />
        <span>{{ score[index] }}</span>
      </div>
      <button type="button" @click="submit">제출하기</button>
    </form>
  </div>
</template>

<script setup>
import { ref, watch } from 'vue';
import { getEstimationList, postEstimationSubmit } from '../apis/api.js';
import LoadingIcon from '../components/LoadingIcon.vue';
import router from '../router/index.js';

const { clazz, type, id } = history.state;
const complete = ref(true);
const itmes = ref([]);
const score = ref(0);
const submit = async () => {
  // id: 항목마다 id
  // socre: 항목별 점수
  const body = [];
  itmes.value.forEach((v, index) => {
    body.push({
      id: v.id,
      score: +score.value[index]
    });
  });

  await postEstimationSubmit(body, id);

  router.push('/');
};

watch(async () => {
  const tmp = await getEstimationList();
  itmes.value = tmp;
  score.value = new Array(itmes.value.length).fill().map(() => 0);
  complete.value = false;
});
</script>

<style scoped>
.estimation {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  /* height: 100vh; */
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
  border: 2px solid var(--light-blue);
}

input[type='range']::-webkit-slider-thumb {
  -webkit-appearance: none;
  width: 30px;
  height: 30px;
  background: var(--blue);
  box-shadow: 1px 1px 7px #6c6ad1;
  cursor: pointer;
  box-shadow: -100vw 0 0 100vw var(--light-blue);
}
button {
  width: fit-content;
  border: 1px solid var(--light-blue);
  background: var(--blue);
  color: white;
  padding: 20px 40px;
  border-radius: 10px;
  margin: auto;
  cursor: pointer;
}
</style>
