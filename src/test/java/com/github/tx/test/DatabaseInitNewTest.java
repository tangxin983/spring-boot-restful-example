package com.github.tx.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.github.tx.Application;

/**
 * 测试东方财富web服务
 * 
 * @author tangx
 * @since 2014年12月26日
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest
@ActiveProfiles("dev")
public class DatabaseInitNewTest {

//	@Autowired
//	private EastMoneyWebService ws;

	@Test
	public void initStockInfo() {
//		 ws.zjlx();
	}
}
