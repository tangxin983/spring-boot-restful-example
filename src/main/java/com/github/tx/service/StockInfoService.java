package com.github.tx.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.tx.core.common.BaseService;
import com.github.tx.entity.StockInfo;

/** 
 * 
 * @author tangx
 * @since 2014年12月23日
 */
@Service
@Transactional
public class StockInfoService extends BaseService<StockInfo, String>{
		 
}