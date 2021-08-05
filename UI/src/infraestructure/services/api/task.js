import axios from 'axios';


const taskService = auth => ({
  getAll: async (taskListId) => {
    const response = await axios.get(`http://localhost:8080/taskLists/${taskListId}/tasks`, auth)

    return response.data
  },
  create: async (task, taskListId) => {
    const response = await axios.post(`http://localhost:8080/taskLists/${taskListId}/tasks`, task, auth)
      .catch(error => ({
        status: error.response.status,
        data: error.response.data
      }))
    return response.data;
  }
})

export default taskService;