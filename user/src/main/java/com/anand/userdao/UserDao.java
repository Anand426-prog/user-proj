package com.anand.userdao;

import java.util.List;

import com.anand.user.User;

public interface UserDao {

	public List<User> findAll();

	public User save(User user);

	public User findOne(int id);
	
	public void deleteByID(int id);

}
