package com.java.bootcamp.assignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileService {
	
	public User[] getUserData() {
		System.out.println("Opening the file reader to read \"data.txt\" file and extract the data source.");
		User[] userArray = new User[20];
		
		BufferedReader fileReader = null;
		try {
			String line;
			int i = 0;
			fileReader = new BufferedReader(new FileReader("data.txt"));
			
			while((line = fileReader.readLine()) != null) {
				String[] values = line.split(", ");
				
				if("normal_user".equals(values[3])) {
					userArray[i] = new NormalUser(values);
				} else {
					userArray[i] = new SuperUser(values);
				}
				
				i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fileReader != null) {
				try {
					fileReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("Data extracted successfully! Closing file reader.");

		return userArray;
	}
	
	public void setUserData(String formattedData) {
		BufferedWriter fileWriter = null;
		
		try {
			fileWriter = new BufferedWriter(new FileWriter("data.txt"));
			fileWriter.write(formattedData);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(fileWriter != null) {
				try {
					fileWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
