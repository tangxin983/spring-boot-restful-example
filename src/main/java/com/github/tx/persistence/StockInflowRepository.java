package com.github.tx.persistence;

import org.springframework.data.repository.CrudRepository;

import com.github.tx.entity.StockInflow;

/** 
 * StockInflow DAO
 * @author tangx
 * @since 2015年1月27日
 */

public interface StockInflowRepository extends CrudRepository<StockInflow, Long> {

}
