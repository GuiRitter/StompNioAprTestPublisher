package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RepositoryRestController
@RequestMapping
public class Controller {

	@Autowired
	private SimpMessagingTemplate template;

	@GetMapping("getHelloWorld")
	public ResponseEntity<Object> getHelloWorld() {
		Map<String, Object> map = new HashMap<>();
		map.put("subject", "Hello, World!");
		template.convertAndSend("/topic/hello_world", map);
		return ResponseEntity.ok("Hello, World!");
	}
}
