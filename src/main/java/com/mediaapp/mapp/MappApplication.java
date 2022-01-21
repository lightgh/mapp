package com.mediaapp.mapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MappApplication.class, args);
	}

	@GetMapping("/")
	public String testEndpoint(){
		return "Hello World";
	}

	@GetMapping("/hello")
	@ResponseBody
	public Object showHelloWorldMessage(){
		return "Calling Show Hello World Message Method";
	}
}
