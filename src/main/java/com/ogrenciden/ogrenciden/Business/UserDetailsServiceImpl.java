package com.ogrenciden.ogrenciden.Business;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ogrenciden.ogrenciden.Model.User;
import com.ogrenciden.ogrenciden.Repository.UserRepository;
import com.ogrenciden.ogrenciden.Security.JwtUserDetails;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private UserRepository userRepository;
	
	public UserDetailsServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override //loadUserByUsername // loadUserByEmail
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByemail(email);
		return JwtUserDetails.create(user);
	}

	public UserDetails loadUserById(String userId) {
		User user = userRepository.findById(userId);
		return JwtUserDetails.create(user);
	}
}
