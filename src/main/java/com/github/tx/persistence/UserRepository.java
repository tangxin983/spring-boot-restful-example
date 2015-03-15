package com.github.tx.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.tx.entity.User;

/** 
 * User DAO
 * @author tangx
 * @since 2015年1月27日
 */

public interface UserRepository extends JpaRepository<User, Long> {

}
