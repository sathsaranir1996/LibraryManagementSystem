package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.register_GS;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.util.dbConnect;

public class register_Q {

Connection conn = null;
	
	public void adduser(register_GS reg ) {
	
	//Connect database
		conn = (Connection) dbConnect.conn();
		
		try {
			String query1 = "insert into users(name,address,phone,birthday,nic,email,username,password,usertype) values(?,?,?,?,?,?,?,?,'User')";
		    PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query1);
		    
			ps.setString(1, reg.getName());
			ps.setString(2, reg.getAddress());
			ps.setString(3, reg.getPhone());
			ps.setString(4, reg.getBirthday());
			ps.setString(5, reg.getNic());
			ps.setString(6, reg.getEmail());
			ps.setString(7, reg.getUsername());
			ps.setString(8, reg.getPassword());
			
			ps.executeUpdate();
			ResultSet rs = ps.executeQuery();
			System.out.println("Successfuly added a user");
			conn.close();
			System.out.println("Disconnected from database");

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
	}
}
		
