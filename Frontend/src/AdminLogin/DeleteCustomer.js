import axios from 'axios';
import React, { Component } from 'react'

class DeleteCustomer extends Component {
    constructor(props) {
        super(props)

        this.state = {
                users: []
        }
        this.deleteUser= this.deleteUser.bind(this);
       
    }

    deleteUser(username){
        axios.delete("http://localhost:9292/api/customer/delete-customer-account/{username}?username="+username).then(res =>{
            this.setState({users: this.state.users.filter(user => user.username !== username)});
        });
    }

    componentDidMount(){
        axios.get("http://localhost:9292/api/admin/find-all-customers").then((res) => {
            console.log(res.data);
            this.setState({ users: res.data.value});
        });
    }

    

    render() {
        return (
            <div>
                 <h2 className="text-center">Customer List</h2>
                
                 <div className = "row">
                 <div style={{paddingTop:"30px", paddingLeft:"20px" , paddingRight:"20px",paddingBottom:"20px" }}>

                        <table className = "table table-striped table-bordered" >

                            <thead>
                                <tr>
                                  <th>Customer Name</th>
                                    <th>Mobile No</th>
                                    <th>Customer Email</th>
                                    <th>Address</th>
                                    <th>Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                  this.state.users.map(
                                        user => 
                                        <tr key = {user.customerId}>
                                             <td>{user.firstName} {user.lastName} </td>
                                             <td>{user.phoneNumber} </td>   
                                             <td>{user.email}</td>
                                             <td>{user.address} {user.postalCode} {user.city} {user.state}</td>
                                            
                                            <td><button style={{marginLeft: "20px"}} onClick={ () => this.deleteUser(user.username)} className="btn btn-danger">Delete </button></td> 
                                        </tr>
                                    )
                                }
                            </tbody>
                        </table>
                        </div>
                 </div>
            </div>
        )
    }
}

export default DeleteCustomer