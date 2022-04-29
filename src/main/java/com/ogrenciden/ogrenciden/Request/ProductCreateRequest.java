package com.ogrenciden.ogrenciden.Request;

import lombok.Data;

@Data
public class ProductCreateRequest {

	//Long productId;
	String productTitle;
	Double productPrice;
	Long contactInfo;
	String productDescription;
	Long userId;
	Long categoryId;
}
