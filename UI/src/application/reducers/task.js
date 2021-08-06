import { LOAD_TASK_FAILED, LOAD_TASK_SUCCESS } from '../actions/task'

const initialState = {
  allTasks: [],
  error: null
}

const reducer = (state = initialState, action) => {
  switch (action.type){
    case LOAD_TASK_SUCCESS:
      return { allTasks: action.payload, error: null }
    case LOAD_TASK_FAILED:
      return { allTasks: [], error: action.payload }
    default:
      return state
  }
}

export default reducer