import axios from 'axios';


const taskService = (configuration) => ({
  getAll: async (taskListId) => {
    const response = await axios.get(`${configuration.baseUrl}/taskLists/${taskListId}/tasks`, configuration)

    return response.data
  },
  create: async (task, taskListId) => {
    const response = await axios.post(`${configuration.baseUrl}/taskLists/${taskListId}/tasks`, task, configuration)
      .catch(error => ({
        status: error.response.status,
        data: error.response.data
      }))
    return response.data;
  }
})

export default taskService;