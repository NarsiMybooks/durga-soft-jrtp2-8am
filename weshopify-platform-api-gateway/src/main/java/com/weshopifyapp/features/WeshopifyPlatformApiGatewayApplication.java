package com.weshopifyapp.features;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.filter.factory.RequestRateLimiterGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.context.annotation.Bean;

import reactor.core.publisher.Mono;

@SpringBootApplication
@EnableDiscoveryClient

public class WeshopifyPlatformApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeshopifyPlatformApiGatewayApplication.class, args);
	}

	/*
	 * @Bean KeyResolver usersKeyResolver() { return exchange ->
	 * Mono.just("weshopify-app-cache"); }
	 */
	
	@Bean
	public KeyResolver userKeyResolver() {
		return exchange -> Mono.just("1");
	}
}
