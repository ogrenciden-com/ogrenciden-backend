package com.ogrenciden.ogrenciden.Request;

import lombok.Data;

@Data
public class ProductUpdateRequest {
	
	String productTitle;
	Double productPrice;
	Long contactInfo;
	String productDescription;
}
