package com.atguigu.spring.ref;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserAction {

	private UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	//µº»Îjunit∫Õmockito “¿¿µ
	public void execute(){
		System.out.println("execute...");
		userService.addNew();
	}
	
	public String executeParam(){
		System.out.println("execute...");
		userService.addNew();
		return "success";
	}
	
}
