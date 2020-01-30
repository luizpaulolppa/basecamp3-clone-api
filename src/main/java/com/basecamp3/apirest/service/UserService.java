package com.basecamp3.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basecamp3.apirest.dto.MsgError;
import com.basecamp3.apirest.dto.UserDTO;
import com.basecamp3.apirest.entity.UserEntity;
import com.basecamp3.apirest.exception.MultipleIllegalArgumentException;
import com.basecamp3.apirest.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public List<UserEntity> findAll() {
		return userRepository.findAll();
	}

	public UserEntity createUser(UserDTO user) {
		if (user.getName() == null || user.getName().isBlank()) {
			throw new MultipleIllegalArgumentException(new MsgError("Name is required"));
		}
		
		if (user.getEmail() == null || user.getEmail().isBlank()) {
			throw new MultipleIllegalArgumentException(new MsgError("Email is required"));
		}
		
		if (user.getPassword() == null || user.getPassword().isBlank()) {
			throw new MultipleIllegalArgumentException(new MsgError("Password is required"));
		}
		
		UserEntity userFinded = userRepository.findByEmail(user.getEmail());
		if (userFinded != null) {
			throw new MultipleIllegalArgumentException(new MsgError("Existing email"));
		}
		
		return userRepository.save(new UserEntity(user.getName(), user.getEmail(), user.getPassword()));
	}

}
