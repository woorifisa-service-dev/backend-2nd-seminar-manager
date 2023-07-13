<template>
  <div class="estimation">
    <h1>Team select</h1>
    <div>
      <div class="title">
        <h2>{{ clazz }} | {{ type }}</h2>
      </div>
      <div class="table">
        <table>
          <thead>
            <tr>
              <td>order</td>
              <td>title</td>
              <td>teams</td>
            </tr>
          </thead>
          <LoadingIcon v-show="complete" />
          <tbody>
            <tr v-for="team in teamList" :key="team.order" @click="() => goEstimation(team)">
              <td>{{ team.order }}</td>
              <td>{{ team.title }}</td>
              <td>{{ team.teams.join(', ') }}</td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, watch } from 'vue';
import { goPage } from '../utils/pages';
import { getSubjectWithTeamList } from '../apis/api.js';
import LoadingIcon from '../components/LoadingIcon.vue';

const { clazz, type } = history.state;
const complete = ref(true);
console.log(clazz, type);

// const teamList = ref([
//   { order: 1, title: 'title1', teams: ['1', '2', '3'] },
//   { order: 2, title: 'title2', teams: ['12', '22', '32'] },
//   { order: 3, title: 'title3', teams: ['13', '23', '33'] },
//   { order: 4, title: 'title3', teams: ['13', '23', '33'] },
//   { order: 5, title: 'title3', teams: ['13', '23', '33'] },
//   { order: 6, title: 'title3', teams: ['13', '23', '33'] },
//   { order: 7, title: 'title3', teams: ['13', '23', '33'] }
// ]);
const teamList = ref([]);
const goEstimation = (team) => {
  goPage({
    name: 'estimation',
    state: {
      clazz,
      type,
      id: team.id
    }
  });
};

watch(async () => {
  const list = await getSubjectWithTeamList(clazz, type);

  console.log(list);
  const subjectInfoes = [];
  list?.forEach((a) => {
    subjectInfoes.push({
      order: a.subjectOrder,
      title: a.subjectTitle,
      teams: a.memberList.map((m) => m.name),
      id: a.subjectId
    });
  });
  teamList.value = subjectInfoes;
  complete.value = false;
});
</script>

<style scoped>
.estimation {
  height: 100vh;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}
.estimation > h1 {
  font-size: 64px;
  font-weight: 600;
}
.estimation > div {
  width: 100%;
}
.title {
  display: flex;
  justify-content: center;
  margin: 0 64px;
  margin-bottom: 10px;
}
.table {
  width: 100%;
  display: flex;
  justify-content: center;
}
table {
  font-size: 32px;
  border-collapse: collapse;
  width: 80%;
}
thead {
  width: 100%;
  border-bottom: 2px solid black;
  background: var(--blue);
  color: white;
}
table td {
  border-bottom: 1px solid black;
  text-align: center;
}
tbody tr {
  cursor: pointer;
}
tbody tr:nth-child(2n) {
  background: rgb(246, 246, 246);
}
</style>
