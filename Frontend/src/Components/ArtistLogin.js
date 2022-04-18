import React, {useState } from 'react'
import './login.css'
import { NavLink} from 'react-router-dom'
import axios from 'axios'
// import img from './images/sideimage.jpg'

export default function ArtistLogin() {

    const[username,setUsername]=useState("");
    const[password,setPassword]=useState("");

    const handleClick=()=>{
        const artist={username,password}
        axios.post("http://localhost:9292/api/home/artist-signin",artist).
        then((res)=>{
            console.log("success");
            console.log(res); 
            window.location.href="/artistdashboard";
            localStorage.setItem('artistId',res.data.artistId)
        },
        (err)=>{
            console.log("Invalid login credentials");
            console.log(username);
            console.log(password);
            console.log(err);
        })
    }

    return (
        <>
        <div className="container my-4">
                <div className="row g-0 col-8 offset-2">
                    <div className="col-lg-5">
                        <img src={require('./images/sideimage.jpg')} className="img-fluid" alt="CastleArt"/>
                    </div>
                    <div className="col-lg-7 py-5">
                        <h1 className="animate__animated animate__pulse animate__infinite">Welcome</h1>
                        <form>
                            <div className="form-row py-3 pt-5">
                                <div className="offset-2 col-lg-7">
                                    <input type="text" placeholder="Username" name="username" value={username} className="form-control px-3" onChange={(e)=>setUsername(e.target.value)}/>
                                </div>
                                
                            </div>
                            <div className="form-row">
                                <div className="offset-2 py-3 col-lg-7">
                                    <input type="Password" placeholder="Password" name="password" value={password} className="form-control px-3" onChange={(e)=>setPassword(e.target.value)}/>
                                </div>
                                
                            </div>
                            
                            <div className="form-row py-3">
                                <div className="offset-1 col-lg-10">
                                    <button className="btn btn-primary col-4" onClick={handleClick}>SignIn</button>
                                </div>
                            </div>
                        </form>
                        <p><NavLink to="/artistregister">Click Here</NavLink> for Artist Registration</p>
                    </div>               
                </div>
            </div>
        </>
    )
}