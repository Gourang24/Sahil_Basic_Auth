package com.springboot.microservices.user.authenticate;

import lombok.Data;

@Data
public class AuthenticateRequest {
	
	private String userName;
	private String password;

}
