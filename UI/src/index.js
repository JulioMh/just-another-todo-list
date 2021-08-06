import React from 'react';
import ReactDOM from 'react-dom';
import { Provider } from 'react-redux';
import { configureStore } from './application/store'
import { service } from './infraestructure/services'
import App from './views';

ReactDOM.render(
  <Provider store={configureStore(service)}>
    <App />
  </Provider>,
  document.getElementById('root')
);