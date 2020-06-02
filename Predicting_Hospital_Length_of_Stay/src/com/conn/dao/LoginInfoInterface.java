package com.conn.dao;

import java.util.List;

import com.conn.pojo.LoginInfo;

public interface LoginInfoInterface {

	
	public boolean saveLoginInfo(LoginInfo loginInfo);
	public List<LoginInfo> getLoginInfoByRoleEqualsDoctorAndStatusEqualsActive();
	public LoginInfo getLoginInfoByUserNameAndPasswordAndRoleAndStatus(String userName,String password,String role,String status);
	
}
