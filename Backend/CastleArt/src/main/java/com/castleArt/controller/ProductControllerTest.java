package com.castleArt.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.parser.MediaType;
//import org.omg.CORBA.portable.InputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.castleArt.dao.ProductRepository;
import com.castleArt.dto.ProductDto;
import com.castleArt.entities.Artist;
import com.castleArt.entities.Customer;
import com.castleArt.entities.Product;
import com.castleArt.helper.FileUploadHelper;
import com.castleArt.service.IArtistService;
import com.castleArt.service.IProductService;

import antlr.StringUtils;
import io.micrometer.core.instrument.util.IOUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@Api(value = "Product Resources", description = "all operation related to Products ")
@RequestMapping("api/product")
@CrossOrigin(origins="http://localhost:3000")
public class ProductControllerTest {

	@Autowired
	FileUploadHelper fileUploadHelper;

	@Autowired
	IProductService productservice;

	@Autowired
	ProductRepository repo;

	@Autowired
	IArtistService artistserv;

	@Autowired
	ProductRepository pro;





	// add the product
	@ApiOperation(value = "Add the Product for artist account")
	@PostMapping("/dipakfinal")
	public ResponseEntity<String> saveProduct(@RequestParam ("name") String name, @RequestParam ("description") String description, @RequestParam ("unitInStock") int unitInStock
			, @RequestParam ("unitPrice") int unitPrice, @RequestParam ("category") String category, @RequestParam ("subcategory") String subcategory, @RequestParam ("username") String username,@RequestParam("file") MultipartFile file) {
		double sellingprice=unitPrice+unitPrice*0.15;

		Product product=new Product();
		product.setName(name);
		product.setDescription(description);
		product.setUnitInStock(unitInStock);
		product.setUnitPrice(unitPrice);
		product.setCategory(category);
		product.setSellingprice(sellingprice);
		product.setSubcategory(subcategory);



		//Artist artist = this.artistserv.getArtistByUsernameAndPassword(username,password);


		try {

			//String name = principal.getName();
			//User user = this.userRepository.getUserByUserName(name);


			Artist artist = this.artistserv.getArtistByUsername(username);

			// processing and uploading file..

			if (file.isEmpty()) {
				// if the fie is empty then thrwo msg
				System.out.println("File is empty");

			} 

			if (!file.getContentType().equals("image/jpeg")) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
						.body("Only JPEG content type are allowed");

			}		
			else {
				// file the file to folder and update the name to contact
				product.setImage(file.getOriginalFilename());
				boolean f= fileUploadHelper.uploadFile(file);
				//File file1 = new FileSystemResource("C:\\image").getFile();


				//Path path = Paths.get(file1.getAbsolutePath() + File.separator + file.getOriginalFilename());

				//System.out.println(path);
				//product.setImage();
				//Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
				System.out.println("Image is uploaded");
				this.repo.save(product);

			}

			artist.getProduct().add(product);

			product.setArtist(artist);

			this.artistserv.registerArtist(artist);
		} catch (Exception e) {
			System.out.println("ERROR " + e.getMessage());
			e.printStackTrace();
		}
		return ResponseEntity.ok("product is addes sucessfully for given artist");
	}

