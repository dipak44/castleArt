package com.castleArt.dao;
import java.util.List;

import javax.transaction.Transactional;

//
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

//
import com.castleArt.entities.Product;
//
public interface ProductRepository extends JpaRepository <Product, Integer> {
	

@Query(value="select * from product a where a.image=:imgname",nativeQuery = true)
public Product viewimg(String imgname);

@Query(value="select * from product",nativeQuery = true)
public List<Product> allproducts();

@Query(value="select * from product p where p.name=:productname",nativeQuery = true)
public List<Product> findProductsByName(String productname);

@Query(value="select * from product p where p.unit_price=:price",nativeQuery = true)
public  List<Product> findProductsByPrice(int price);

@Query(value="select * from product p where p.category=:category",nativeQuery = true)
public  List<Product> findProductsByCategory(String category);

//@Query(value="select * from product p where p.unit_price=:price",nativeQuery = true)
@Query(value = "SELECT * FROM product WHERE unit_price>= :baseprice AND unit_price <= :topprice", nativeQuery = true)
public  List<Product> findProductsByPriceBetweenRange(int baseprice,int topprice);

@Query(value="select * from product p where p.name like %:productname%",nativeQuery = true)
public List<Product> findProductsByNamePattern(String productname);


@Modifying
@Transactional
@Query(value="delete from product p where p.artist_artist_id=:id",nativeQuery = true)
public int deleteProductForArtist(int id);

@Modifying
@Transactional
@Query(value="delete from product p where p.product_id=:productId",nativeQuery = true)
public int deleteProductById(int productId);

}
