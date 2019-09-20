package com.dh.demo.service.userservice;

import com.dh.demo.entity.User;

public interface UserService {
	public User login(String userName,String pw);
	public int cacheToken(String token);
}
