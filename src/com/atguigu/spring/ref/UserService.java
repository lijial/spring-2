package com.atguigu.spring.ref;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void addNew() throws IllegalAccessException {
		System.out.println("addNew...");
		userDao.save();
	}
	
	public String serviceExecuteParam() throws IllegalAccessException{
		System.out.println("execute...");
		return "success";
	}
	public String serviceExecuteParamA() throws IllegalAccessException{
		return "A";
	}
	public String serviceExecuteParamB() throws IllegalAccessException{
		return "B";
	}
	
	
}
