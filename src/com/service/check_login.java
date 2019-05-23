package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.register_GS;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.util.dbConnect;

public class check_login {
Connection conn = null;
	
	public String check_login(register_GS register_GS)
	{
		//Connect database
		conn = (Connection) dbConnect.conn();
		String value=null;

		try {
			String query = "select * from users where username=? and password=?";
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query);
			
			ps.setString(1, register_GS.getUsername());
			ps.setString(2, register_GS.getPassword());
			
			System.out.println( register_GS.getUsername());
			System.out.println( register_GS.getPassword());
			
			ResultSet rs = ps.executeQuery();
			
				while (rs.next()) 
					value = rs.getString("usertype");
			
			//conn.close();
			System.out.println("Disconnected from database");
			System.out.println(value);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
		}
}

