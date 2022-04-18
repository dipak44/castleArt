// // import axios from 'axios';
// // import React from 'react'

// // export default function DeleteAccount() {

// //     const[username,setUsername]=useState("");
// //     const[password,setPassword]=useState("");

// //     const deleteAccount=()=>{
// //         const customer1={username,password}
// //         axios.delete("http://localhost:9292/api/customer/delete-customer-account",customer1).then((res)=>{
// //             localStorage.getItem();
// //             console.log("success"); 
// //             console.log(res); 
// //             window.location.href="/";
// //         },
// //         (err)=>{
// //             console.log("Invalid credentials");
// //             console.log(err);
// //         })
// //     }

// //   return (
// //     <>
// //         <form>
// //             <div class="form-floating">
// //                 <input type="email" class="form-control" id="floatingInput" placeholder="Enter Username"/>
// //                 <label for="floatingInput">Email address</label>
// //             </div>
// //             <div class="form-floating">
// //                 <input type="password" class="form-control" id="floatingPassword" placeholder="Enter Password"/>
// //                 <label for="floatingPassword">Password</label>
// //             </div>   
// //             <button class="w-100 btn btn-lg btn-primary" type="submit" onClick={deleteAccount}>Delete Account</button>
// //         </form>
// //     </>
// //   )
// // }

// import axios from 'axios';
// import React, { Component } from 'react'

// export default class DeleteAccount extends Component {
//     constructor(props) {
//       super(props)
    
//       this.state = {
//           username:localStorage.getItem('username'),
//          Customers:[]
//       }
//       this.deleteUser=this.deleteUser.bind(this);
//     }

//     deleteUser(username){
//         axios.delete("http://localhost:9292/api/customer/delete-customer-account/"+username)
//         .then(res => {
//             // alert("Are you sure ??")
//             this.setState({
//                 Customers:this.state.Customers
//             })
//             window.location.href="/login"
//         })
//         .catch(err =>{
//             console.log("error",err);
//         })
        
//     }

//   render() {
//     return (
//       <>
//       <button className='btn btn-primary' onClick={this.deleteUser(Customers.username)}></button>
//       </>
//     )
//   }
// }
