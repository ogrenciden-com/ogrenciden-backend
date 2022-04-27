package com.ogrenciden.ogrenciden.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ogrenciden.ogrenciden.Model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	//Product findById(Long productId, Long userId);

	//Product getById(Long productId, Long userId);

}
