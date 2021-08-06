export const LOG_IN = '[user] log in' 
export const LOG_IN_SUCCESS = '[user] log in success' 
export const LOG_IN_FAILED = '[user] log in failed' 

export const logIn = (username, password)=> ({
  type: LOG_IN,
  payload: {
    username,
    password
  }
})

export const logInSuccess = (jwtToken) => ({
  type: LOG_IN_SUCCESS,
  payload: jwtToken
})

export const logInFailed = (error) => ({
  type: LOG_IN_SUCCESS,
  payload: error
})