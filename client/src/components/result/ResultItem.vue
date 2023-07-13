<template>
  <div class="container" @click="goDetailPage">
    <div class="item">
      <div>TEAM: {{ props.team.subjectOrder }} 팀</div>
      <div>주제: {{ props.team.seminarTypeName }}</div>
      <div>팀원: {{ printMemberList }}</div>
    </div>
  </div>
</template>
<script setup>
import { computed } from 'vue';
import { useRouter } from 'vue-router';

const props = defineProps({
  team: Object
});

const router = useRouter();

const goDetailPage = () => {
  const memberId = parseInt(JSON.parse(sessionStorage.getItem('member')).id);

  for (const el of props.team.memberList) {
    if (el.id === memberId) {
      router.push(`/detail/${props.team.subjectId}/${memberId}`);
      return;
    }
  }
  alert('자기 팀만 선택하세요요욧!!!!!');
};

const printMemberList = computed(() => {
  return props.team.memberList.map((el) => el.name).join(', ');
});
</script>

<style scoped>
.container {
  margin: 10px;
  background-color: #eee;
  width: 375px;
  height: 150px;
  border-radius: 20px;
  display: flex;
  justify-content: center;
  align-items: center;
}
.item {
  width: 80%;
  font-size: 20px;
}
</style>
