import React from 'react'

const LogIn = () => {
  return (
    <>
    <h1>Log In</h1>
    <form>
      <label for="username">Username</label><br/>
      <input id="username" type="text" ></input>
      <br/><br/>
      <label for="password">Password</label><br/>
      <input id="password" type="password" ></input>
      <br/><br/>
      <button>Log in</button>
    </form>
    </>
    
  )
}

export default LogIn