package com.ogrenciden.ogrenciden.Model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "productId")
	Long productId;
	
	@Column(name = "productTitle")
	String productTitle;
	
	@Column(name = "productPrice")
	BigDecimal productPrice;
	
	@Column(name = "cities")
	String Cities;
	
	@Column(name = "contactInfo")
	Long contactInfo;
	
	@Column(name = "productDescripton")
	String productDescription;
	
	

}