// delete product by id
	@ApiOperation(value = "Delete the product")
	@DeleteMapping("/delete-the-product-byId/{productId}")
	public ResponseEntity<?> deleteArtist(@RequestParam ("productId")int productId) {
		try {
			//System.out.println("your username :"+username);
			boolean b= productservice.deleteProduct(productId);
			if(b==true)
			{
				return ResponseEntity.status(HttpStatus.OK).body("product deleted succesfully");
			}
			else
			{
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("product is not present");

			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	//find all product
	@ApiOperation(value = "find all available product")
	@GetMapping("/find-all-product")
	public ResponseEntity<?> AllProduct() {

		List<ProductDto> pr=productservice.findAllProducts();
		if(pr.size()==0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NO Product is Found for given specification");
		}
		else
		{
			//			for (ProductDto product : pr) {
			//				String temp=product.getImage();
			//				String p=ServletUriComponentsBuilder.fromCurrentContextPath().path("/").path(temp).toUriString();
			//				System.out.println(product.getImage());
			//				product.setImage(p);
			//				System.out.println(product.getImage());
			//			}
			for (ProductDto productDto : pr) {
				String temp=productDto.getImage();
				String p=ServletUriComponentsBuilder.fromCurrentContextPath().path("//").path(temp).toUriString();
				System.out.println(productDto.getImage());
				productDto.setImage(p);
				System.out.println(productDto.getImage());

			}

			//return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(temp).toUriString());
			//String p=ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(temp).toUriString();
			return ResponseEntity.status(HttpStatus.OK).body(pr);
		}
	}


	// find products by names
	@GetMapping("/find-pro-by-name/{name}")
	@ApiOperation(value = "Find the Product By name")
	public ResponseEntity<?> findProductByName(@RequestParam String name) {	
		List<Product> pr=productservice.findProductsByName(name);
		if(pr.size()==0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NO Product is Found for given specification");
		}
		else
		{
			for (Product product : pr) {
				String temp=product.getImage();
				String p=ServletUriComponentsBuilder.fromCurrentContextPath().path("/").path(temp).toUriString();
				System.out.println(product.getImage());
				product.setImage(p);
			}
			return ResponseEntity.status(HttpStatus.OK).body(pr);
		}
	}


	//find Products by price
	@GetMapping("/find-product-by-price/{price}")
	@ApiOperation(value = "Find the Product by Price")
	public ResponseEntity<?> findProductsByPrice(@PathVariable("price") int price) {
		List<Product> pr=productservice.findProductsByPrice(price);		
		for (Product product : pr) {
			String temp=product.getImage();
			String p=ServletUriComponentsBuilder.fromCurrentContextPath().path("/").path(temp).toUriString();
			System.out.println(product.getImage());
			product.setImage(p);
		}
		return ResponseEntity.status(HttpStatus.FOUND).body(pr);
	}

	// find products by category
	@GetMapping("/find-product-by-category/{category}")
	@ApiOperation(value = "Find the Product by Category")
	public ResponseEntity<?> findProductByCategory(@PathVariable("category") String category) {

		List<Product> pr=productservice.findProductsByCategory(category);	
		if(pr.size()==0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NO Product is Found for given specification");
		}
		else
		{
			for (Product product : pr) {
				String temp=product.getImage();
				String p=ServletUriComponentsBuilder.fromCurrentContextPath().path("/").path(temp).toUriString();
				System.out.println(product.getImage());
				product.setImage(p);
			}
			return ResponseEntity.status(HttpStatus.FOUND).body(pr);
		}
	}

	// find products by price in between range
	@GetMapping("/find-Product-by-price-limit/{baseprice}/{topprice}")
	@ApiOperation(value = "Find the Product by Price Range")
	public ResponseEntity<?> findProductsByPrice(@PathVariable ("baseprice") int baseprice,@PathVariable ("topprice") int topprice)  {
		List<Product> pr=productservice.findProductsByPriceInRange(baseprice,topprice);	
		if(pr.size()==0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NO Product is Found for given specification");	
		}
		else
		{
			for (Product product : pr) {
				String temp=product.getImage();
				String p=ServletUriComponentsBuilder.fromCurrentContextPath().path("/").path(temp).toUriString();
				System.out.println(product.getImage());
				product.setImage(p);
			}
			return ResponseEntity.status(HttpStatus.FOUND).body(pr);
		}
	}


	// find products by names patterns
	@GetMapping("/find-pro-by-patternname/{name}")
	@ApiOperation(value = "Find the Product by Matching Name")
	public ResponseEntity<?> findProductByPatternName(@PathVariable("name") String name) {	
		List<Product> pr=productservice.findProductsByNamePattern(name);
		if(pr.size()==0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NO Product is Found for given specification");
		}
		else
		{
			for (Product product : pr) {
				String temp=product.getImage();
				String p=ServletUriComponentsBuilder.fromCurrentContextPath().path("/").path(temp).toUriString();
				System.out.println(product.getImage());
				product.setImage(p);
			}
			return ResponseEntity.status(HttpStatus.OK).body(pr);
		}
	}



}


