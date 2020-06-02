package com.conn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.conn.pojo.Admissions;
import com.conn.pojo.LoginInfo;
import com.login.utility.MyConnection;

public class LoginInfoDaoImpl implements LoginInfoInterface{

	@Override
	public boolean saveLoginInfo(LoginInfo loginInfo) {
		Connection conn = null;
		try {
			conn = MyConnection.getConnectionObj();
			PreparedStatement ps = conn
					.prepareStatement("insert into login_info(name,user_name,password,address,city,state,pincode,contact_no,role,status)"
							+ " values (?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, loginInfo.getName());
			ps.setString(2, loginInfo.getUser_name());
			ps.setString(3, loginInfo.getPassword());
			ps.setString(4, loginInfo.getAddress());
			ps.setString(5, loginInfo.getCity());
			ps.setString(6, loginInfo.getState());
			ps.setString(7, loginInfo.getPincode());
			ps.setLong(8, loginInfo.getContact_no());
			ps.setString(9, loginInfo.getRole());
			ps.setString(10, loginInfo.getStatus());
			
			
			int no = ps.executeUpdate();
			if (no > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
		
		
	}

	@Override
	public LoginInfo getLoginInfoByUserNameAndPasswordAndRoleAndStatus(
			String userName, String password, String role, String status) {
		Connection conn = null;
		try{
		conn = MyConnection.getConnectionObj();
		PreparedStatement ps = conn
				.prepareStatement("select * from login_info as o where o.user_name=? and o.password=? and o.role=? and o.status=? ");
		ps.setString(1, userName);
		ps.setString(2, password);
		ps.setString(3, role);
		ps.setString(4, status);
		
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			LoginInfo loginInfo = new LoginInfo();
			loginInfo.setId(rs.getInt("id"));
			loginInfo.setName(rs.getString("name"));
			loginInfo.setUser_name(rs.getString("user_name"));
			loginInfo.setRole(role);
			loginInfo.setStatus(status);
			
		  	return loginInfo;
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}finally{
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

		return null;
	}

	@Override
	public List<LoginInfo> getLoginInfoByRoleEqualsDoctorAndStatusEqualsActive() {
		Connection conn = null;
		List<LoginInfo> loginInfos =  new ArrayList<LoginInfo>();
		try{
		conn = MyConnection.getConnectionObj();
		PreparedStatement ps = conn
				.prepareStatement("select * from login_info as o where  o.role=? and o.status=? ");
		
		ps.setString(1,"doctor");
		ps.setString(2, "active");
		
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			LoginInfo loginInfo = new LoginInfo();
			loginInfo.setId(rs.getInt("id"));
			loginInfo.setName(rs.getString("name"));
			loginInfo.setUser_name(rs.getString("user_name"));
			loginInfo.setAddress(rs.getString("address"));
			loginInfo.setPassword(rs.getString("password"));
			loginInfo.setState(rs.getString("state"));
			loginInfo.setCity(rs.getString("city"));
			loginInfo.setPincode(rs.getString("pincode"));
			loginInfo.setContact_no(rs.getLong("contact_no"));
			loginInfo.setRole(rs.getString("role"));
			loginInfo.setStatus("active");
			
			loginInfos.add(loginInfo);
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}finally{
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

		return loginInfos;
	}


 
}
