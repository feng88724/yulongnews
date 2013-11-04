package com.yulong.news.persistence;

import java.util.List;

import com.yulong.news.bean.User;

public interface UserMapper {
	public List<User> listUsersByUsername();
	public User getUserByUserId(String userId);
	public User getUser(Integer id);
	public int updateUser(User user);
	public int deleteUser(Integer id);
	public int insertUser(User user);
}
