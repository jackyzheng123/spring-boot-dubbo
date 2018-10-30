package com.xsjt.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xsjt.api.HelloWorldService;

/**
 * 消费者，控制层
 * @author Joe
 * 
 * 在服务类上加@Reference，代表这个是调用远程dubbo的接口
 * 
 * @Reference(version = “1.0.0”) 通过该注解，订阅该接口版本为 1.0.0 的 Dubbo 服务
 */
@RestController
public class HelloController {

	@Reference(version="1.0.0",check=false,timeout=6000)
	private HelloWorldService helloService;
	
	@RequestMapping("/hello/{name}")
	@ResponseBody
	public String hello(@PathVariable(value = "name") String name){
		String result = helloService.sayHello(name);
		return result;
	}
}
