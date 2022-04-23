package com.ogrenciden.ogrenciden.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ogrenciden.ogrenciden.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
