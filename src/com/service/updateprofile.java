package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Addbook;
import com.model.register_GS;
import com.util.dbConnect;

public class updateprofile {
	
Connection conn = null;
	
	public void updateprofile(register_GS reg) throws SQLException {
		
		conn = (Connection)dbConnect.conn();
		
		String username = reg.getUsername();
		
			String query3 = "update users set name = ?,address = ?,phone = ?,birthday = ?,nic = ?,email = ? where bookno ="+username+"";
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query3);
			
			ps.setString(1, reg.getName());
			ps.setString(2, reg.getAddress());
			ps.setString(3, reg.getPhone());
			ps.setString(4, reg.getBirthday());
			ps.setString(5, reg.getNic());
			ps.setString(6, reg.getEmail());
		
			ps.executeUpdate();
			ResultSet rs = ps.executeQuery();
			
			System.out.println("Successfuly update user");
			conn.close();
			System.out.println("Disconnected from database");
		
		
	}

}
