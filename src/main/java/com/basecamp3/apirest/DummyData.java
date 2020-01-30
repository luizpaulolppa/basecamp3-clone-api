package com.basecamp3.apirest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.basecamp3.apirest.entity.UserEntity;
import com.basecamp3.apirest.repository.UserRepository;

@Component
public class DummyData implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();
		Map<String, String> users = new HashMap<>();
		users.put("Luiz Paulo", "luizpilegilppa@gmail.com");
		users.put("Pilegi", "luiz.pilegi@ateliware.com");
		users.entrySet().stream().forEach((el) -> userRepository.save(new UserEntity(el.getKey(), el.getValue(), "12345"))); 
	}
}
