import React, {useState} from 'react'
import './login.css'
import { NavLink} from 'react-router-dom'
import axios from 'axios'
// import img from './images/sideimage.jpg'

export default function Login() {
    // const initialValues={username:'',password:''};
    // const [formValues, setFormValues]=useState(initialValues);
    // const [fromErrors, setFormErrors]=useState({}) //empty obj
    // const [isSubmit,setisSubmit]=useState(false);

    // const handleChanage = (e) => {
    //     console.log(e.target);
    //     const {name,value}=e.target;
    //     setFormValues({ ...formValues,[name]:value })
    //     console.log(formValues);    
    // }

    // // const handleSubmit = (e) => {
    // //     e.preventDefault();
    // //     setFormErrors(validate(formValues));
    // //     setisSubmit(true);
    // //     axios.post("",{
    // //         username:formValues.username,
    // //         password:formValues.password
    // //     })
    // // }

    // useEffect(()=> {
    //     console.log(formValues);
    //     if(Object.keys(fromErrors).length == 0 && isSubmit){
    //         console.log(formValues);
    //     }
    // },[fromErrors])

    // const validate = (values) => {
    //     const errors={}
    //     if(!values.username){
    //         errors.username= "Username is required";
    //     }
    //     if(!values.password){
    //         errors.password= "Password is required";
    //     }
    //     else if(values.password < 5){
    //         errors.password= "Password Must be more than 5 Characters"
    //     }
    //     else if(values.password > 12){
    //         errors.password= "Password Must be less than 12 Characters"
    //     }
    //     return errors;
    // }

    // const finduser = async () =>{
    //     const user={Username:username,Password:password};

    //     const response = await axios.post("",user);

    //     console.log(response.data);
    //     if(response.data=== null || response.data=== ""){
    //         alert("Invalid Credentials")
    //     }
    //     else{
    //         alert("Login successfull");
    //         localStorage.setItem("role",response.data)

    //         if(response.data.status === "Active"){
    //             if(response.data === 1){
    //                 window.location.href = ""
    //             }
    //         }
        
    // }
    const[username,setUsername]=useState("");
    const[password,setPassword]=useState("");

    const handleClick=()=>{
        const customer={username,password}
        axios.post("http://localhost:9292/api/home/customer-signin",customer).then((res)=>{
            console.log("success"); 
            console.log(res); 
            window.location.href="/customerdashboard";
            localStorage.setItem('customerDetails',res.data)
        },
        (err)=>{
            console.log("Invalid login credentials");
            console.log(err);
        })
    }

    return (
        <>
        <div className="container my-4">
                <div className="row g-0 col-8 offset-2">
                    <div className="col-lg-5">
                        {/* <img src={img} className="img-fluid" alt="CastleArt"/> */}
                        {/* <pre>{JSON.stringify(formValues,undefined,2)}</pre> */}
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
                            {/* <span id="span">{fromErrors.username}</span> */}
                            <div className="form-row">
                                <div className="offset-2 py-3 col-lg-7">
                                    <input type="Password" placeholder="Password" name="password" value={password} className="form-control px-3" onChange={(e)=>setPassword(e.target.value)}/>
                                </div>
                                
                            </div>
                            {/* <span id="span">{fromErrors.password}</span> */}
                            
                            <div className="form-row py-3">
                                <div className="offset-1 col-lg-10">
                                    <button className="btn btn-primary col-4" onClick={handleClick}>SignIn</button>
                                </div>
                            </div>
                        </form>
                        <p><NavLink to="/register">Click Here</NavLink> for Customer Registration</p>
                    </div>               
                </div>
            </div>
        </>
    )
}
