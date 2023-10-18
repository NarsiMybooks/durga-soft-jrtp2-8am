package com.weshopifyapp.features;


import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersInfoResource {

	@GetMapping("/users")
	public Principal usersInfo(Principal user) {
		return user;
	}
}
