package com.basecamp3.apirest;

import java.util.Arrays;

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
		Long count = userRepository.count();
		if (count == 0) {
			Arrays.asList(
				new UserEntity("Luiz Paulo", "luizpilegilppa@gmail.com", "12345"), 
				new UserEntity("Luiz Paulo", "luizpilegilppa@gmail.com", "12345")
			).forEach((user) -> userRepository.save(user));
		}
	}
}
