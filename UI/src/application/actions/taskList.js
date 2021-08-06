export const LOAD_TASK_LISTS = '[taskList] load'
export const LOAD_TASK_LISTS_FAILED = '[taskList] load failed'
export const LOAD_TASK_LISTS_SUCCESS = '[taskList] load success'

export const loadTaskLists = userId => ({
  type: LOAD_TASK_LISTS,
  payload: userId
})

export const loadTaskListSuccess = tasks => ({
  type: LOAD_TASK_LISTS_SUCCESS,
  payload: tasks
})

export const loadTaskListFailed = error => ({
  type: LOAD_TASK_LISTS_FAILED,
  payload: error
})
