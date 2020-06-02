package com.conn.pojo;

public class LoginInfo {

	
	private int id;
	private String name;
	private String user_name;
	private String password;
	private String address;
	private long contact_no;
	private String city;
	private String state;
	private String pincode;
	private String role;
	private String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getContact_no() {
		return contact_no;
	}
	public void setContact_no(long contact_no) {
		this.contact_no = contact_no;
	}
	public LoginInfo() {
		// TODO Auto-generated constructor stub
	}
	public LoginInfo(String name, String user_name, String password,
			String address, long contact_no, String city, String state,
			String pincode, String role, String status) {
		super();
		this.name = name;
		this.user_name = user_name;
		this.password = password;
		this.address = address;
		this.contact_no = contact_no;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.role = role;
		this.status = status;
	}
	
	
	
	
}
