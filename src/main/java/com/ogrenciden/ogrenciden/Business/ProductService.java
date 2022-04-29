package com.ogrenciden.ogrenciden.Business;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.ogrenciden.ogrenciden.Model.Category;
import com.ogrenciden.ogrenciden.Model.Product;
import com.ogrenciden.ogrenciden.Model.User;
import com.ogrenciden.ogrenciden.Repository.ProductRepository;
import com.ogrenciden.ogrenciden.Request.ProductCreateRequest;

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
	
	public List<Product> getAllProducts () {
		return productRepository.findAll();
	}
	
	public Product saveOneProduct(Product newProduct) {
		return productRepository.save(newProduct);
	}
	
	public Product getOneProduct(Long productId) {
		return productRepository.findById(productId).orElse(null);
	}

	public Product updateOneProduct(Long productId,Product newProduct) {
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

	public Product createOneProduct(ProductCreateRequest newProductCreate) {
		 User user = userService.getOneUser(newProductCreate.getUserId());
		 Category category = categoryService.getOneCategory(newProductCreate.getCategoryId());
		 if (user == null) {
			 return null;
		 }
		 Product toSave = new Product();
		 toSave.setProductId(newProductCreate.getProductId());
		 toSave.setProductTitle(newProductCreate.getProductTitle());
		 toSave.setProductPrice(newProductCreate.getProductPrice());
		 toSave.setContactInfo(newProductCreate.getContactInfo());
		 toSave.setProductDescription(newProductCreate.getProductDescription());
		 toSave.setCategoryId(category);
		 toSave.setUserId(user);
		return productRepository.save(toSave);
	}	
}
