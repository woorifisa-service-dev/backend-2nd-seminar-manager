import axios from 'axios';

const BASE_URL = 'http://192.168.0.85:8080';

export const getclassNameAndSemiarType = async () => {
  await axios
    .get(BASE_URL, {
      withCredentials: true
    })
    .then((v) => console.log(v));
};
