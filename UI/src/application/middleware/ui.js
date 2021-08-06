import { PAGE_LOADED, SET_LOADING_ON } from '../actions/ui'
import * as taskListActions from '../actions/taskList'

const pageLoadedFlow = ({ log }) => ({ dispatch }) => next => async action => {
  next(action)

  if(action.type === PAGE_LOADED) {
    log('page loaded')
    dispatch(taskListActions.loadTaskLists(action.payload))
  }
}

export const uiMiddleware = [
  pageLoadedFlow
] 