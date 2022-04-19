import React from 'react'
import { Link, Outlet } from 'react-router-dom';

const Navbar = () => {
  return (
    <div>
        <nav>
            <Link to="/">Welcome</Link> |{" "}
            <Link to="/login">Login</Link> |{" "}
            <Link to="/user">User</Link> |{" "}
            <Link to="/admin">Admin</Link> |{" "}
            <Link to="/data">Data</Link>
        </nav>
        <Outlet />
    </div>
  )
}

export default Navbar