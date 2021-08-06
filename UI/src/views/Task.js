import React from 'react'
import { useSelector } from 'react-redux'
import { getTasks } from '../application/selectors/task'
import { getLoading } from '../application/selectors/ui'

const Task = () => {
  const tasks = useSelector(getTasks)
  const loading = useSelector(getLoading)

  return (
    <>
      <h1>Tasks</h1> 
      { loading ? 'Loading task...' : (
        <ul>
          {tasks.map((task, index) => (
            <li key = {index}>
              {task.description}
            </li>
          ))}
        </ul>
      )
        }
    </>
  )
}

export default Task