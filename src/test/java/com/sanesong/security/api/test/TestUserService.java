package com.sanesong.security.api.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sanesong.security.api.WebApplication;
import com.sanesong.security.api.entity.User;
import com.sanesong.security.api.service.UserService;
import com.sanesong.security.api.utils.MessageDigest;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestUserService {

	@Autowired
	private UserService userService;
	
	@Test
	public void testSaveUsers() {
		final User admin = new User();
		admin.setUserName("admin");
		admin.setPassword(MessageDigest.MD5("123456"));
		
		final User saved = userService.saveUser(admin);
		assertNotNull(saved);
	}
}
