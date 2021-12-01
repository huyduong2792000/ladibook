package com.huydq.ladibook.dao;

import java.util.List;

import com.huydq.ladibook.entity.User;

public interface UserDao {

	void insert(User user);
	
	void update(User user);
	
	void delete(long userId);
	
	User findById(long userId);
	
	List<User> findAll(int pageIndex, int pageSize);

	User findByEmailOrPhoneAndPassword(String account, String password, boolean verity);

	User loadUserByUsername(String account);
	
	User findByEmail(String email);
	
	int count();
}
