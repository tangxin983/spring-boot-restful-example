package com.github.tx.test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.validation.constraints.Null;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import com.github.tx.Application;

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
public class DatabaseInitTest {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private RestTemplate template;

	private HttpHeaders headers = new HttpHeaders();
	
	private static final String PREFIX_URL = "http://nufm.dfcfw.com/EM_Finance2014NumericApplication/JS.aspx/JS.aspx?";

	@Before
	public void init() {
		headers.set("User-Agent",
				"Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 5.1; Trident/4.0)");
		headers.set("Accept",
				"text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		headers.set("Accept-Language", "zh-cn,zh,en-US,en;q=0.5");
		headers.set("Accept-Charset",
				"ISO-8859-1,utf-8,gbk,gb2312;q=0.7,*;q=0.7");
		headers.set("Accept-Encoding", "gzip, deflate");
	}

	@Test
	public void test() throws UnsupportedEncodingException {
		String url = PREFIX_URL
				+ "type=ct&st=(BalFlowMain3)&p=1&ps=4000"
				+ "&js=" + URLEncoder.encode("{pages:(pc),data:[(x)]}", "UTF-8")
				+ "&token=894050c76af8597a853f5b408b759f5d&cmd=C._AB&sty=DCFFITA";
		ResponseEntity<?> entity = template.exchange(url, HttpMethod.GET,
				new HttpEntity<String>(headers), Null.class);
		logger.info("status code is:{}", entity.getStatusCode());
		logger.info("body is:{}", entity.getBody());
	}

}
