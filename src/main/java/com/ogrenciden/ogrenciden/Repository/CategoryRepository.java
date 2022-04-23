package com.ogrenciden.ogrenciden.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ogrenciden.ogrenciden.Model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
