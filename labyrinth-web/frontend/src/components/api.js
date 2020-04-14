import axios from 'axios'

const AXIOS = axios.create({
   baseURL: 'http://localhost:8080/',
   timeout: 1000,

})

export default {
    levels() {
        return AXIOS.get('/levels')
    }
}