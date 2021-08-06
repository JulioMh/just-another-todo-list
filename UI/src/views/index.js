import React, { useEffect, useState } from 'react'
import { useDispatch } from 'react-redux'
import { pageLoaded } from '../application/actions/ui'
import { loadTasks } from '../application/actions/task'
import { logIn } from '../application/actions/user'
import TaskList from './TaskList'
import Task from './Task'
import LogIn from './LogIn'

const App = () => {
  const [taskListId, setTaskListId] = useState(undefined)
  const [userId] = useState(undefined)
  const dispatch = useDispatch()

  useEffect(() => {
    dispatch(loadTasks(taskListId))
  }, [dispatch, taskListId])
  

  useEffect(() => {
    dispatch(pageLoaded(userId))
  }, [dispatch, userId])

  const logIn = (user) => { dispatch(logIn(user)) }

  const updateTaskListId = id => { setTaskListId(id) }

  const taskUI = taskListId ?
    (<Task/>)
    :(<TaskList onClick = { updateTaskListId }/>)
  
  return (
    <>
    {
      userId ? taskUI
      : <LogIn/>
    }
      
    </>
  )
}

export default App