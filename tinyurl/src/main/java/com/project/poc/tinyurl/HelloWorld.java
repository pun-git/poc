package com.project.poc.tinyurl;

import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
@RestController
@SpringBootApplication
public class HelloWorld
{
	private Logger logger = LoggerFactory.getLogger(HelloWorld.class);
	
	@PostConstruct
	private void init() {
		logger.info("Creating a spring boot application .");
	}
	
	@GetMapping("/helloworld/{name}")
	public String helloWorld(@PathVariable String name) {
		return "Good morning - "+name;
	}
	
    public static void main(String[] args) {
    	System.out.println("POrt - "+System.getenv().get("PORT"));
    	System.out.println("DYNO - "+System.getenv().get("DYNO"));
    	SpringApplication springApplication = new SpringApplication(HelloWorld.class);
    	Map<String, Object> config = new HashMap<>();
    	config.put("server.port", System.getenv().get("PORT"));
    	springApplication.setDefaultProperties(config);
    	springApplication.run(args);
	}
    
    public static int getAvailablePortNo() {
    	int port = 0;
    	try {
    		ServerSocket serverSocket = new ServerSocket(0);
        	port = serverSocket.getLocalPort();
    		serverSocket.close();
    	}catch(Exception e) {
    		
    	}
    	System.out.println("Port find out - "+port);
    	return port;
    	/*
    	for(int i=0; i<Integer.MAX_VALUE-1;i++) {
    		try(Socket socket = new Socket(Inet6Address.getLocalHost(), i)) {
    			return i;
    		}catch(UnknownHostException e) {
    			
    		}catch(IOException e) {
    			
    		}finally {
    			socket.close();
    		}
    	}
    	return -1;*/
    }
}
