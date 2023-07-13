<template>
  <div>
    <h1>Team select</h1>
    <div>
      <h2>{{ clazz }}</h2>
      <h2>{{ type }}</h2>
      <table>
        <thead>
          <tr>
            <td>order</td>
            <td>title</td>
            <td>teams</td>
          </tr>
        </thead>
        <tbody>
          <tr v-for="team in teamList" :key="team.order" @click="() => goEstimation(team)">
            <td>{{ team.order }}</td>
            <td>{{ team.title }}</td>
            <td v-for="(team, index) in team.teams" :key="index">{{ team }}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import { goPage } from '../utils/pages';

const { clazz, type } = history.state;
const teamList = ref([
  { order: 1, title: 'title1', teams: ['1', '2', '3'] },
  { order: 2, title: 'title2', teams: ['12', '22', '32'] },
  { order: 3, title: 'title3', teams: ['13', '23', '33'] }
]);
const goEstimation = (team) => {
  goPage({
    name: 'estimation',
    state: {
      clazz,
      type,
      order: team.order
    }
  });
};
</script>

<style lang="scss" scoped></style>
