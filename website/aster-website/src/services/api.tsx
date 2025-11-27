import axios from 'axios'

const api = axios.create({ 
  baseURL: 'http://aster-backend-env.eba-yqmhtgkn.sa-east-1.elasticbeanstalk.com/'
})

export default api
