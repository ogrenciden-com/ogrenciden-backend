package com.ogrenciden.ogrenciden.Business;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.ogrenciden.ogrenciden.Model.Category;
import com.ogrenciden.ogrenciden.Model.Product;
import com.ogrenciden.ogrenciden.Model.User;
import com.ogrenciden.ogrenciden.Repository.ProductRepository;
import com.ogrenciden.ogrenciden.Request.ProductCreateRequest;
import com.ogrenciden.ogrenciden.Request.ProductUpdateRequest;

@Service
public class ProductService {

	private ProductRepository productRepository;
	private UserService userService;
	private CategoryService categoryService;
	
	public ProductService(ProductRepository productRepository,UserService userService,CategoryService categoryService) {
		this.productRepository = productRepository;
		this.userService = userService;
		this.categoryService = categoryService;
	}
	
	public List<Product> getAllProducts (Optional<Long> userId) { 
		if (userId.isPresent()) {
			return productRepository.findByUserId(userId.get());
		}
		else {
		return productRepository.findAll();
		}
	}
	
	public Product getOneProduct(Long productId) {
		return productRepository.findById(productId).orElse(null);
	}


	public Product createOneProduct(ProductCreateRequest newProductCreate) {
		 User user = userService.getOneUser(newProductCreate.getUserId());
		 Category category = categoryService.getOneCategory(newProductCreate.getCategoryId());
		 if (user == null) {
			 return null;
		 }
		 Product toSave = new Product();
		 toSave.setProductTitle(newProductCreate.getProductTitle());
		 toSave.setProductPrice(newProductCreate.getProductPrice());
		 toSave.setContactInfo(newProductCreate.getContactInfo());
		 toSave.setProductDescription(newProductCreate.getProductDescription());
		 toSave.setCategoryId(category);
		 toSave.setUserId(user);
		 return productRepository.save(toSave);
	}	
	
	public Product updateOneProductById(Long productId, ProductUpdateRequest updateProduct) {	
		Optional<Product> product = productRepository.findById(productId);
		if (product.isPresent()) {
			Product toUpdate = product.get();
			toUpdate.setProductTitle(updateProduct.getProductTitle());
			toUpdate.setProductPrice(updateProduct.getProductPrice());
			toUpdate.setContactInfo(updateProduct.getContactInfo());
			toUpdate.setProductDescription(updateProduct.getProductDescription());
			productRepository.save(toUpdate);
			return toUpdate;
		}
		else {
			return null;
		}
	}

	public void deleteOneProductById(Long productId) {
		productRepository.deleteById(productId);
	}
}
