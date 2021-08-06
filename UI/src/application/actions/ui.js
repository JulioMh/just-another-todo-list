export const PAGE_LOADED = '[ui] page loaded'
export const SET_LOADING_OFF = '[ui] set loading off'
export const SET_LOADING_ON = '[ui] set loading on'

export const pageLoaded = userId => ({
  type: PAGE_LOADED,
  payload: userId
})

export const setLoading = isLoading => ({
  type: isLoading ? SET_LOADING_ON : SET_LOADING_OFF,
  payload: isLoading
})