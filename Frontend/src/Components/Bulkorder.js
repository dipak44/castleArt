import React from 'react'
import { NavLink } from 'react-router-dom'

export default function Bulkorder() {
  return (
    <>
    <div class="col-8 offset-2 my-5">
      <h1 class="text-center">Bulk-Orders</h1>
      <table class="table table-hover text-center" >
        <thead>
          <tr>
            <th scope="col">Order Total</th>
            <th scope="col">Discount</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>Rs. 1.5 Lacs - 3 Lacs</td>
            <td>10 %</td>
          </tr>
          <tr>
            <td>Rs. 3 Lacs - 5 Lacs</td>
            <td>12 %</td> 
          </tr>
          <tr>
            <td>Rs. 5 Lacs - 7.5 Lacs</td>
            <td>14 %</td>
          </tr>
          <tr>
            <td>Rs. 7.5 Lacs - 10 Lacs </td>
            <td>16 %</td> 
          </tr>
          <tr>
            <td>Rs. 10 Lacs - 15 Lacs</td>
            <td>18.5 %</td> 
          </tr>
          <tr>
            <td>Rs. 15 Lacs - 30 Lacs</td>
            <td>22 %</td> 
          </tr>
          <tr>
            <td>Rs.30 Lacs onward</td>
            <td>Please <NavLink to="/contact"> Contact Us</NavLink></td> 
          </tr>
        </tbody>
      </table>
    </div>
    </>
  )
}
