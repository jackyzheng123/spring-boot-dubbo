package com.xsjt.api;

import java.util.List;
import java.util.Map;

import com.xsjt.model.User;

/**
 * 用户接口
 * @author Joe
 */
public interface UserService {

	/**
	 * 分页查询 用户
	 * @param map
	 * @return
	 */
	List<User> findUsers(Map<String, Object> map);
	
	/**
     * 增加用户 和  角色，测试事务
     * @param map
     * @return
     */
    boolean addUserAndRole(Map<String , Object> map);
}
