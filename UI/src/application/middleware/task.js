import { loadTodo, LOAD_TASKS, LOAD_TASK_SUCCESS, LOAD_TASK_FAILED, loadTaskSuccess, loadTaskFailed } from '../actions/task'
import * as uiAction from '../actions/ui'

const loadTask = ({ api }) => ({ dispatch }) => next => async (action) => {
  next(action)

  if (action.type === LOAD_TASKS) {
    try {
      dispatch(uiAction.setLoading(true))
      const tasks = await api.task.getAll()
      dispatch(loadTaskSuccess(tasks))
      dispatch(uiAction.setLoading(false))
    } catch(error) {
      dispatch(loadTaskFailed(error))
    }
    
  }
}