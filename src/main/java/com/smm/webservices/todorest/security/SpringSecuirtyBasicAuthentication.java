package com.smm.webservices.todorest.security;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
public class SpringSecuirtyBasicAuthentication {
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
//		return httpSecurity
//		.authorizeHttpRequests(auth-> auth
//				.anyRequest().authenticated())
//		.httpBasic(Customizer.withDefaults())
//		.csrf(csrf->csrf.disable())
//		.headers(header ->header
//				.frameOptions( frameOptions -> frameOptions.sameOrigin()))
//		.sessionManagement(session->session
//				.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//		.build();
//	}
}
