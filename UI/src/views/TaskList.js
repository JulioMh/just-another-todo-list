import React from 'react'
import { useSelector } from 'react-redux'
import { getTaskLists } from '../application/selectors/taskList'
import { getLoading } from '../application/selectors/ui'

const TaskList = ({ onClick }) => {
  const loading = useSelector(getLoading)
  const taskLists = useSelector(getTaskLists)

  return (
    <>
      <h1>Tasks Lists</h1> 
      { loading ? 'Loading task lists...' : (
        <ul>
          {taskLists.map(({ id, name }) => (
            <li key = {id} onClick={() => onClick(id)}>
              {name}
            </li>
          ))}
        </ul>
      )
        }
    </>
  )
}

export default TaskList