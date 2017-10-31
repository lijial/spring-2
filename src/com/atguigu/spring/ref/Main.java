package com.atguigu.spring.ref;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) throws IllegalAccessException {
		
		//1. ´´½¨ IOC ÈÝÆ÷
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-annotation.xml");
		
		UserAction userAction = (UserAction) ctx.getBean("userAction");
		userAction.execute();
		System.out.println(userAction.executeParam());
		System.out.println(111);
	}
	
}
