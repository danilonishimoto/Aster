import axios from 'axios'

const api = axios.create({ 
  baseURL: 'https://aster-backend-env.eba-yqmhtgkn.sa-east-1.elasticbeanstalk.com/'
})

export default api
