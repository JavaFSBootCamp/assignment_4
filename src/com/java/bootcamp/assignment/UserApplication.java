package com.java.bootcamp.assignment;

import java.util.Scanner;

public class UserApplication {
	
	static FileService fileService = new FileService();
	static User[] userArray = fileService.getUserData();
	
	static UserService userService = new UserService();
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args){
		int loginAttempts=0;
		User loggedInUser = null;
		
		
		String userName;
		String password;
		
		while((loginAttempts < 5)) {
			System.out.println("Enter your email: ");
			userName = scanner.nextLine();
			System.out.println("Enter your password: ");
			password= scanner.nextLine();
			
			loggedInUser = userService.validateUser(userName, password, userArray);
			if(loggedInUser != null){
				System.out.println("Welcome: "+ loggedInUser.getName() + " : Role :  " + loggedInUser.getRole());
				break;
			}
			else
			{
				loginAttempts++;
				if(loginAttempts >= 5) {
					System.out.println("Too many failed login attempts, you are now locked out.");
				} else
				{
					System.out.println("Invalid login, please try again." + loginAttempts);
				}
			}
			
		}
		
		if(loggedInUser != null) {
			int option = 0; 
			while(option < 4) {
				option = generateOptions(loggedInUser);
				
				switch(option) {
				case 0:
					System.out.println("Option 0 ");
					break;
				case 1:
					updateUserName(loggedInUser);
					break;
				case 2:
					updatePassword(loggedInUser);
					break;
				case 3:
					updateName(loggedInUser);
					break;
				case 4:
					System.out.println("Option 4 ");
					break;
				}
				//userService.reformatingData(userArray);
				fileService.setUserData(userService.reformatingData(userArray));
			}
		}
		scanner.close();
	}
	
	private static int generateOptions(User loggedInUser) {
		
		System.out.println("Please choose from the following options:");
		if(loggedInUser instanceof SuperUser) {
			System.out.println("(0) Log in as another user");
		}
		System.out.println("(1) Update username");
		System.out.println("(2) Update password");
		System.out.println("(3) Update name");
		System.out.println("(4) Exit");
		
		return Integer.parseInt(scanner.nextLine());
	}
	
	private static void updateUserName(User loggedInUser) {
		System.out.println("Please type in your new username: ");
		String username = scanner.nextLine();
		loggedInUser.setUsername(username);
		
		fileService.setUserData(userService.reformatingData(userArray));
	}
	
	private static void updatePassword(User loggedInUser) {
		System.out.println("Please type in your new password: ");
		String password = scanner.nextLine();
		loggedInUser.setPassword(password);
		
		fileService.setUserData(userService.reformatingData(userArray));
	}
	
	private static void updateName(User loggedInUser) {
		System.out.println("Please type in your new name: ");
		String name = scanner.nextLine();
		loggedInUser.setName(name);
		
		fileService.setUserData(userService.reformatingData(userArray));
	}
}
