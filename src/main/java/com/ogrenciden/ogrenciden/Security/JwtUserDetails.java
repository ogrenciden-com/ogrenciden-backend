package com.ogrenciden.ogrenciden.Security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ogrenciden.ogrenciden.Model.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtUserDetails implements UserDetails{

	public Long id;
	private String name;
	private String lastName;
	private String email;
	private String password;
	private Collection<? extends GrantedAuthority> authorities;
	
	public JwtUserDetails(Long id, String name, String lastName, String email, String password,
			Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
	}
	
	public static  JwtUserDetails create(User user) {
		List<GrantedAuthority> authoritiesList = new ArrayList<>();
		authoritiesList.add(new SimpleGrantedAuthority("user"));
		return new JwtUserDetails(user.getUserId(), user.getName(), user.getLastName(), user.getEmail(), user.getPassword(), authoritiesList);
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	//**
	@Override
	public String getUsername() {
		return null;
	}

}
