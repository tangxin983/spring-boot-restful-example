package com.github.tx.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import com.github.tx.Application;
import com.github.tx.entity.User;

/**
 * 测试restful webapp
 * 
 * @author tangx
 * @since 2014年12月26日
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest
@ActiveProfiles("dev")
public class WebAppIntegrationTests {

	private Logger logger = LoggerFactory.getLogger(getClass());

	RestTemplate template = new TestRestTemplate();

	// @Test
	public void testException() {
		logger.info("======testException======");
		logger.info("404 result is:"
				+ template.getForObject("http://localhost:8080/404",
						String.class));
		logger.info("500 result is:"
				+ template.getForObject("http://localhost:8080/err",
						String.class));
		logger.info("======testException======");
	}

	@Test
	public void testGet() {
		logger.info("======testGet======");
		User user = template.getForObject("http://localhost:8080/user/1",
				User.class);
		logger.info("user1 is:{}", user.toString());
		logger.info("======testGet======");
	}

	@Test
	public void testPost() {
		User newUser = new User();
		newUser.setEmail("newuser@163.com");
		newUser.setUserName("newuser");
		User user = template.postForObject("http://localhost:8080/user", newUser, User.class);
		logger.info("======testPost======");
		logger.info("new user is:{}", user.toString());
		logger.info("======testPost======");
	}

	@Test
	public void testPut() {
		logger.info("======testPut======");
		logger.info(
				"before put,user1 is:{}",
				template.getForObject("http://localhost:8080/user/1",
						User.class).toString());
		User updated = new User();
		updated.setId(1l);
		updated.setEmail("put@163.com");
		updated.setUserName("putName");
		template.put("http://localhost:8080/user", updated);
		logger.info(
				"after put,user1 is:{}",
				template.getForObject("http://localhost:8080/user/1",
						User.class).toString());
		logger.info("======testPut======");
	}

	@Test
	public void testDelete() {
		logger.info("======testDelete======");
		logger.info("before del,user2 is:"
				+ template.getForObject("http://localhost:8080/user/2", User.class).toString());
		template.delete("http://localhost:8080/user/2");
		logger.info("after del,user2 is:" + template.getForObject("http://localhost:8080/user/2", User.class));
		logger.info("======testDelete======");

	}

}
