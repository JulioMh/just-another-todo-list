import { LOAD_TASK_LISTS_FAILED, LOAD_TASK_LISTS_SUCCESS } from '../actions/taskList'

const initialState = {
  allTaskLists: [],
  error: null
}

const reducer = (state = initialState, action) => {
  switch (action.type){
    case LOAD_TASK_LISTS_SUCCESS:
      return { allTaskLists: action.payload, error: null }
    case LOAD_TASK_LISTS_FAILED:
      return { allTaskLists: [], error: action.payload }
    default:
      return state
  }
}

export default reducer