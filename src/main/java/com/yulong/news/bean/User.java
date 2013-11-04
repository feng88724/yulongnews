package com.yulong.news.bean;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 8751282105532159742L;
	private Integer id;
	private String userId;
	private String userPsd;
	private String userGroup;
	private String userNm;
	private String email;
	private Long phoneNum;
	private String address;
	private Integer zipCd;
	private String userStatus;
	private String validCd;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPsd() {
		return userPsd;
	}
	public void setUserPsd(String userPsd) {
		this.userPsd = userPsd;
	}
	public String getUserGroup() {
		return userGroup;
	}
	public void setUserGroup(String userGroup) {
		this.userGroup = userGroup;
	}
	public String getUserNm() {
		return userNm;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(Long phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getZipCd() {
		return zipCd;
	}
	public void setZipCd(Integer zipCd) {
		this.zipCd = zipCd;
	}
	
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	public String getValidCd() {
		return validCd;
	}
	public void setValidCd(String validCd) {
		this.validCd = validCd;
	}
}
