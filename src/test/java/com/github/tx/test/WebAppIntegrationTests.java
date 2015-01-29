package com.github.tx.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;
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
// @ActiveProfiles("production")
public class WebAppIntegrationTests {

	private Logger logger = LoggerFactory.getLogger(getClass());

	RestTemplate template = new TestRestTemplate();

	@Before
	public void init() {
		User user = new User("1@163.com", "用户1");
		template.postForEntity("http://localhost:8080/user", user, String.class);
		user = new User("2@163.com", "用户2");
		template.postForEntity("http://localhost:8080/user", user, String.class);
	}

	@Test
	public void testGet() {
		ResponseEntity<String> entity = template.getForEntity(
				"http://localhost:8080/user/1", String.class);
		logger.info("======get======");
		logger.info("status code is:{}", entity.getStatusCode());
		logger.info("body is:{}", entity.getBody());
		logger.info("======get======");
	}

	// @Test
	public void testException() {
		logger.info("404 result is:"
				+ template.getForObject("http://localhost:8080/404",
						String.class));
		logger.info("500 result is:"
				+ template.getForObject("http://localhost:8080/err",
						String.class));
	}

	@Test
	public void testPost() {
		ResponseEntity<String> entity = template.postForEntity(
				"http://localhost:8080/user", new User("post@163.com", "post"),
				String.class);
		logger.info("======post======");
		logger.info("status code is:{}", entity.getStatusCode());
		logger.info("body is:{}", entity.getBody());
		logger.info("======post======");
	}

	@Test
	public void testDelete() {
		logger.info("======before del======");
		logger.info("user2 is:"
				+ template.getForEntity("http://localhost:8080/user/2",
						String.class).getBody());
		template.delete("http://localhost:8080/user/2");
		logger.info("======after del======");
		logger.info("user2 is:"
				+ template.getForEntity("http://localhost:8080/user/2",
						String.class).getBody());

	}

	@Test
	public void testPut() {
		logger.info("======before put======");
		logger.info("user1 is:"
				+ template.getForEntity("http://localhost:8080/user/1",
						String.class).getBody());
		template.put("http://localhost:8080/user/1", new User("put@163.com", "put"));
		logger.info("======after put======");
		logger.info("user1 is:"
				+ template.getForEntity("http://localhost:8080/user/1",
						String.class).getBody());
	}
}
