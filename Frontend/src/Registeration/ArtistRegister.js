import React, { useState } from 'react'
import axios from 'axios'

const style2={
    color: "darkred", fontSize: "2rem", textAlign: "center", marginTop: "10px"
}

const label1={
    fontSize:"18px"
}

export default function ArtistRegister() {

    const[firstName,setfirstName]=useState("");
    const[lastname,setlastName]=useState("");
    const[gender,setGender]=useState("");
    const[artistBio,setArtistBio]=useState("");
    const[artistEmail,setArtistEmail]=useState("");
    const[artistPrice,setArtistPrice]=useState("");
    const[availiblity,setAvailiblity]=useState("");
    const[status,setStatus]=useState("");
    const[phoneNo,setPhoneNo]=useState("");
    const[address,setAddress]=useState("");
    const[city,setCity]=useState("");
    const[state,setState]=useState("");
    const[postalCode,setpostalCode]=useState("");
    const[username,setUsername]=useState("");
    const[password,setPassword]=useState("");

    const handleClick=(e)=>{
        e.preventDefault()
        const artist = {firstName,lastname,gender,artistBio,artistEmail,artistPrice,phoneNo,address,city,state,postalCode,username,password}
        console.log(artist);
        fetch("http://localhost:9292/api/home/artist-signup",{
          method:"POST",
          headers:{"Content-Type":"application/json"},
          body:JSON.stringify(artist)
        }).then(()=>{
          window.location.href = "/artistlogin";
          console.log("New Artist Added")
        }).catch((err)=> {console.log(err);})
      } 

  return (
    <>
    <div className="container m-5">       
        <div>
            <h1 className="animate__animated animate__pulse animate__infinite" style={style2}>Registration of Artist</h1>
            <hr/>
            <div className="container offset-2">
                <form>
                    <div className="row">
                        <div className="form-outline mb-4 mt-3 col-4">
                            <label className="form-label" htmlFor="firstName" style={label1}>Artist First Name</label>
                            <input type="text" id="firstName" name="firstName" value={firstName} onChange={(e)=>setfirstName(e.target.value)} className="form-control" placeholder="Enter Your Name" />   
                        </div>
                        <div className="form-outline mb-4 mt-3 col-4">
                            <label className="form-label" htmlFor="lastname" style={label1}>Artist Last Name</label>
                            <input type="text" id="lastname" name="lastname" value={lastname} onChange={(e)=>setlastName(e.target.value)} className="form-control" placeholder="Enter Your Name" />   
                        </div>
                    </div>
                    <div className="row">
                        <div className="form-outline mb-4 col-8">
                            <label className="form-label" htmlFor="artistEmail" style={label1}>Email</label>
                            <input type="artistEmail" id="artistEmail" name="artistEmail" value={artistEmail} onChange={(e)=>setArtistEmail(e.target.value)} className="form-control" placeholder="Enter Your Email"/>               
                        </div>
                    </div>
                    <div className="row">
                        <div className="form-outline mb-4 col-4">
                            <label className="form-label" htmlFor="phoneNo" style={label1}>Mobile Number</label>
                            <input type="number" id="phoneNo" name="phoneNo" value={phoneNo} onChange={(e)=>setPhoneNo(e.target.value)} className="form-control" placeholder="Enter Your Mobile Number"/>                        
                        </div>
                        <div className="form-outline mb-4 mt-5 col-4">
                            <label className="form-label" htmlFor="gender" style={label1}>Gender : </label>&emsp;
                            <div id="gender" name="gender" className="form-check form-check-inline" value={gender}>
                            <input className="form-check-input" type="radio" name="gender" id="male" value="Male" onChange={(e)=>setGender(e.target.value)}/>
                            <label className="form-check-label" htmlFor="male">Male</label>
                            </div>
                            <div id="gender" className="form-check form-check-inline">
                            <input className="form-check-input" type="radio" name="gender" id="female" value="Female" onChange={(e)=>setGender(e.target.value)}/>
                            <label className="form-check-label" htmlFor="female">Female</label>
                            </div>
                            <div id="gender" className="form-check form-check-inline">
                            <input className="form-check-input" type="radio" name="gender" id="other" value="Other" onChange={(e)=>setGender(e.target.value)}/>
                            <label className="form-check-label" htmlFor="other">Other</label>
                            </div>             
                        </div>
                    </div>
                    <div className="row">
                        <div className="form-outline mb-4 col-4">
                        <label className="form-label" htmlFor="ArtistBio" style={label1}>Artist Bio</label>
                        <input type="text" id="ArtistBio" name="ArtistBio" value={artistBio} onChange={(e)=>setArtistBio(e.target.value)} className="form-control" placeholder="Enter Your Bio"/>                       
                        </div>
                        <div className="form-outline mb-4 col-4">
                            <label className="form-label" htmlFor="artistPrice" style={label1}>Price</label>
                            <input type="text" id="artistPrice" name="artistPrice" value={artistPrice} onChange={(e)=>setArtistPrice(e.target.value)} className="form-control" placeholder="Enter Price"/>
                        </div>
                    </div>
                    <div className="row">
                        <div className="form-outline mb-4 col-4">
                            <label className="form-label" htmlFor="availiblity" style={label1}>Availiblity for Artist At Home</label>
                            <input type="text" id="availiblity" name="availiblity" value={availiblity} onChange={(e)=>setAvailiblity(e.target.value)} className="form-control" placeholder="Enter True or False"/>
                            <p>Are you availible for Service then true o.w. false</p>
                        </div>
                        <div className="form-outline mb-4 col-4">
                            <label className="form-label" htmlFor="status" style={label1}>Status for Applicatble of Service</label>
                            <input type="text" id="status" name="status" value={status} onChange={(e)=>setStatus(e.target.value)} className="form-control" placeholder="Enter True or False"/>
                            <p>Do you want to Apply for Artist At Home Service then true o.w. false</p>
                        </div>
                    </div>
                    <div className="row">
                        <div className="form-outline mb-4 col-8">
                            <label className="form-label" htmlFor="address" style={label1}>Address</label>
                            <input type="text" id="address" name="address" value={address} onChange={(e)=>setAddress(e.target.value)} className="form-control" placeholder="Address(House No, Building, Street, Area)"/>                       
                        </div>
                    </div>
                    <div className="row">
                        <div className="form-outline mb-4 col-3">
                        <label className="form-label" htmlFor="city" style={label1}>City</label>
                        <input type="text" id="city" name="city" value={city} onChange={(e)=>setCity(e.target.value)} className="form-control" placeholder="City/District"/>                       
                        </div>
                        <div className="form-outline mb-4 col-3">
                        <label className="form-label" htmlFor="state" style={label1}>State</label>
                        <input type="text" id="state" name="state" value={state} onChange={(e)=>setState(e.target.value)} className="form-control" placeholder="State"/>
                        </div>
                        <div className="form-outline mb-4 col-2">
                        <label className="form-label" htmlFor="postalCode" style={label1}>Pin Code</label>
                        <input type="text" id="postalCode" name="postalCode" value={postalCode} onChange={(e)=>setpostalCode(e.target.value)} className="form-control" placeholder="Enter Pin Code"/>
                        </div>
                    </div>
                    <div className="row">
                        <div className="form-outline mb-4 col-4">
                            <label className="form-label" htmlFor="username" style={label1}>Username</label>
                            <input type="text" id="username" name="username" value={username} onChange={(e)=>setUsername(e.target.value)} className="form-control" placeholder="Enter Your Username"/>                       
                        </div>
                        <div className="form-outline mb-4 col-4">
                            <label className="form-label" htmlFor="password" style={label1}>Password</label>
                            <input type="password" id="password" name="password" value={password} onChange={(e)=>setPassword(e.target.value)}className="form-control" placeholder="Enter Password"/>
                        </div>
                    </div>
                    <div className="row">
                        
                        {/* <div className="form-outline mb-4 col-4">
                            <label className="form-label" htmlFor="cpassword" style={label1}>Confirm password</label>
                            <input type="password" id="cpassword" name="cpassword" value={.cpassword} className="form-control" placeholder="Retype Password"/>                      
                        </div> */}
                    </div>
                    <div className="row offset-3">
                        <button type="submit" className="btn btn-primary col-3" onClick={handleClick}>Register</button>
                    </div>
                </form>
            </div>
        </div>
    </div>    
    </>
  )
}
