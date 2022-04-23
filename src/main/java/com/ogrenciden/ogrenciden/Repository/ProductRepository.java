package com.ogrenciden.ogrenciden.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ogrenciden.ogrenciden.Model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
