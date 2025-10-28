package com.webproject.demo.appproject.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfiguration {
	
	
	//LDAP or Database
	//In Memory
	
	//InMemoryUserDetailsManager
	//public InMemoryUserDetailsManager(UserDetails... users)
	
	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		UserDetails userDetails = createNewUser("Aman", "Aman");
		UserDetails userDetails2 = createNewUser("ranga", "ranga");


	    return new InMemoryUserDetailsManager(userDetails, userDetails2);
	}

	private UserDetails createNewUser(String password, String username) {
		Function<String, String> PasswordEncoder = input -> passwordEncoder().encode(input);	    
		UserDetails userDetails = User.builder()
	    		.passwordEncoder(PasswordEncoder)
	            .username(username)
	            .password(password)
	            .roles("USER", "ADMIN")
	            .build();
		return userDetails;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    http.authorizeHttpRequests(auth -> auth
	            .anyRequest().authenticated()
	    );

	    http.formLogin(withDefaults());

	    http.csrf(csrf -> csrf.disable());  
	    http.headers(headers -> headers.frameOptions(frame -> frame.disable()));

	    return http.build();
	}
	
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//	    http.authorizeHttpRequests(auth -> auth
//	            .requestMatchers("/h2-console/**").permitAll()   // allow H2 console
//	            .anyRequest().authenticated()
//	    );
//
//	    http.formLogin(withDefaults());
//
//	    http.csrf(csrf -> csrf.disable());  
//	    http.headers(headers -> headers.frameOptions(frame -> frame.disable())); // H2 needs frames
//
//	    return http.build();
//	}




}
