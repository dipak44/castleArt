import React, { useState } from "react";
import "./Product.css";

function Product({ img }) {
  return (
    <div id="product" className="product">
      <div className="cover" id="cover">
        <img id="img_pr" src={img} alt="img" />
      </div>
    </div>
  );
}

export default Product;
