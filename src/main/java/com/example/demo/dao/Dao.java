package com.example.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
           
           public boolean updateUser(User user) {
        	   
        	 boolean  status=false;
        	  try {
        		  String updatesql = "UPDATE user SET  name=?, gender=?, city=? where email=?";
        		  int count = jdbcTemplate.update(updatesql, user.getName(), user.getGender(), user.getCity(),user.getEmail());

                    
                  if(count>0) {
                	  status=true;
                  }
                  else {
                	  status=false;
                  }
				
			} catch (Exception e) {
				// TODO: handle exception
				status=false;
				e.printStackTrace();
			}
        	  return status;
           }
           
           
           //DELETE
           public boolean deleteUserByEmail(String email) {
        	   
          	 boolean  status=false;
          	  try {
          		  String deletesql = "delete from user where email=?";
          		  int count = jdbcTemplate.update(deletesql,email);

                      
                    if(count>0) {
                  	  status=true;
                    }
                    else {
                  	  status=false;
                    }
  				
  			} catch (Exception e) {
  				// TODO: handle exception
  				status=false;
  				e.printStackTrace();
  			}
          	  return status;
             }
           
           
           
           
           
           public List<User> getAllUsers(){
        	   
        	   String selectsqlall="select * from user";
        	 return  jdbcTemplate.query(selectsqlall, new UserRowMapper());
           }
           
           
           
           
           public User getUserByEamil(String email) {
        	   
        	   String selectsql="select * from user where email=?";
       	 return  jdbcTemplate.queryForObject(selectsql, new UserRowMapper(),email);
        	   
           }
           public static final class UserRowMapper implements RowMapper<User>{

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			
				User user1=new User();
				user1.setName(rs.getString("name"));
				user1.setEmail(rs.getString("email"));
				user1.setGender(rs.getString("gender"));
				user1.setCity(rs.getString("city"));
				
				
				
				return user1;
			}
        	   
           }
           
           
	 
}
