package com.dao;

import com.model.User;

public interface UserDao {
	User fetchSpecific(String email);
	int insert(User user);
}
