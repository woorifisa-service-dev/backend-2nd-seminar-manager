<template>
  <div>
    <h1 style="font-size: 20px font-weight: bold;"># 백엔드 세미나 결과화면</h1>
    <PrintResultView :top3="top3" :allTeams="allTeams" />
  </div>
</template>

<script setup>
import { ref, watchEffect } from 'vue';
import PrintResultView from '../../components/result/PrintResultView.vue';
import { getAllTeam, getTop3 } from '../../apis/api';

const allTeams = ref([]);
const top3 = ref([]);

watchEffect(async () => {
  const dataTop3 = await getTop3(1, 2);
  top3.value = dataTop3.data;

  const data = await getAllTeam(1, 2);
  allTeams.value = data.data;
});
</script>

<style scoped></style>
