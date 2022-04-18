import React from 'react'

export default function BookingForm() {
  return (
    <>
      <form>
        <div class="container m-5">       
          <div>
            <h1 class="animate_animated animatepulse animate_infinite" style="text-align: center;">Registration for Artist Booking</h1>
              <hr/>
              <div class="container offset-2">
                      <div class="row">
                          <div class="form-outline mb-4 mt-3 col-4">
                              <label class="form-label" htmlFor="artistfirstname">Artist Firstname</label>
                              <input type="text" id="artistfirstname" name="artistfirstname" class="form-control" placeholder="Enter Artist Name" value={artistfirstname} />   
                          </div>
                          <div class="form-outline mb-4 mt-3 col-4">
                              <label class="form-label" htmlFor="artistlastname">Artist Lastname</label>
                              <input type="text" id="artistlastname" name="artistlastname" class="form-control" placeholder="Enter Artist Name" value={artistlastname} />   
                          </div>
                      </div>
                      <div class="row">
                          <div class="form-outline mb-4 col-4">
                              <label class="form-label" htmlFor="mobilenumber">Artist Mobile Number</label>
                              <input type="number" id="mobilenumber" name="mobilenumber" class="form-control" placeholder="Enter Your Mobile Number" value={mobilenumber} />               
                          </div>
                          <div class="form-outline mb-4 col-4">
                              <label class="form-label" htmlFor="artistprice">Artist Price</label>
                              <input type="Number" id="artistprice" name="artistprice" class="form-control" placeholder="Enter Price" value={artistprice} />               
                          </div>
                      </div>
                      <div class="row">
                          <div class="form-outline mb-4 col-4">
                              <label class="form-label" htmlFor="customerfirstname">Customer Firstname</label>
                              <input type="text" id="customerfirstname" name="customerfirstname" class="form-control" placeholder="Enter firstname" value={address} />                       
                          </div>
                          <div class="form-outline mb-4 col-4">
                              <label class="form-label" htmlFor="customerlastname">Customer Lastname</label>
                              <input type="text" id="customerlastname" name="customerlastname" class="form-control" placeholder="Enter lastname" value={address} />                       
                          </div>
                      </div>
                      <div class="row">
                          <div class="form-outline mb-4 col-8">
                              <label class="form-label" htmlFor="address">Customer Address</label>
                              <input type="text" id="address" name="address" class="form-control" placeholder="Address(House No, Building, Street, Area" value={address} />                       
                          </div>
                      </div>
                      <div class="row">
                          <div class="form-outline mb-4 col-3">
                              <label class="form-label" htmlFor="city">City</label>
                              <input type="text" id="city" name="city" class="form-control" placeholder="City/District" value={city} />                       
                          </div>
                          <div class="form-outline mb-4 col-3">
                              <label class="form-label" htmlFor="state">State</label>
                              <input type="text" id="state" name="state" class="form-control" placeholder="State" value={state} />
                          </div>
                          <div class="form-outline mb-4 col-2">
                              <label class="form-label" htmlFor="postalCode">Pin Code</label>
                          <input type="text" id="postalCode" name="postalCode" class="form-control" placeholder="Enter Pin Code" value={postalCode} />
                          </div>
                      </div>
                      <div class="row">
                          <div class="form-outline mb-4 col-4">
                              <label class="form-label" htmlFor="state">Customer Phone Number</label>
                              <input type="number" id="state" name="state" class="form-control" placeholder="State" value={state} />
                          </div>
                          <div class="form-outline mb-4 col-4">
                              <label class="form-label" htmlFor="postalCode">Final Amount</label>
                          <input type="number" id="postalCode" name="postalCode" class="form-control" placeholder="Enter Pin Code" value={postalCode} />
                          </div>
                      </div>
                      <div class="row">
                          <div class="form-outline mb-4 col-4">
                              <label class="form-label" htmlFor="phoneNumber">Booking Date</label>
                              <input type="date" id="phoneNumber" name="phoneNumber" class="form-control" placeholder="Enter Date for Booking" value={phoneNumber} />                        
                          </div>
                          <div class="form-outline mb-4 col-4">
                              <label class="form-label" htmlFor="lastName">Booking Time</label>
                              <input type="time" id="lastName" name="lastName" class="form-control" placeholder="Enter Price" value={lastName} />               
                          </div>
                      </div>
                </div>
            </div>
        </div>
      </form>
    </>
  )
}
