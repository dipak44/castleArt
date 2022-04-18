import React, { useState } from 'react'

export default function InsertProduct() {

    const[name,setName]=useState("");
    const[desciption,setDesciption]=useState("");
    const[image,setImage]=useState("");
    const[category,setCategory]=useState("");
    const[subcategory,setSubcategory]=useState("");
    const[unitInStock,setUnitInStock]=useState("");
    const[unitPrice,setUnitPrice]=useState("");

    const addProduct=(e)=>{
        e.preventDefault();
        const product = {name,desciption,image,category,subcategory,unitInStock,unitPrice}
        console.log(product);
        fetch("http://localhost:9292/api/products/dipakfinal",{
          method:"POST",
          headers:{"Content-Type":"application/json"},
          body:JSON.stringify(product)
        }).then(()=>{
          window.location.href = "/artistdashboard";
          console.log("New Product Added")
        }).catch((err)=> {console.log(err);})
    }

  return (
    <>
    <div class="container m-5">       
        <div>
            <h1 class="animate_animated animatepulse animate_infinite">Product Details</h1>
            <hr/>
            <div class="container offset-2">
                <form action="#">
                    <div class="row">
                        <div class="form-outline mb-4 mt-3 col-8">
                            <label class="form-label" htmlFor="name">Product Name</label>
                            <input type="text" id="name" name="name" class="form-control" placeholder="Enter Product Name" value={name} onChange={(e)=>setName(e.target.value)} />   
                        </div>                       
                    </div>
                    <div class="row">
                      <div class="form-outline mb-4 col-8">
                        <label class="form-label" htmlFor="desciption">Product Desciption</label>
                        <input type="text" id="desciption" name="desciption" class="form-control" placeholder="Enter Product Desciption" value={desciption} onChange={(e)=>setDesciption(e.target.value)}/>                       
                    </div>
                    </div>                    
                    <div class="row">
                        <div class="form-outline mb-4 col-8">
                            <label class="form-label" htmlFor="image">Product Image</label>
                            <input type="file" id="image" name="image" class="form-control" placeholder="Product Image" value={image} onChange={(e)=>setImage(e.target.value)} />                       
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-outline mb-4 col-4">
                            <label class="form-label" htmlFor="category">Product Category</label>                                         
                            <select class="form-select" id="category" name="category"  aria-label="Default select example" value={category}>
                              <option selected disabled>Open this select menu</option>
                              <option value="Painting" onChange={(e)=>setCategory(e.target.value)}>Painting</option>
                              <option value="Handicraft" onChange={(e)=>setCategory(e.target.value)}>Handicraft</option>
                          </select>
                        </div>

                        <div class="form-outline mb-4 col-4">
                          <label class="form-label" htmlFor="subcategory">Product Subcategory</label>                                         
                          <select class="form-select" id="subcategory" name="subcategory"  aria-label="Default select example" value={subcategory}>
                            <option selected disabled>Open this select menu</option>
                            <option value="Nature, Forest, Scenery Paintings" onChange={(e)=>setSubcategory(e.target.value)}>Nature, Forest, Scenery Paintings</option>
                            <option value="Ship, Sea, Beach Paintings" onChange={(e)=>setSubcategory(e.target.value)}>Ship, Sea, Beach Paintings</option>
                            <option value="City Paintings" onChange={(e)=>setSubcategory(e.target.value)}>City Paintings</option>
                            <option value="Tree, Botanical Paintings" onChange={(e)=>setSubcategory(e.target.value)}>Tree, Botanical Paintings</option>
                            <option value="Sunrise, Sunset, Rising Sun Paintings" onChange={(e)=>setSubcategory(e.target.value)}>Sunrise, Sunset, Rising Sun Paintings</option>
                            <option value="Walkway, Road Paintings" onChange={(e)=>setSubcategory(e.target.value)}>Walkway, Road Paintings</option>
                            <option value="Other" onChange={(e)=>setSubcategory(e.target.value)}>Other</option>
                        </select>
                      </div>
                    </div>
                    <div class="row">
                      <div class="form-outline mb-4 col-4">
                        <label class="form-label" htmlFor="unitInStock">Unit in Stock</label>
                        <input type="number" id="unitInStock" name="unitInStock" class="form-control" placeholder="Enter Unit in Stock" value={unitInStock} onChange={(e)=>setUnitInStock(e.target.value)}/>
                    </div>
                    <div class="form-outline mb-4 col-4">
                        <label class="form-label" htmlFor="unitPrice">Unit Price</label>
                    <input type="number" id="unitPrice" name="unitPrice" class="form-control" placeholder="Enter Unit Price" value={unitPrice} onChange={(e)=>setUnitPrice(e.target.value)}/>
                    </div>
                    </div>
                   
                    <div class="row offset-3">
                        <button type="submit" class="btn btn-primary col-3" onClick={addProduct}>Add Product</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    </>
  )
}