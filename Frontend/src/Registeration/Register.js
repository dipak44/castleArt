import React, { useState } from 'react'
import axios from 'axios'

const style1={
    color: "darkred", fontSize: "2rem", textAlign: "center", marginTop: "10px"
}

const label2={
    fontSize:"18px"
}

export default function Register() {

    // const[customerRegister,setCustomerRegister]=useState({
    //     cfname:"",
    //     clanme:"", 
    //     cemail:"",
    //     cmob:"",
    //     address:"",
    //     city:"",
    //     state:"",
    //     pin:"",
    //     uname:"",
    //     cpass:"",
    //     crpass:""
    // })

    // const [records,setRecords]=useState([])

    // const handleInput = (e) =>{
    //     const name=e.target.name;
    //     const value=e.target.value;
    //     console.log(name,value);
    //     setCustomerRegister({...customerRegister, [name]:value})

    //     axios.post("http://localhost:9292/customer-signup",{
    //         cfname: customerRegister.cfname,
    //         clanme:customerRegister.clanme,
    //         cemail:customerRegister.cemail,
    //         cmob:customerRegister.cmob,
    //         gender:customerRegister.gender,
    //         address:customerRegister.address,
    //         city:customerRegister.city,
    //         state:customerRegister.state,
    //         pin:customerRegister.pin,
    //         uname:customerRegister.uname,
    //         cpass:customerRegister.cpass,
    //         crpass:customerRegister.crpass

    //     }).then(res => {
    //         console.log(res.data);
    //     })
    // }

    // const handleSubmit = (e) =>{
    //     e.preventDefault();
    //     const newRecords={...customerRegister, id:new Date().getTime().toString()}
    //     console.log(records);
    //     setRecords([...records, newRecords]);
    // }
    const[firstName,setfirstName]=useState("");
    const[lastName,setlastName]=useState("");
    const[email,setEmail]=useState("");
    const[gender,setGender]=useState("");
    const[phoneNumber,setphoneNumber]=useState("");
    const[address,setAddress]=useState("");
    const[city,setCity]=useState("");
    const[state,setState]=useState("");
    const[postalCode,setpostalCode]=useState("");
    const[username,setUsername]=useState("");
    const[password,setPassword]=useState("");

    const handleClick=(e)=>{
        e.preventDefault();
        const customer = {firstName,lastName,email,phoneNumber,address,city,state,postalCode,username,password}
        console.log(customer);
        fetch("http://localhost:9292/api/home/customer-signup",{
          method:"POST",
          headers:{"Content-Type":"application/json"},
          body:JSON.stringify(customer)
        }).then(()=>{
          window.location.href = "/login";
          console.log("New Customer Added")
        }).catch((err)=> {console.log(err);})
      } 

  return (
    <>
    <div className="container m-5">       
        <div>
            <h1 className="animate__animated animate__pulse animate__infinite" style={style1}>Registration of Customer</h1>
            <hr/>
            <div className="container offset-2">
                <form action="#">
                    <div className="row">
                        <div className="form-outline mb-4 mt-3 col-4">
                            <label className="form-label" htmlFor="firstName" style={label2}>Your First Name</label>
                            <input type="text" id="firstName" name="firstName" className="form-control" placeholder="Enter Your First Name" value={firstName} onChange={(e)=>setfirstName(e.target.value)} />   
                        </div>
                        <div className="form-outline mb-4 mt-3 col-4">
                            <label className="form-label" htmlFor="lastName" style={label2}>Your Last Name</label>
                            <input type="text" id="lastName" name="lastName" className="form-control" placeholder="Enter Your Last Name" value={lastName} onChange={(e)=>setlastName(e.target.value)}/>               
                        </div>
                    </div>
                    <div className="row">
                        <div className="form-outline mb-4 col-8">
                            <label className="form-label" htmlFor="email" style={label2}>Email</label>
                            <input type="email" id="email" name="email" className="form-control" placeholder="Enter Your Email" value={email} onChange={(e)=>setEmail(e.target.value)}/>               
                        </div>
                    </div>
                    <div className="row">
                        <div className="form-outline mb-4 col-4">
                            <label className="form-label" htmlFor="phoneNumber" style={label2}>Mobile Number</label>
                            <input type="number" id="phoneNumber" name="phoneNumber" className="form-control" placeholder="Enter Your Mobile Number" value={phoneNumber} onChange={(e)=>setphoneNumber(e.target.value)}/>                        
                        </div>
                        <div className="form-outline mb-4 mt-5 col-4">
                            <label className="form-label" htmlFor="gender" style={label2}>Gender : </label>&emsp;
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
                        <div className="form-outline mb-4 col-8">
                            <label className="form-label" htmlFor="address" style={label2}>Address</label>
                            <input type="text" id="address" name="address" className="form-control" placeholder="Address(House No, Building, Street, Area)" value={address} onChange={(e)=>setAddress(e.target.value)}/>                       
                        </div>
                    </div>
                    <div className="row">
                        <div className="form-outline mb-4 col-3">
                            <label className="form-label" htmlFor="city" style={label2}>City</label>
                            <input type="text" id="city" name="city" className="form-control" placeholder="City/District" value={city} onChange={(e)=>setCity(e.target.value)}/>                       
                        </div>
                        <div className="form-outline mb-4 col-3">
                            <label className="form-label" htmlFor="state" style={label2}>State</label>
                            <input type="text" id="state" name="state" className="form-control" placeholder="State" value={state} onChange={(e)=>setState(e.target.value)}/>
                        </div>
                        <div className="form-outline mb-4 col-2">
                            <label className="form-label" htmlFor="postalCode" style={label2}>Pin Code</label>
                        <input type="text" id="postalCode" name="postalCode" className="form-control" placeholder="Enter Pin Code" value={postalCode} onChange={(e)=>setpostalCode(e.target.value)}/>
                        </div>
                    </div>
                    <div className="row">
                        <div className="form-outline mb-4 col-4">
                            <label className="form-label" htmlFor="username" style={label2}>Username</label>
                            <input type="text" id="username" name="username" className="form-control" placeholder="Enter Your Username" value={username} onChange={(e)=>setUsername(e.target.value)}/>                       
                        </div>
                        <div className="form-outline mb-4 col-4">
                            <label className="form-label" htmlFor="password" style={label2}>Password</label>
                            <input type="password" id="password" name="password" className="form-control" placeholder="Enter Password" value={password} onChange={(e)=>setPassword(e.target.value)}/>
                        </div>
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