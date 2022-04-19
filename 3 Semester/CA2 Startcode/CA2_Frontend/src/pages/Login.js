import React from 'react'

const Login = ({ performLogin, onChange, loggedIn, performLogout, username }) => {
    return (
        <div>
        <form onChange={onChange} >
       
        {!loggedIn ? (
            <div>
                <h2>Login</h2>
                <input placeholder="User Name" id="username" />
                <input placeholder="Password" id="password" />
                <button onClick={performLogin}>Login</button>
            </div>
        ) : (
            <div>
                <h2>You are logged in as { username }</h2>
                <button onClick={performLogout}>Logout</button>
            </div>
        )}
        </form>
    </div>
    )
}

export default Login