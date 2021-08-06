import taskService from './task'
import taskListService from './taskList'

const api = (configuration) => ({
  task: taskService(configuration),
  taskList: taskListService(configuration)
})

export default api