export const LOAD_TASKS = '[task] load'
export const LOAD_TASK_FAILED = '[task] load failed'
export const LOAD_TASK_SUCCESS = '[task] load success'

export const CREATE_TASK = '[task] create'
export const CREATE_TASK_FAILED = '[task] create failed'
export const CREATE_TASK_SUCCESS = '[task] create success'

export const UPDATE_TASK = '[task] update'
export const UPDATE_TASK_FAILED = '[task] update failed'
export const UPDATE_TASK_SUCCESS = '[task] update success'

export const loadTask = taskListId => ({
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

export const createTask = task => taskListId => ({
  type: CREATE_TASK,
  payload: { task, taskListId }
})
