package com.github.tx.core.configuration;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 定时任务配置
 * 
 * @author tangx
 * @since 2014年12月30日
 */
@Configuration
@EnableScheduling
public class ScheduleConfiguration {

	private Logger logger = LoggerFactory.getLogger(getClass());

	// 每30s触发（如果执行时间大于间隔时间，会并行执行。如果想让下个任务与上个任务间隔固定时间用fixedDelay）
	@Scheduled(fixedRate = 1000 * 30)
	public void reportCurrentTime() {
		logger.info("Scheduling Tasks Examples: The time is now "
				+ dateFormat().format(new Date()));
	}

	// 每1分钟触发
	@Scheduled(cron = "0 */1 *  * * * ")
	public void reportCurrentByCron() {
		logger.info("Scheduling Tasks Examples By Cron: The time is now "
				+ dateFormat().format(new Date()));
	}

	private SimpleDateFormat dateFormat() {
		return new SimpleDateFormat("HH:mm:ss");
	}

}
