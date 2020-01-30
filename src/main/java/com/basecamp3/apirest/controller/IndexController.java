package com.basecamp3.apirest.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api")
public class IndexController {
	
	@GetMapping
	public Flux<Map<String, String>> getStatusApi() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("version", "0.0.1");
		return Flux.just(map);
	}

}
