package com.java.bootcamp.assignment;

public class NormalUser extends User {
	private static String NORMAL_USER = "normal_user";

	public NormalUser(String[] values) {
		
		this.setUsername(values[0]);
		this.setPassword(values[1]);
		this.setName(values[2]);
		this.setRole(NORMAL_USER);
		
	}

	
}
