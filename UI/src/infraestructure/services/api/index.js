import task from 'task'

const api = (auth) => ({
  task: task(auth)
})

export default api