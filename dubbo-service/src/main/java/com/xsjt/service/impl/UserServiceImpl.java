package com.xsjt.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.xsjt.api.UserService;
import com.xsjt.dao.RoleMapper;
import com.xsjt.dao.UserMapper;
import com.xsjt.model.Role;
import com.xsjt.model.User;

/**
 * 接口实现
 * @author Joe
 */
public class UserServiceImpl implements UserService{

	// 注入dao
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private RoleMapper roleMapper;
	
	/**
	 * 分页查询 用户
	 * @param map
	 * @return
	 */
	@Override
	public List<User> findUsers(Map<String, Object> map) {
		int pageNum = (int) map.get("pageNum");
		int pageSize = (int) map.get("pageSize");
		// 第一个参数是第几页；第二个参数是每页显示条数
		PageHelper.startPage(pageNum, pageSize);
		return userMapper.findUsers(map);
	}

	
	/**
     * 增加用户 和  角色，测试事务
     * @param map
     * @return
     */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public boolean addUserAndRole(Map<String , Object> map) {
		User user = (User) map.get("user");
		Role role = (Role) map.get("role");
		// 增加用户
		boolean userFlag = userMapper.addUser(user);
		// 增加角色
		boolean roleFlag = roleMapper.addRole(role);
		
		return userFlag && roleFlag;
	}

}
