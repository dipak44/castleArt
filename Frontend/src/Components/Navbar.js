import React from 'react'
import { NavLink } from 'react-router-dom'
import '../index.css'

export default function Navbar() {
  return (
      <>
    <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
        <div className="container-fluid">
            <div className="collapse navbar-collapse justify-content-center" id="navbar">
                <ul className="navbar-nav">
                    <li className="nav-item">
                    <NavLink className="nav-link" to="/">Home</NavLink>
                    </li>
                    <li className="nav-item">
                    <NavLink className="nav-link" to="/category">Categories</NavLink>
                    </li>
                    <li className="nav-item">
                    <NavLink className="nav-link" to="/handicrafts">Handicarfts</NavLink>
                    </li>
                    <li className="nav-item">
                    <NavLink className="nav-link" to="/artistservice">Artist at Home</NavLink>
                    </li>
                    <li className="nav-item">
                    <NavLink className="nav-link" to="/bulk">Bulk-Orders</NavLink>
                    </li>
                    <li className="nav-item">
                    <NavLink className="nav-link" to="/login">Customer Login</NavLink>
                    </li>
                    <li className="nav-item">
                    <NavLink className="nav-link" to="/artistlogin">Artist Login</NavLink>
                    </li>
                    <li className="nav-item">
                    <NavLink className="nav-link" to="/about">About Us</NavLink>
                    </li>
                    <li className="nav-item">
                    <NavLink className="nav-link" to="/contact">Contact Us</NavLink>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    </>
  )
}
