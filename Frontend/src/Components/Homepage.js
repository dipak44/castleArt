import React from "react";
import Navbar from "./Navbar";
import "./Home.css";
import Product from "./Product";
import productInfo from "./productinfo.json";
import Slider from "./Slider";

export default function Homepage() {
  const slidesData = [
    {
      id: 1,
      title: "Image 1",
      label: " label 1",
      src: "https://picsum.photos/800/400?img=1",
    },
    {
      id: 2,
      title: "Image 2",
      label: "just not a label",
      src: "https://picsum.photos/800/400?img=2",
    },
    {
      id: 3,
      title: "Image 3",
      label: " just woe a label",
      src: "https://picsum.photos/800/400?img=3",
    },
    {
      id: 4,
      title: "Image 4",
      label: "just a label",
      src: "https://picsum.photos/800/400?img=4",
    },
    {
      id: 5,
      title: "Image 5",
      label: "just a label",
      src: "https://picsum.photos/800/400?img=5",
    },
    {
      id: 6,
      title: "Image 6",
      label: "just a label",
      src: "https://picsum.photos/800/400?img=6",
    },
  ];
  const settings = {
    dots: true,
    infinite: true,
    speed: 500,
    autoplay: true,
  };
  return (
    <>
    <Slider/>
      <div className="img">
        <div className="container px-4 py-5" id="icon-grid">
          <div className="img_holder">
            <div className="col-4 offset-4">
              <div className="row">
            {productInfo.length > 0 ? (
              productInfo.map((product, index) => (
                <Product {...product} key={index} />
              ))
            ) : (
              <p>No Artwork Available</p>
            )}
            </div>
            </div>
          </div>
          <h2 className="pb-2 mt-4 border-bottom">Why choose us?</h2>
          <div className="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 g-4 py-5 my-4">
            <div className="col d-flex align-items-start">
              <div>
                <h4 className="fw-bold mb-0">Featured title</h4>
                <p>
                  Artists and art lovers from all across the globe can choose to
                  sell and buy artworks on Gallerist
                </p>
              </div>
            </div>
            <div className="col d-flex align-items-start">
              <div>
                <h4 className="fw-bold mb-0">Featured title</h4>
                <p>
                  A wide range and collection of paintings for you to explore,
                  sell and buy
                </p>
              </div>
            </div>
            <div className="col d-flex align-items-start">
              <div>
                <h4 className="fw-bold mb-0">Featured title</h4>
                <p>
                  We are a highly trusted and leading art platform where every
                  artist and art lover is cherished
                </p>
              </div>
            </div>
            <div className="col d-flex align-items-start">
              <div>
                <h4 className="fw-bold mb-0">Featured title</h4>
                <p>
                  Drawings, paintings, stencils, posters, handicrafts and more,
                  we have a splendid range for you to get your hands on
                </p>
              </div>
            </div>
            <div className="col d-flex align-items-start">
              <div>
                <h4 className="fw-bold mb-0">Featured title</h4>
                <p>
                  Different kinds of artworks on different types of materials
                  and surfaces are available for you to choose from as our
                  artists have the liberty to create whatever they feel the best
                </p>
              </div>
            </div>
            <div className="col d-flex align-items-start">
              <div>
                <h4 className="fw-bold mb-0">Featured title</h4>
                <p>
                  Exceptional customer service and support in case you get stuck
                  anywhere throughout the process
                </p>
              </div>
            </div>
            <div className="col d-flex align-items-start">
              <div>
                <h4 className="fw-bold mb-0">Featured title</h4>
                <p>
                  A network of globally leading and acclaimed artists that
                  contribute their masterpieces to our collection
                </p>
              </div>
            </div>
            <div className="col d-flex align-items-start">
              <div>
                <h4 className="fw-bold mb-0">Featured title</h4>
                <p>
                  Verified Artists on the platform can upload and send any
                  number of paintings as they want
                </p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </>
  );
}
