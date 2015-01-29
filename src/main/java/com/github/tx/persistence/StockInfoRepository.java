package com.github.tx.persistence;

import org.springframework.data.repository.CrudRepository;

import com.github.tx.entity.StockInfo;

/** 
 * StockInfo DAO
 * @author tangx
 * @since 2015年1月27日
 */

public interface StockInfoRepository extends CrudRepository<StockInfo, String> {

}
