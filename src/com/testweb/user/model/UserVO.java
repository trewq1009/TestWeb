package com.testweb.user.model;

public class UserVO {

	private String id;
	private String name;
	private String pw;
	private String email;
	private String email_provider;
	private String phone_first;
	private String phone_second;
	private String phone_third;
	private String address;
	private String address_detail;
	private String regdate;
	
	 public UserVO() {
		 
	}

	public UserVO(String id, String pw, String name, String email, String email_provider, String phone_first,
			String phone_second, String phone_third, String address, String address_detail, String regdate) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.email_provider = email_provider;
		this.phone_first = phone_first;
		this.phone_second = phone_second;
		this.phone_third = phone_third;
		this.address = address;
		this.address_detail = address_detail;
		this.regdate = regdate;
	}

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail_provider() {
		return email_provider;
	}

	public void setEmail_provider(String email_provider) {
		this.email_provider = email_provider;
	}

	public String getPhone_first() {
		return phone_first;
	}

	public void setPhone_first(String phone_first) {
		this.phone_first = phone_first;
	}

	public String getPhone_second() {
		return phone_second;
	}

	public void setPhone_second(String phone_second) {
		this.phone_second = phone_second;
	}

	public String getPhone_third() {
		return phone_third;
	}

	public void setPhone_third(String phone_third) {
		this.phone_third = phone_third;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress_detail() {
		return address_detail;
	}

	public void setAddress_detail(String address_detail) {
		this.address_detail = address_detail;
	}
	
	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", name=" + name + ", pw=" + pw + ", email=" + email + ", email_provider="
				+ email_provider + ", phone_first=" + phone_first + ", phone_second=" + phone_second + ", phone_third="
				+ phone_third + ", address=" + address + ", address_detail=" + address_detail + ", regdate=" + regdate
				+ "]";
	}
	 
	
	
	
	
}
