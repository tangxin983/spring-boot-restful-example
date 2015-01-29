package com.github.tx.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author tangx
 * @since 2015年1月8日
 */

@Entity
@Table(name = "stock_info")
public class StockInfo {

	@Id
	private String code;

	private String name;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
