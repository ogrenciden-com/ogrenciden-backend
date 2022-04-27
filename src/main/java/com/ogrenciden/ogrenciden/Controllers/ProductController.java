package com.ogrenciden.ogrenciden.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ogrenciden.ogrenciden.Business.ProductService;
import com.ogrenciden.ogrenciden.Model.Product;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	private ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}
	
	@PostMapping("/saveProduct")
	public Product createProduct(@RequestBody Product product) {
		return productService.saveOneProduct(product);
	}
	
	@GetMapping("/{productId}") 
	public Product getOneProduct(@PathVariable Long productId) {
		//custom exception
		return productService.getOneProduct(productId);
	}
	
	@PutMapping("/{productId}")
	public Product updateOneProduct(@PathVariable Long productId ,@RequestBody Product newProduct) {
		return productService.updateOneProduct(productId,newProduct);
	}
	
	@DeleteMapping("/{productId}") 
	public void deleteOneProduct(@PathVariable Long productId) {
		productService.deleteById(productId);
	}

}
