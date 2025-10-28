package com.webproject.demo.appproject.login_page;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
public boolean authenticate(String username, String password) {
		
		boolean isValidUserName = username.equalsIgnoreCase("aman");
		boolean isValidPassword = username.equalsIgnoreCase("aman");
		
		return (isValidUserName && isValidPassword);
	}

}
