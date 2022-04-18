import React from 'react'
import { NavLink } from 'react-router-dom'
import './Contactus.css'

export default function Contactus() {
  return (
    <>
    <h1 className="my-3">Contact Us</h1>
    <div className="col-6 offset-3">
      <div type="text" className="contact-form-text">  
        <div className="contact-form">
            <h3>Call Us</h3>
            <p>9876543210</p>
            {/* <i className="fa">&#xf232;</i>
            <NavLink to="https://twitter.com/PrasadP41592644?t=6_vwR2hHWZolx87MhrVCzgs=08" className="fa fa-facebook"></NavLink> 
            <NavLink to="https://www.facebook.com/shubhamdighe.shubhamdighe" className="fa fa-twitter"></NavLink> */}
        </div>  
      </div>
      <div type="text" className="contact-form-text"> 
        <div className="contact-form" >
            <h3>Email Us</h3>
            <p>castleart777@gmail.com</p>
        </div>  
      </div>
      <div type="text" className="contact-form-text"> 
        <div className="contact-form" >
            <h3>Visit Us</h3>
            <address>Shop No: 26, Dilax chowk, Pimpri, Pune, Maharashtra 411038</address>
        </div>  
      </div>
    </div>
    </>
  )
}
