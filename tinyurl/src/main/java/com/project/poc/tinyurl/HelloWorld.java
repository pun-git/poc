package com.project.poc.tinyurl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
@RestController
@EnableAutoConfiguration
public class HelloWorld
{
	public HelloWorld() {
		System.out.println("Hello World");
	}
	
	@GetMapping("/helloworld/{name}")
	public String helloWorld(@PathVariable String name) {
		return "Good morning - "+name;
	}
	
    public static void main(String[] args) {
    	SpringApplication springApplication = new SpringApplication(HelloWorld.class);
    	Map<String, Object> config = new HashMap<>();
    	config.put("server.port", "8010");
    	springApplication.setDefaultProperties(config);
    	springApplication.run(args);
	}
}
