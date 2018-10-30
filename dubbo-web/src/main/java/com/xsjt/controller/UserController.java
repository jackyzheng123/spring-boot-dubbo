package com.xsjt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xsjt.api.UserService;
import com.xsjt.model.Role;
import com.xsjt.model.User;

/**
 * 用户 控制层
 * 使用  @Reference 调用 dubbo 服务
 * @author Joe
 *
 */
@RestController
public class UserController {

	// 使用  @Reference 调用 dubbo 服务
	@Reference(version = "1.0.0", check = false)
	private UserService userService;
	
	@RequestMapping("/findUsers/{username}")
	@ResponseBody
	public Object findUsers(@PathVariable("username") String username) {
		System.out.println(username);
		Map<String ,Object> map = new HashMap<String,Object>();
		map.put("pageNum", 1);
    	map.put("pageSize", 2);
    	map.put("username", username);
		List<User> users = userService.findUsers(map);
		return users;
	}
	
	@RequestMapping("/addUserAndRole")
	@ResponseBody
	public Object saveUserAndRole(@RequestParam("username") String username, 
			@RequestParam("rolename") String rolename){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user", new User(username, "12345"));
		map.put("role", new Role(rolename));
		boolean flag = userService.addUserAndRole(map);
		System.out.println(flag == true ? "增加成功！" : "增加失败！");
		return map;
	}
}
