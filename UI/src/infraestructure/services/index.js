import log from './logger/console'
import api from './api'

const baseUrl = 'http://localhost:8080'

const auth = {
  username: 'kilojulio',
  password: 'patata'
}

const configuration = {
  auth,
  baseUrl
}

export const service = {
  log, 
  api: api(configuration)
}