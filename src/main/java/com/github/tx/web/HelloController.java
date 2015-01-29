package com.github.tx.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.tx.core.configuration.ApplicationProperties;

/** 
 * 
 * @author tangx
 * @since 2014年12月23日
 */

@RestController  
@RequestMapping
public class HelloController {
	
//	@Value("${app.desc}")
//	private String desc;
	
	@Autowired
	private ApplicationProperties prop;

	@RequestMapping
	public String hello() {
		return prop.getDesc();
	}

	@RequestMapping("/err")
	public String err() {
		throw new IllegalArgumentException("Server error");
	}

	 
}
