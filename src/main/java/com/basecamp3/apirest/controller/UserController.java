package com.basecamp3.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.basecamp3.apirest.dto.MsgError;
import com.basecamp3.apirest.dto.UserDTO;
import com.basecamp3.apirest.entity.UserEntity;
import com.basecamp3.apirest.exception.MultipleIllegalArgumentException;
import com.basecamp3.apirest.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<UserEntity>> getUsers() {
		try {
			return new ResponseEntity<List<UserEntity>>(userService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping
	public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO) {
		try {
			return new ResponseEntity<UserEntity>(userService.createUser(userDTO), HttpStatus.OK);
		} catch (MultipleIllegalArgumentException ex) {
			return new ResponseEntity<MsgError>(ex.getError(), HttpStatus.PRECONDITION_FAILED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
