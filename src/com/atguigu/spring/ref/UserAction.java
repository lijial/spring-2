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
	public void execute() throws IllegalAccessException{
		System.out.println("execute...");
		System.out.println(userService.serviceExecuteParam());
		try{
			userService.addNew();   
		}catch(Exception e) {
			System.out.println(111);
		}
	}
	
	public String executeParam() throws IllegalAccessException{
		System.out.println("execute...");
		userService.addNew();
		return "success";
	}
	
	public String executeParams() throws IllegalAccessException{
		System.out.println("userService.serviceExecuteParam() is not fuck ? "+userService.serviceExecuteParam());
		return "success";
	}
	
}
