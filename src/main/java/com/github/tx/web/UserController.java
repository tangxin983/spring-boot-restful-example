package com.github.tx.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.tx.entity.User;
import com.github.tx.service.UserService;

/**
 * 遵照restful规范的控制器<p>
 * GET(200) /collection：返回资源对象的列表（数组）<p>
 * GET(200) /collection/{id}：返回单个资源对象<p>
 * POST(201) /collection：返回新生成的资源对象<p>
 * PUT(201) /collection/{id}：返回完整的资源对象<p>
 * DELETE(204) /collection/{id}：返回一个空文档<p>
 * @author tangx
 * @since 2014年12月23日
 */

@RestController
@RequestMapping("/user")
public class UserController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private UserService service;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public User create(@RequestBody User entity) {
		return service.save(entity);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.CREATED)
	public User update(@PathVariable("id") Long id, @RequestBody User entity) {
		User old = service.findOne(id);
		Assert.notNull(old);
		old.setEmail(entity.getEmail());
		old.setUserName(entity.getUserName());
		return service.save(entity);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User findOne(@PathVariable("id") Long id) {
		return service.findOne(id);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<User> findAll() {
		return service.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}
}
