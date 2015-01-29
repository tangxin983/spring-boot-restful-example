package com.github.tx.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 个股资金流入
 * 
 * @author tangx
 * @since 2015年1月8日
 */

@Entity
@Table(name = "stock_inflow")
public class StockInflow {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String symbol;

	private Integer date;

	private Double closing;

	private Double chg;

	private Double inflow;

	private Double percent;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Double getClosing() {
		return closing;
	}

	public void setClosing(Double closing) {
		this.closing = closing;
	}

	public Double getChg() {
		return chg;
	}

	public void setChg(Double chg) {
		this.chg = chg;
	}

	public Double getInflow() {
		return inflow;
	}

	public void setInflow(Double inflow) {
		this.inflow = inflow;
	}

	public Double getPercent() {
		return percent;
	}

	public void setPercent(Double percent) {
		this.percent = percent;
	}

	public Integer getDate() {
		return date;
	}

	public void setDate(Integer date) {
		this.date = date;
	}

}
