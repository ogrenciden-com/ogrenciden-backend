package com.ogrenciden.ogrenciden.Business;

import org.springframework.stereotype.Service;
import com.ogrenciden.ogrenciden.Model.Category;
import com.ogrenciden.ogrenciden.Repository.CategoryRepository;

@Service
public class CategoryService {

	private CategoryRepository categoryRepository;

	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	public Category getOneCategory(Long categoryId) {
		return categoryRepository.findById(categoryId).orElse(null);
	}
}
