import axios from 'axios';


const taskListService = (configuration) => ({
  getAll: async (userId) => {
    const response = await axios.get(`${configuration.baseUrl}/users/${userId}/taskLists`, configuration)

    return response.data
  },
  create: async (taskList, userId) => {
    const response = await axios.post(`${configuration.baseUrl}/users/${userId}/taskLists`, taskList, configuration)
      .catch(error => ({
        status: error.response.status,
        data: error.response.data
      }))
    return response.data;
  }
})

export default taskListService;