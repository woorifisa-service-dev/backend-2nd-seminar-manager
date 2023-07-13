<template>
  <div>
    <br />
    <h2>[ TOP 3 ]</h2>
    <div class="flex-container">
      <div v-for="(team, idx) in props.top3" :key="idx">
        <ResultItem :team="team" />
      </div>
    </div>
    <br />
    <div>
      <h2>[ All Teams ]</h2>
      <div class="flex-container">
        <div v-for="(team, idx) in props.allTeams" :key="idx">
          <ResultItem :team="team" />
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import ResultItem from './ResultItem.vue';

const props = defineProps({
  top3: Object,
  allTeams: Object
});
</script>

<style scoped>
.flex-container {
  display: flex;
  flex-wrap: wrap;
}
</style>
