import React from 'react'
import { NavLink } from 'react-router-dom'

export default function ArtistDashboard() {

  const logout=()=>{
    window.localStorage.clear();
    window.location.href="/login"
  }
  
  return (
    <>
    <h3>Your Account</h3>
    <nav className="navbar navbar-expand-lg navbar-light bg-light">
        <div className="container-fluid">
            <div className="collapse navbar-collapse justify-content-center" id="navbar">
                <ul className="navbar-nav">
                    <li className="nav-item">
                    <NavLink className="nav-link" to="/addproduct">Add Product</NavLink>
                    </li>
                    <li className="nav-item">
                    <NavLink className="nav-link" to="/">Availablability</NavLink>
                    </li>
                    <li className="nav-item">
                    <NavLink className="nav-link" to="/update">Update Details</NavLink>
                    </li>
                    <li className="nav-item">
                    <NavLink className="nav-link" to="/">Orders</NavLink>
                    </li>
                    <li className="nav-item">
                      <button className='btn btn-primary' onClick={logout}>Logout</button>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    </>
  )
}
