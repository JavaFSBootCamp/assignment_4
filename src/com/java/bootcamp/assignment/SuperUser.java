package com.java.bootcamp.assignment;

public class SuperUser extends User{
	private static String SUPER_USER = "super_user";
	
	public SuperUser(String[] values) {
		
		this.setUsername(values[0]);
		this.setPassword(values[1]);
		this.setName(values[2]);
		this.setRole(SUPER_USER);
		
	}

}
