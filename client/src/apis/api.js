import axios from 'axios';

const BASE_URL = 'http://192.168.0.85:8080';
// const BASE_URL = 'http://localhost:8080/';

export const getclassNameAndSemiarType = async () => {
  return await axios
    .get(BASE_URL + '/api/classes')
    .then((v) => v.data.data)
    .catch((e) => console.error(e));
};

export const getSubjectWithTeamList = async (classId, seminarTypeId) => {
  return await axios
    .get(BASE_URL + `/api/estimation/result/classes/${classId}/seminars/${seminarTypeId}`)
    .then((v) => v.data.data)
    .catch((e) => console.error(e));
};

export const getEstimationList = async () => {
  return await axios
    .get(`${BASE_URL}/api/estimation/other`)
    .then((v) => v.data.data)
    .catch((e) => console.error(e));
};

export const postEstimationSubmit = async (body, subjectNo) => {
  return await axios
    .post(BASE_URL + `/api/estimation/other/subjects/${subjectNo}`, body)
    .catch((e) => console.error(e));
};

export const postLogin = async (username, password) => {
  return await axios
    .post(BASE_URL + '/api/auth/login', {
      username,
      password
    })
    .catch((e) => console.error(e));
};

export const logout = async () => {
  return await axios.get(BASE_URL + '/api/auth/logout').catch((e) => console.error(e));
};
