package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dao.Dao;
import com.example.demo.entity.User;

@SpringBootApplication
public class SpringBootCrud2Application implements CommandLineRunner{
	
	@Autowired
	private Dao userDao;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrud2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		//INSERTION 
		
		
		
//		User user1=new User("Vaibhav","abc@gmail.com","Male","Pune");
//		 User user2=new User("Tambe","tambe@gmail.com", "Male", "Nashik");
//		
//		user1.setName("Vaibhav");
//		user1.setEmail("abc@gmail.com");
//		user1.setGender("Male");
//		user1.setCity("pune");
//		
//		boolean status=	userDao.insertuser(user1);
//		if(status) {
//			System.out.println("User inserted succefully");
//		}
//		else 			System.out.println("User Failed not insert data");
//		}
//		
//		
		
		
		// UPDATION METHOD 
		
//		User user3=new User("Abhi", "abc@gmail.com", "Male", "Nashik");
//		
//	boolean status=	userDao.updateUser(user3);
//	if(status) {
//		System.out.println(" Updation Success");
//	}
//	else {
//		System.out.println(" Updation Fail");
//	}
//		
//		
	
	
	//DELETE
		
		 
//	boolean status=	userDao.deleteUserByEmail("abc@gmail.com");
//		if(status) {
//			System.out.println("Deletion success");
//		}
//		else {
//			System.out.println("Deletion fail");
//		}
//		
//	
//	
	
	
	
		//Select 
		
//	User user=	userDao.getUserByEamil("abc@gmail.com");
//		
//		System.out.println("Name : " +user.getName());
//		System.out.println("Email : " +user.getEmail());
//		System.out.println("Gender : " +user.getGender());
//		System.out.println("City : " +user.getCity());
//	
//	
	
		
		
		
		
		
		//select all user
     List<User> list=userDao.getAllUsers();		
     for(User user:list) {
    	 System.out.println("Name : " +user.getName()); 	
    	 System.out.println("Email : " +user.getEmail());
		System.out.println("Gender : " +user.getGender());
		System.out.println("City : " +user.getCity());
	  System.out.println(" ===================================");

    	 
     }
		
		
	}
}

