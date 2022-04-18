import './App.css';
import Homepage from './Components/Homepage';
import {BrowserRouter as Router,Route,Routes} from 'react-router-dom';
import Categories from './Components/Categories';
import Artists from './Components/Artists';
import Bulkorder from './Components/Bulkorder';
import Contactus from './Components/Contactus';
import Aboutus from './Components/Aboutus';
import Register from './Registeration/Register';
import Login from './Components/Login';
import Navbar from './Components/Navbar';
import Header from './Components/Header';
import Footer from './Components/Footer';
import ArtistRegister from './Registeration/ArtistRegister';
import ArtistBooking from './Components/ArtistBooking';
import ArtistDashboard from './ArtistDashboard/ArtistDashboard';
import CustomerDashboard from './CustomerDashboard/CustomerDashboard';
import AdminDashboard from './AdminLogin/AdminDashboard'
import ArtistLogin from './Components/ArtistLogin.js';
import AdminLogin from './AdminLogin/AdminLogin';
import UpdateCustomer from './CustomerDashboard/UpdateCustomer'
import BookingForm from './Components/BookingForm';
import DeleteCustomer from './AdminLogin/DeleteCustomer'
import DeleteArtist from './AdminLogin/DeleteArtist';
import InsertProduct from './ArtistDashboard/InsertProduct';

function App() {
  return (
    <Router>
      <div className="App my-3">
        <Header/>
        <Navbar/>
          <Routes>
            <Route exact path='/' element={<Homepage/>}></Route>
            <Route exact path='/category' element={<Categories/>}></Route>
            <Route exact path='/artist' element={<Artists/>}></Route>
            {/* <Route exact path='/artistservice' element={</>}></Route> */}
            <Route exact path='/artistbookingform' element={<BookingForm/>}></Route>
            <Route exact path='/update' element={<UpdateCustomer/>}></Route>
            {/* <Route exact path='/deleteCustomerAccount' element={<DeleteAccount/>}></Route> */}
            <Route exact path='/deletecustomer' element={<DeleteCustomer/>}></Route>
            <Route exact path='/deleteartist' element={<DeleteArtist/>}></Route>
            <Route exact path='/addproduct' element={<InsertProduct/>}></Route>
            <Route exact path='/artistservice' element={<ArtistBooking/>}></Route>
            <Route exact path='/artistregister' element={<ArtistRegister/>}></Route>
            <Route exact path='/bulk' element={<Bulkorder/>}></Route>
            <Route exact path='/contact' element={<Contactus/>}></Route>
            <Route exact path='/about' element={<Aboutus/>}></Route>
            <Route exact path='/register' element={<Register/>}></Route>
            <Route exact path='/login' element={<Login/>}></Route>
            <Route exact path='/adminlogin' element={<AdminLogin/>}></Route>
            <Route exact path='/artistlogin' element={<ArtistLogin/>}></Route>
            <Route exact path='/admindashboard' element={<AdminDashboard/>}></Route>
            <Route exact path='/artistdashboard' element={<ArtistDashboard/>}></Route>
            <Route exact path='/customerdashboard' element={<CustomerDashboard/>}></Route>
          </Routes>
          <Footer/>
      </div>
    </Router>
  );
}

export default App;
