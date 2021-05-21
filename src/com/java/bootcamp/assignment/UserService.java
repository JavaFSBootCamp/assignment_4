package com.java.bootcamp.assignment;

public class UserService {
	
	public User validateUser(String userName, String password, User[] userArray){
		for(User user:userArray) {
			if((user.getUsername().equalsIgnoreCase(userName)) && (user.getPassword().equals(password))) {
				return user;
			}
		}
		return null;
	}

	public String reformatingData(User[] userArray) {
		String formattedData = "";
		for(User user : userArray) {
			formattedData += user.getUsername()+", "+user.getPassword()+", "+user.getName()+", "+user.getRole() +"\n";
		}
		return formattedData;
	}
}
