import { LOAD_TASK_LISTS, loadTaskListSuccess, loadTaskListFailed } from '../actions/taskList'
import * as uiAction from '../actions/ui'

const loadTaskLists = ({ api }) => ({ dispatch }) => next => async (action) => {
  next(action)

  if (action.type === LOAD_TASK_LISTS) {
    try {
      dispatch(uiAction.setLoading(true))
      console.log(action.payload)
      const taskLists = await api.taskList.getAll(action.payload)
      dispatch(loadTaskListSuccess(taskLists))
      dispatch(uiAction.setLoading(false))
    } catch(error) {
      dispatch(loadTaskListFailed(error))
    }
    
  }
}

export const taskListMiddleware = [
  loadTaskLists
]