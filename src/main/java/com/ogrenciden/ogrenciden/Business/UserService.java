package com.ogrenciden.ogrenciden.Business;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ogrenciden.ogrenciden.Model.User;
import com.ogrenciden.ogrenciden.Repository.UserRepository;

@Service
public class UserService {

	UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User saveOneUser(User newUser) {
		return userRepository.save(newUser);
	}

	public User getOneUser(Long userId) {
		return userRepository.findById(userId).orElse(null);
	}

	public User updateOneUser(Long userId, User newUser) {
		Optional<User> user = userRepository.findById(userId);
		if (user.isPresent()) {
			User foundUser = user.get();
			foundUser.setName(newUser.getName());
			foundUser.setLastName(newUser.getLastName());
			foundUser.setEmail(newUser.getEmail());
			foundUser.setPassword(newUser.getPassword());
		    userRepository.save(foundUser);
		    return foundUser;
		}
		else {
			return null;
		}
	}

	public void deleteById(Long userId) {
		userRepository.deleteById(userId);
	}	
}
