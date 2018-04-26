package com.wyc;

import com.wyc.entity.User;
import com.wyc.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMybatisApplicationTests {

	@Autowired
	private UserService userService;

	@Test
	public void contextLoads() {
		User user = new User();
		user.setNickname("陈奕迅");
		user.setEmail("pgm_sup@163.com");
		user.setPswd("123447");
		userService.save(user);
	}

}
