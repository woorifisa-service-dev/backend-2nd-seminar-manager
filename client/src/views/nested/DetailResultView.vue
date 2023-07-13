<template>
  <div class="container">
    <div class="card">
      <h1 class="card-header">[ 팀 평가 결과 ]</h1>
      <hr />

      <div class="card-main">
        <div class="score-wrap">
          <div class="score-item">
            <div class="score-item-title">강사 평가 점수:</div>
            <div class="score-item__score">
              {{ resultScore.teacherScore }}
            </div>
          </div>
          <div class="score-item">
            <div class="score-item-title">멘토 평가 점수:</div>
            <div class="score-item__score">
              {{ resultScore.mentorScore }}
            </div>
          </div>
          <div class="score-item">
            <div class="score-item-title">타팀 평가 점수:</div>
            <div class="score-item__score">
              {{ resultScore.othersScore }}
            </div>
          </div>
          <div class="break-line"></div>

          <div class="score-item">
            <div class="score-item-title">총점:</div>
            <div class="score-item__score txt-bold">
              {{ resultScore.totalScore }}
            </div>
          </div>
        </div>
      </div>

      <h1 class="card-header">[ 팀 내부 평가 결과 ]</h1>
      <hr />

      <div class="card-footer">
        <div class="score-wrap">
          <div class="score-item">
            <div class="score-item-title">내부 평가 점수:</div>
            <div class="score-item__score">
              {{ resultScore.teamMemberTotalScore }}
            </div>
          </div>
          <div class="score-item">
            <div class="score-item-title">내부 평가 평균 점수:</div>
            <div class="score-item__score">
              {{ resultScore.teamMemberAvgScore }}
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, watchEffect } from 'vue';
import { getDetailTeam } from '../../apis/api';

const resultScore = ref({});

watchEffect(async () => {
  const result = await getDetailTeam(1, 1, 3);
  console.log('result: ', result.data);
  resultScore.value = result.data;
});
</script>

<style scoped>
.container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}
.card {
  width: 500px;
  height: 600px;
}

.card-header {
  text-align: center;
  font-weight: 700;
}

.card-main {
  height: 60%;
}
.card-footer {
  height: 40%;
}

.score-wrap {
  margin: 0 auto;
  padding: 0 30px;
}

.score-item {
  display: flex;
  justify-content: space-between;
  font-size: 32px;
  margin: 20px 0;
}

.break-line {
  background-color: black;
  height: 1px;
}

.txt-bold {
  font-weight: 700;
  color: #6149ff;
}
</style>
