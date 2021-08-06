import { logInSuccess, logInFailed, LOG_IN } from '../actions/user'
import * as uiAction from '../actions/ui'

const logIn = ({ api }) => ({ dispatch }) => next => async action => {
  if(action.type === LOG_IN) {
    try{
      dispatch(uiAction.SET_LOADING_ON)
      const jwtToken = await api.user.autheticate(action.payload)
      dispatch(uiAction.SET_LOADING_OFF)
      dispatch(logInSuccess(jwtToken))
    } catch(error) {
      dispatch(logInFailed(error))
    }
  }
  
  next(action)
}

export const userMiddleware = [
  logIn
]