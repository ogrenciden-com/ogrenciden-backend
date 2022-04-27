package com.ogrenciden.ogrenciden.Business;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.ogrenciden.ogrenciden.Model.Product;
import com.ogrenciden.ogrenciden.Repository.ProductRepository;

@Service
public class ProductService {

	private ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public List<Product> getAllProducts () {
		return productRepository.findAll();
	}
	
	public Product saveOneProduct(Product newProduct) {
		return productRepository.save(newProduct);
	}
	
	public Product getOneProduct(Long productId) {
		return productRepository.findById(productId).orElse(null);
	}

	public Product updateOneProduct(Long productId, Product newProduct) {
		Optional<Product> product = productRepository.findById(productId);
		if (product.isPresent()) {
			Product foundProduct = product.get();
		    foundProduct.setProductTitle(newProduct.getProductTitle());
		    foundProduct.setProductPrice(newProduct.getProductPrice());
		    foundProduct.setContactInfo(newProduct.getContactInfo());
		    foundProduct.setProductDescription(newProduct.getProductDescription());
		    productRepository.save(foundProduct);
		    return foundProduct;
		}
		else {
			return null;
		}
	}

	public void deleteById(Long productId) {
		productRepository.deleteById(productId);
	}	
}
