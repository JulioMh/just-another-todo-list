export const LOAD_TASKS = '[task] load'
export const LOAD_TASK_FAILED = '[task] load failed'
export const LOAD_TASK_SUCCESS = '[task] load success'

export const loadTasks = taskListId => ({
  type: LOAD_TASKS,
  payload: taskListId
})

export const loadTaskSuccess = tasks => ({
  type: LOAD_TASK_SUCCESS,
  payload: tasks
})

export const loadTaskFailed = error => ({
  type: LOAD_TASK_FAILED,
  payload: error
})
