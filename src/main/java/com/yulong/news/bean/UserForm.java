package com.yulong.news.bean;

import java.io.Serializable;

public class UserForm implements Serializable{
	private static final long serialVersionUID = 8751283205532159742L;
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
