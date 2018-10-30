package com.xsjt.service.impl;

import com.xsjt.api.HelloWorldService;

/**
 * 接口实现
 * @author Joe
 * 
 */
public class HelloSericeImpl implements HelloWorldService{

	/**
	 * 实现方法
	 */
	@Override
	public String sayHello(String name) {
		return "Hello " + name;
	}

}
