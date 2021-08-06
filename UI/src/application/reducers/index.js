import { combineReducers } from 'redux'
import taskReducer from './task'
import uiReducer from './ui'
import taskListReducer from './taskList'

const reducers = combineReducers({
  tasks: taskReducer,
  taskList: taskListReducer,
  ui: uiReducer
})

export default reducers