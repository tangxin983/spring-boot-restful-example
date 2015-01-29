package com.github.tx.entity;

import java.util.List;

/**
 * 用于组装webservice返回数据的实体
 * @author tangx
 * @since 2015年1月5日
 */

public class WebServiceEntity {

	private Integer pages;

	private List<String> data;

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public List<String> getData() {
		return data;
	}

	public void setData(List<String> data) {
		this.data = data;
	}

}
