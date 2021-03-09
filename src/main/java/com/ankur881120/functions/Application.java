package com.ankur881120.functions;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.function.Function;

import com.ankur881120.functions.model.User;

@SpringBootApplication
public class Application {

	private ArrayList<User> users = new ArrayList<User>() {{
		add(new User(1, "OneUser", "One", "User"));
		add(new User(2, "TwoUser", "Two", "User"));
		add(new User(3, "ThreeUser", "Three", "User"));
		add(new User(4, "FourUser", "Four", "User"));
	}};
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public Function<String,User> GetUserFunction() {
		return userid -> 
			users.get(Integer.valueOf(userid)-1);
		
	}
}
