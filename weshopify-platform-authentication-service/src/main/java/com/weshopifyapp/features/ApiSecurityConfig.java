package com.weshopifyapp.features;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebSecurity
public class ApiSecurityConfig {

	@Autowired
	AuthenticationManagerBuilder builder;
	@Bean
	public SecurityWebFilterChain filterChain(ServerHttpSecurity http) {
		http.authorizeExchange((exchanges) ->
        exchanges
            // any other request requires the user to be authenticated
            .anyExchange().authenticated()).oauth2Login((oauth2Login) ->
       	            oauth2Login
    	                  .authenticationManager(inmemory(builder)));
		return http.build();

		
	}
	
	public AuthenticationManager inmemory(AuthenticationManagerBuilder authnBuilder) {
		authnBuilder.inMemoryAuthentication().withUser("admin").password("admin").roles("admin");
		return authnBuilder.build();
	}
	
}
