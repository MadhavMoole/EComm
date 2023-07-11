package com.madhav.ecommerce.security;

import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfiguration {
	
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		http.authorizeHttpRequests(
//				(auth) -> auth
//				.requestMatchers("/").permitAll()
//				.requestMatchers("/mainPage").hasRole("USER")
//				.requestMatchers("/admin").hasRole("ADMIN")
//				.anyRequest().authenticated()
//				);
//		return http.build();
//	}
}
