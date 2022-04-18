import React, { useState } from 'react'

const style1={
    color: "darkred", fontSize: "2rem", textAlign: "center", marginTop: "10px"
}

const label2={
    fontSize:"18px"
}

export default function UpdateCustomer() {

    const customerDetailsLS=localStorage.getItem('customerDetails')
    console.log();
    const [userDetails,setUserDetails]=useState({
        firstName:"",
        lastName:"",
        email:"",
        phoneNumber:"",
        address:"",
        city:"",
        state:"",
        postalCode:"",
        username:"",
        password:""
    })

    const handleChange=(e)=>{
        setUserDetails(e.target.value);
    }

    const handleSubmit=(e)=>{
        e.preventDefault()
        const customer = {firstName:customerDetailsLS.firstName,lastName:customerDetailsLS.lastName,email:customerDetailsLS.email,phoneNumber:customerDetailsLS.phoneNumber,address:customerDetailsLS.address,city:customerDetailsLS.city,state:customerDetailsLS.state,postalCode:customerDetailsLS.postalCode,username:customerDetailsLS.username,password:customerDetailsLS.password}
        console.log(customer);
        fetch("http://localhost:9292/api/update/username="+customerDetailsLS.username+"&password="+customerDetailsLS.password,{
          method:"PUT",
          headers:{"Content-Type":"application/json"},
            body:JSON.stringify(customer)
        }).then(response => response.json)
        .then((result)=>{
            console.log(result);
            window.location.href = "/customerdashboard";
            console.log("Customer Updated")
        }).catch((err)=> {console.log("error",err);})
      } 

  return (
    <>
    <div className="container m-5">       
        <div>
            <h1 style={style1}>Update profile</h1>
            <hr/>
            <div className="container offset-2">
                <form onSubmit={handleSubmit}>
                    <div className="row">
                        <div className="form-outline mb-4 mt-3 col-4">
                            <label className="form-label" htmlFor="firstName" style={label2}>Your First Name</label>
                            <input type="text" id="firstName" name="firstName" className="form-control" placeholder="Enter Your First Name" value={customerDetailsLS.firstName} onChange={handleChange} />   
                        </div>
                        <div className="form-outline mb-4 mt-3 col-4">
                            <label className="form-label" htmlFor="lastName" style={label2}>Your Last Name</label>
                            <input type="text" id="lastName" name="lastName" className="form-control" placeholder="Enter Your Last Name" value={customerDetailsLS.lastName} onChange={handleChange}/>               
                        </div>
                    </div>
                    <div className="row">
                        <div className="form-outline mb-4 col-8">
                            <label className="form-label" htmlFor="email" style={label2}>Email</label>
                            <input type="email" id="email" name="email" className="form-control" placeholder="Enter Your Email" value={customerDetailsLS.email} onChange={handleChange}/>               
                        </div>
                    </div>
                    <div className="row">
                        <div className="form-outline mb-4 col-4">
                            <label className="form-label" htmlFor="phoneNumber" style={label2}>Mobile Number</label>
                            <input type="number" id="phoneNumber" name="phoneNumber" className="form-control" placeholder="Enter Your Mobile Number" value={customerDetailsLS.phoneNumber} onChange={handleChange}/>                        
                        </div>
                        {/* <div className="form-outline mb-4 mt-5 col-4">
                            <label className="form-label" htmlFor="gender" style={label2}>Gender : </label>&emsp;
                            <div id="gender" name="gender" className="form-check form-check-inline" value={gender} onChange={handleInput}>
                                <input className="form-check-input" type="radio" name="gender" id="male" value="option1"/>
                                <label className="form-check-label" htmlFor="male">Male</label>
                                </div>
                                <div id="gender" className="form-check form-check-inline">
                                <input className="form-check-input" type="radio" name="gender" id="female" value="option2"/>
                                <label className="form-check-label" htmlFor="female">Female</label>
                                </div>
                                <div id="gender" className="form-check form-check-inline">
                                <input className="form-check-input" type="radio" name="gender" id="other" value="option3"/>
                                <label className="form-check-label" htmlFor="other">Other</label>
                            </div>             
                        </div> */}
                    </div>
                    <div className="row">
                        <div className="form-outline mb-4 col-8">
                            <label className="form-label" htmlFor="address" style={label2}>Address</label>
                            <input type="text" id="address" name="address" className="form-control" placeholder="Address(House No, Building, Street, Area)" value={customerDetailsLS.address} onChange={handleChange}/>                       
                        </div>
                    </div>
                    <div className="row">
                        <div className="form-outline mb-4 col-3">
                            <label className="form-label" htmlFor="city" style={label2}>City</label>
                            <input type="text" id="city" name="city" className="form-control" placeholder="City/District" value={customerDetailsLS.city} onChange={handleChange}/>                       
                        </div>
                        <div className="form-outline mb-4 col-3">
                            <label className="form-label" htmlFor="state" style={label2}>State</label>
                            <input type="text" id="state" name="state" className="form-control" placeholder="State" value={customerDetailsLS.state} onChange={handleChange}/>
                        </div>
                        <div className="form-outline mb-4 col-2">
                            <label className="form-label" htmlFor="postalCode" style={label2}>Pin Code</label>
                        <input type="text" id="postalCode" name="postalCode" className="form-control" placeholder="Enter Pin Code" value={customerDetailsLS.postalCode} onChange={handleChange}/>
                        </div>
                    </div>
                    <div className="row">
                        <div className="form-outline mb-4 col-4">
                            <label className="form-label" htmlFor="username" style={label2}>Username</label>
                            <input type="text" id="username" name="username" className="form-control" placeholder="Enter Your Username" value={customerDetailsLS.username} onChange={handleChange} disabled/>                       
                        </div>
                        <div className="form-outline mb-4 col-4">
                            <label className="form-label" htmlFor="password" style={label2}>Password</label>
                            <input type="password" id="password" name="password" className="form-control" placeholder="Enter Password" value={customerDetailsLS.password} onChange={handleChange} disabled/>
                        </div>
                    </div>
                    <div className="row offset-3">
                        <button type="submit" className="btn btn-primary col-3">Update</button>
                    </div>
                </form>
            </div>
        </div>
    </div>    
    </>
  )
}

