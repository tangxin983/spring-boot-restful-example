package com.github.tx.core.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 应用属性
 * @author tangx
 * @since 2014年12月23日
 */
@ConfigurationProperties(prefix = "app", ignoreUnknownFields = false)
@Component
public class ApplicationProperties {

	private String name;

	private String desc;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
