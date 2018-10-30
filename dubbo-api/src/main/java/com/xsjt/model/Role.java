package com.xsjt.model;

import java.io.Serializable;

/**
 * 角色 实体类
 * @author Joe
 *
 */
public class Role implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String rolename;
	
	public Role() {
		super();
	}
	
	public Role(String rolename) {
		super();
		this.rolename = rolename;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	
	@Override
	public String toString() {
		return "Role [id=" + id + ", rolename=" + rolename + "]";
	}
}
