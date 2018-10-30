package com.xsjt.dao;

import org.apache.ibatis.annotations.Mapper;

import com.xsjt.model.Role;


/**
 * 角色 Dao
 * @author Joe
 */
@Mapper
public interface RoleMapper {

	boolean addRole(Role role);
}
