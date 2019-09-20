package com.dh.demo.service.userservice.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dh.demo.dao.UserDAO;
import com.dh.demo.entity.User;
import com.dh.demo.service.userservice.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserDAO dao;
	@Override
	public User login(String username, String pw) {
		 Map<String, Object> map = new HashMap<String, Object>();
	        map.put( "userName", username);
	        map.put( "pw", pw );
		 return dao.login(map);
	}
	@Override
	public int cacheToken(String token) {
		// TODO Auto-generated method stub
		return 0;
	}

}
