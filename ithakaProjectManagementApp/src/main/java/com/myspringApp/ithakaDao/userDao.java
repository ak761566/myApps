package com.myspringApp.ithakaDao;

import java.util.List;

import com.myspringApp.ithakaModel.Users;

public interface userDao {
	
	public void addUser(Users user);
	public List<Users> getAllUsers();
	public Users getUserById(String userId);
	public void updateUser(Users user);

}
