<template>
  <div>
    <h1 class="">클라우드 세미나 결과화면</h1>
    <h2>top 3</h2>
    <div>
      <div>card1</div>
      <div>card2</div>
      <div>card3</div>
    </div>
    <div>
      <h2>all teams</h2>
      <div v-for="(team, idx) in teams" :key="idx">
        {{ team.teamNo }}
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue';

const DUMMY = [
  {
    teamNo: '1팀',
    subject: 'SOLID #1',
    member: ['철원', '윤서']
  },
  {
    teamNo: '2팀',
    subject: 'SOLID #2',
    member: ['철원', '윤서']
  },
  {
    teamNo: '3팀',
    subject: 'SOLID #3',
    member: ['철원', '윤서']
  },
  {
    teamNo: '4팀',
    subject: 'SOLID #4',
    member: ['철원', '윤서']
  },
  {
    teamNo: '5팀',
    subject: 'SOLID #5',
    member: ['철원', '윤서']
  },
  {
    teamNo: '6팀',
    subject: 'SOLID #6',
    member: ['철원', '윤서']
  },
  {
    teamNo: '7팀',
    subject: 'SOLID #7',
    member: ['철원', '윤서']
  }
];

const teams = ref(DUMMY);
</script>

<style scoped></style>
