import axios from 'axios';
import React, { Component } from 'react';
import { NavLink} from 'react-router-dom'

export default class ArtistBooking extends Component {
    constructor(props) {
      super(props)
      this.state = {
         artist:[],
         availiblity:''
      }
    }
    //called imdiatly & didmount is best for rest 
    componentDidMount(){
        axios.get('http://localhost:9292/api/admin/find-all-artists')
            .then((res)=>{
                console.log(res.data);
                this.setState({artist:res.data})
                console.log(res.data.availiblity);
            })
            .catch((error)=>{
                console.log(error);
                // this.setState({errormsg:'Something Went Wrong'})
            })
    }

    // BookingForm=()=>{
    //     window.location="/artistbookingform"
    // }

    render() {
         return (
            <div className="container-fluid">
            <h1 className="mt-4">Artist List</h1>
            
            <table className="table table-bordered">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Artist Bio</th>
                        <th>Email</th>
                        <th>Phone No</th>
                        <th>Price</th>
                        <th>Availablability</th>
                        <th>For Booking</th>
                    </tr>
                </thead>
                <tbody>
                    {
                    this.state.artist.length ? 
                        this.state.artist.map(obj =>
                            <tr key={obj.artistId}>
                                <td>{obj.firstName} {obj.lastname}</td>
                                <td>{obj.artistBio}</td>
                                <td>{obj.artistEmail}</td>
                                <td>{obj.phoneNo}</td>
                                <td>{obj.artistPrice}</td>
                                <td>{obj.availiblity}</td>
                                {/* <td><button className='btn btn-primary' onChange={BookingForm}>Book Now</button></td> */}
                                <td><NavLink to="/artistbookingform">Book Now</NavLink></td>
                            </tr>                   
                        ):null
                    }               
                </tbody>
            </table>
        </div>
    )    
    };
}
