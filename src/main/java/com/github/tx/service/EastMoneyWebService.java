package com.github.tx.service;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.fluent.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tx.core.common.ServiceException;
import com.github.tx.entity.StockInflow;
import com.github.tx.entity.StockInfo;
import com.github.tx.entity.WebServiceEntity;

/**
 * 东方财富web服务
 * 
 * @author tangx
 * @since 2015年1月8日
 */

@Service
public class EastMoneyWebService {

	private Logger logger = LoggerFactory.getLogger(getClass());

	// 东方财富网web服务前置网址
	private static final String PREFIX_URL = "http://nufm.dfcfw.com/EM_Finance2014NumericApplication/JS.aspx/JS.aspx?";

	@Autowired
	private StockInfoService stockInfoService;
	
	@Autowired
	private StockInflowService stockInflowService;

	/**
	 * 初始化所有stock数据
	 */
	public void initStockInfo() {
		try {
			String content = getZjlx();
			// 转化为标准json格式
			content = content.replace("pages", "\"pages\"");
			content = content.replace("data", "\"data\"");
			ObjectMapper mapper = new ObjectMapper();
			WebServiceEntity wsEntity = mapper.readValue(content,
					WebServiceEntity.class);
			List<StockInfo> infos = new ArrayList<>();
			for (String data : wsEntity.getData()) {
				String[] splits = data.split(",");
				StockInfo info = new StockInfo();
				info.setCode(splits[1]);
				info.setName(splits[2]);
				infos.add(info);
			}
			stockInfoService.deleteAll();;// 清空原有数据
			stockInfoService.save(infos);// 插入数据
		} catch (Exception e) {
			throw new ServiceException("initStockInfo error", e);
		}
	}

	/**
	 * 今日资金流向
	 */
	public void zjlx() {
		try {
			String content = getZjlx();
			// 转化为标准json格式
			content = content.replace("pages", "\"pages\"");
			content = content.replace("data", "\"data\"");
			ObjectMapper mapper = new ObjectMapper();
			WebServiceEntity wsEntity = mapper.readValue(content,
					WebServiceEntity.class);
			List<StockInflow> infos = new ArrayList<>();
			for (String data : wsEntity.getData()) {
				String[] splits = data.split(",");
				if(splits.length > 6){
//					StockInflow inflow = new StockInflow();
//					inflow.setSymbol(StringUtils.defaultString(splits[1]));
//					inflow.setDate(Integer.valueOf(DateUtil.getCurrentDate("yyyyMMdd")));
//					if(NumberUtils.isNumber(splits[3])){
//						inflow.setClosing(Double.valueOf(splits[3]));
//					}
//					if(NumberUtils.isNumber(splits[4])){
//						inflow.setChg(Double.valueOf(splits[4]));
//					}
//					if(NumberUtils.isNumber(splits[5])){
//						inflow.setInflow(Double.valueOf(splits[5]));
//					}
//					if(NumberUtils.isNumber(splits[6])){
//						inflow.setPercent(Double.valueOf(splits[6]));
//					}
//					if(inflow.getInflow() != null){
//						infos.add(inflow);
//					}
				}
			}
			stockInflowService.save(infos);// 插入数据
		} catch (Exception e) {
			throw new ServiceException("zjlx error:" + e.getMessage(), e);
		}
	}
	
	public void zjlx3(){
		String content = getZjlx(3);
		System.out.println(content);
	}

	/**
	 * 
	 * 获取资金流向,接口参数意义如下
	 * <p>
	 * type:ct 不清楚意义 必须有
	 * <p>
	 * st:(BalFlowMainNet) 必须有 表示N日
	 * <p>
	 * sr:-1 不需要
	 * <p>
	 * p:1 页码
	 * <p>
	 * ps:50 每页显示数
	 * <p>
	 * js:var CmKcxLNM={pages:(pc),date:"2014-10-22",data:[(x)]} 返回格式
	 * <p>
	 * token:894050c76af8597a853f5b408b759f5d 不清楚意义 必须有
	 * <p>
	 * cmd:C._AB 不清楚意义 必须有
	 * <p>
	 * sty:DCFFITA3 不清楚意义 必须有
	 * <p>
	 * rt:47356755 不需要
	 */
	private String getZjlx(int... days) {
		try {
			int day = 0;
			String st_str = "BalFlowMain";
			if(days != null && days.length == 1){
				day = days[0];
			}
			if(day != 0){
				st_str += "Net" + day;
			}
			String url = PREFIX_URL
					+ "type=ct&st=(" + st_str + ")&p=1&ps=4000"
					+ "&js=" + URLEncoder.encode("{pages:(pc),data:[(x)]}", "UTF-8")
					+ "&token=894050c76af8597a853f5b408b759f5d&cmd=C._AB&sty=DCFFITA";
			return Request.Get(url).execute().returnContent().asString();
		} catch (Exception e) {
			throw new ServiceException("getZjlx error", e);
		}
	}
}
