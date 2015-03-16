package com.github.tx;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 应用入口
 * 
 * @author tangx
 * @since 2014年12月15日
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) throws Exception {
		/*
		 * 使用系统属性来指定要激活的profile,如果不指定则使用默认profile
		 * 激活后application-{profile}.properties将会覆盖默认的application.properties
		 */
//		System.setProperty("spring.profiles.active", "dev");
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// 应用启动时要干的事写在这 ;args是命令行参数
	}
}
