package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository
public class Dao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
           public boolean insertuser(User user) {

        	    boolean status=false;
        	   try {
        	   String insert_sql="insert into user(name,email,gender,city)values(?,?,?,?)";
        	  int count= jdbcTemplate.update(insert_sql, user.getName(),user.getEmail(),user.getGender(),user.getCity());
        	  
        	  if(count>0) {
        		  status=true;
        		  
        	  }
        	  else {
				status=false;
			}
        	  
        	   }catch (Exception e) {
				// TODO: handle exception
        		   status=false;
        		   e.printStackTrace();
			}
        	   return status;
           }
	 
}
