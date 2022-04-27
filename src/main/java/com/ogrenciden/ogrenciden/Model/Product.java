package com.ogrenciden.ogrenciden.Model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;


@Data
@Entity
@Table(name = "products")
public class Product{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "productId")
	Long productId;
	
	@Column(name = "productTitle")
	String productTitle;
	
	@Column(name = "productPrice")
	BigDecimal productPrice;
	
	@Column(name = "contactInfo")
	Long contactInfo;
	
	@Column(name = "productDescripton")
	String productDescription;

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	User userId;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categoryId")
	@JsonIgnore
	Category categoryId;
}
