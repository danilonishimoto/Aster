import axios from 'axios'

const api = axios.create({ 
  // baseURL: 'http://localhost:8080/api',
  baseURL: 'https://aster-backend-env.eba-yqmhtgkn.sa-east-1.elasticbeanstalk.com/'
})

export default api
