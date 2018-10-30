package com.xsjt.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.xsjt.model.User;


/**
 * UserMapper.xml代理
 * @author Joe
 */
@Mapper
public interface UserMapper {
	
	/**
	 * 分页查询 用户
	 * @param map
	 * @return
	 */
	List<User> findUsers(Map<String, Object> map);
	
    /**
     * 增加用户
     * @param user
     * @return
     */
    boolean addUser(User user);
    
}
