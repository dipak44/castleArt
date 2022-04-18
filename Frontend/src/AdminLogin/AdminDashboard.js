import React from 'react'
import { NavLink } from 'react-router-dom'

export default function AdminDashboard() {

  const deleteCustomer=()=>{
    window.location.href='/deletecustomer'
  }

  const deleteArtist=()=>{
    window.location.href='/deleteartist'
  }

  const logout=()=>{
    window.localStorage.clear();
    window.location.href="/login"
  }
  
  return (
    <>
    <div className="mt-3">
      {/* <h2>Welcome {Cust.firstName} {Cust.lastName}</h2> */}
      <h4>Your Account</h4>
      <nav className="navbar navbar-expand-lg navbar-light bg-light">
          <div className="container-fluid">
              <div className="collapse navbar-collapse justify-content-center" id="navbar">
                  <ul className="navbar-nav">
                      <li className="nav-item">
                      <NavLink className="nav-link" to="/update">Update Details</NavLink>
                      </li>
                      <li className="nav-item">
                      <button className="btn btn-danger" onClick={deleteCustomer} to="/deletecustomer">Delete Account</button>
                      </li>
                      <li className="nav-item">
                      <button className="btn btn-danger" onClick={deleteArtist} to="/deletecustomer">Delete Account</button>
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
    </div>
    </>
  )
}
