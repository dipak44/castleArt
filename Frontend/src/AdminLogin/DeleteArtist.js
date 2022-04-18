import axios from 'axios';
import React, { Component } from 'react'

class DeleteArtist extends Component {
    constructor(props) {
        super(props)

        this.state = {
                name:"",
                artist: []
        }
        this.deleteArtist= this.deleteArtist.bind(this);
       
    }

    deleteArtist(username){
        axios.delete("http://localhost:9292/api/customer/delete-artist-account/{username}?username="+username).then(res =>{
            this.setState({artist: this.state.artist.filter(vender => vender.username !== username)});
        });
    }

    componentDidMount(){
        axios.get("http://localhost:9292/api/admin/find-all-artists").then((res) => {
            console.log(res.data[0].city);
            // this.setState({ artist: res.data.data});
            // console.log(res.data);
            this.setState({name:res.data[0].city})
            console.log(this.state.name);
        });
    }

    

    render() {
        return (
            <div>
                 <h2 className="text-center">Artist List</h2>
                
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
                                  this.state.artist.map(
                                        vender => 
                                        <tr key = {vender.customerId}>
                                             <td>{vender.firstName} {vender.lastName}</td>
                                             <td>{vender.phoneNumber} </td>   
                                             <td>{vender.email}</td>
                                             <td>{vender.address} {vender.postalCode} {vender.city} {vender.state}</td>
                                            
                                            <td><button style={{marginLeft: "20px"}} onClick={ () => this.deleteArtist(vender.username)} className="btn btn-danger">Delete </button></td> 
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

export default DeleteArtist