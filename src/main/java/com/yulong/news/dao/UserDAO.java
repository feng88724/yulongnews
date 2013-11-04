package com.yulong.news.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.yulong.news.bean.User;
import com.yulong.news.persistence.UserMapper;

public class UserDAO {
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 
	 * @param userNm
	 * @return
	 */
	public List<User> listUsersByUsername() {
		List<User> userObjs = userMapper.listUsersByUsername();
		return userObjs;
	}
	/**
	 * 
	 * @param userNm
	 * @return
	 */
	public User getUserByUserId(String userId) {
		User userObj = userMapper.getUserByUserId(userId);
		return userObj;
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	public User getUserById(Integer id) {
		User userObj = userMapper.getUser(id);
		return userObj;
	}
	/**
	 * 
	 * @param user
	 * @return
	 */
	public int updateUser(User user) {
		return userMapper.updateUser(user);
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	public int deleteUser(Integer id) {
		return userMapper.deleteUser(id);
	}
	/**
	 * 
	 * @param user
	 * @return
	 */
	public int insertUser(User user) {
		return userMapper.insertUser(user);
	}
}
