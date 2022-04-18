import React from 'react'
import { NavLink } from 'react-router-dom'

export default function CustomerDashboard() {

  const Cust=localStorage.getItem('customerDetails');
  console.log(Cust.firstName);
  console.log(Cust.lastName);
  const logout=()=>{
    window.localStorage.clear();
    window.location.href="/login"
  }

  const deleteCust=()=>{
    window.location.href('/deleteCustomerAccount')
  }
  return (
    <>
    <div className="mt-3">
      <h2>Welcome {Cust.firstName} {Cust.lastName}</h2>
      <h4>Your Account</h4>
      <nav className="navbar navbar-expand-lg navbar-light bg-light">
          <div className="container-fluid">
              <div className="collapse navbar-collapse justify-content-center" id="navbar">
                  <ul className="navbar-nav">
                      <li className="nav-item">
                      <NavLink className="nav-link" to="/update">Update Details</NavLink>
                      </li>
                      <li className="nav-item">
                      <button className="btn btn-danger" onClick={deleteCust} to="/deleteCustomerAccount">Delete Account</button>
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
