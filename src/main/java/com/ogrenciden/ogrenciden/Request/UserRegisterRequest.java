package com.ogrenciden.ogrenciden.Request;

import lombok.Data;

@Data
public class UserRegisterRequest {

	String name;
	String lastName;
	String email;
	String password;
}
