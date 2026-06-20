package com.coddingshutte.SecurityApp.SecurityApplication;

import com.coddingshutte.SecurityApp.SecurityApplication.entity.User;
import com.coddingshutte.SecurityApp.SecurityApplication.services.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SecurityApplicationTests {

	@Autowired
	private JwtService jwtService;

	@Test
	void contextLoads() {
		User user = new User(4L, "pratik@gmail.com", "1234");

		String token = jwtService.generateToken(user);

		System.out.println(token);

		Long id = jwtService.getUserIdFromToke(token);
		System.out.println(id);
	}

}
