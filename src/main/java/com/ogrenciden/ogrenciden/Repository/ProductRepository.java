package com.ogrenciden.ogrenciden.Repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ogrenciden.ogrenciden.Model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findByUserId(Long userId);
}
