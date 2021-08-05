import log from './logger/console'
import api from './api'

const auth = {
  username: 'kilojulio',
  password: 'patata'
}

export const service = {
  log, 
  api: api(auth)
}