package com.ogrenciden.ogrenciden.Model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="userId")
	Long userId;
	
	@Column(name = "name")
	String name;
	
	@Column(name = "lastName")
	String lastName;
	
	@Column(name = "email")
	String email;
	
	@Column(name = "password")
	String password;
	
	@Column(name = "universityName")
	String universityName;
	
	@Column(name = "campusName") 
	String campusName;
	
	@Column(name = "contactInfo")
	String contactInfo;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "productId")
	List<Product> products;

}
