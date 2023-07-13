<template>
  <div>
    <h1 style="font-size: 20px font-weight: bold;"># 클라우드 세미나 결과화면</h1>
    <PrintResultView :top3="top3" :allTeams="allTeams" />
  </div>
</template>

<script setup>
import { ref } from 'vue';
import PrintResultView from '../../components/result/PrintResultView.vue';

const TOP3 = [
  {
    clazzName: '클라우드 서비스 개발',
    seminarTypeName: 'Web 3.0',
    subjectId: 20,
    subjectTitle: '백엔드 세미나',
    subjectOrder: 11,
    memberList: [
      {
        id: 9,
        name: '이은엽'
      },
      {
        id: 20,
        name: '김승연'
      }
    ]
  },
  {
    clazzName: '클라우드 서비스 개발',
    seminarTypeName: '인증과 인가',
    subjectId: 21,
    subjectTitle: '백엔드 세미나',
    subjectOrder: 12,
    memberList: [
      {
        id: 11,
        name: '박진영'
      },
      {
        id: 18,
        name: '김용민'
      }
    ]
  },
  {
    clazzName: '클라우드 서비스 개발',
    seminarTypeName: 'SOLID',
    subjectId: 19,
    subjectTitle: '백엔드 세미나',
    subjectOrder: 10,
    memberList: [
      {
        id: 3,
        name: '황철원'
      },
      {
        id: 4,
        name: '한윤서'
      }
    ]
  }
];

const DUMMY = [
  {
    clazzName: '클라우드 서비스 개발',
    seminarTypeName: 'Web 3.0',
    subjectId: 20,
    subjectTitle: '백엔드 세미나',
    subjectOrder: 11,
    memberList: [
      {
        id: 9,
        name: '이은엽'
      },
      {
        id: 20,
        name: '김승연'
      }
    ]
  },
  {
    clazzName: '클라우드 서비스 개발',
    seminarTypeName: '인증과 인가',
    subjectId: 21,
    subjectTitle: '백엔드 세미나',
    subjectOrder: 12,
    memberList: [
      {
        id: 11,
        name: '박진영'
      },
      {
        id: 18,
        name: '김용민'
      }
    ]
  },
  {
    clazzName: '클라우드 서비스 개발',
    seminarTypeName: 'SOLID',
    subjectId: 19,
    subjectTitle: '백엔드 세미나',
    subjectOrder: 10,
    memberList: [
      {
        id: 3,
        name: '황철원'
      },
      {
        id: 4,
        name: '한윤서'
      }
    ]
  },
  {
    clazzName: '클라우드 서비스 개발',
    seminarTypeName: 'Web 3.0',
    subjectId: 20,
    subjectTitle: '백엔드 세미나',
    subjectOrder: 11,
    memberList: [
      {
        id: 9,
        name: '이은엽'
      },
      {
        id: 20,
        name: '김승연'
      }
    ]
  },
  {
    clazzName: '클라우드 서비스 개발',
    seminarTypeName: '인증과 인가',
    subjectId: 21,
    subjectTitle: '백엔드 세미나',
    subjectOrder: 12,
    memberList: [
      {
        id: 11,
        name: '박진영'
      },
      {
        id: 18,
        name: '김용민'
      }
    ]
  },
  {
    clazzName: '클라우드 서비스 개발',
    seminarTypeName: 'SOLID',
    subjectId: 19,
    subjectTitle: '백엔드 세미나',
    subjectOrder: 10,
    memberList: [
      {
        id: 3,
        name: '황철원'
      },
      {
        id: 4,
        name: '한윤서'
      }
    ]
  },
  {
    clazzName: '클라우드 서비스 개발',
    seminarTypeName: 'Web 3.0',
    subjectId: 20,
    subjectTitle: '백엔드 세미나',
    subjectOrder: 11,
    memberList: [
      {
        id: 9,
        name: '이은엽'
      },
      {
        id: 20,
        name: '김승연'
      }
    ]
  },
  {
    clazzName: '클라우드 서비스 개발',
    seminarTypeName: '인증과 인가',
    subjectId: 21,
    subjectTitle: '백엔드 세미나',
    subjectOrder: 12,
    memberList: [
      {
        id: 11,
        name: '박진영'
      },
      {
        id: 18,
        name: '김용민'
      }
    ]
  },
  {
    clazzName: '클라우드 서비스 개발',
    seminarTypeName: 'SOLID',
    subjectId: 19,
    subjectTitle: '백엔드 세미나',
    subjectOrder: 10,
    memberList: [
      {
        id: 3,
        name: '황철원'
      },
      {
        id: 4,
        name: '한윤서'
      }
    ]
  }
];

const allTeams = ref(DUMMY);
const top3 = ref(TOP3);
</script>
