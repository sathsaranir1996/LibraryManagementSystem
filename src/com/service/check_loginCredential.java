package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.register_GS;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.util.dbConnect;

public class check_loginCredential {
Connection conn = null;
	
	public boolean loginUserService(register_GS register_GS) throws SQLException
	{
		
	
		//Connect database
		conn = (Connection) dbConnect.conn();
		
		try {
		    String query1 = "select * from users where username=? and password=?";
		    PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query1);
		    
			ps.setString(1, register_GS.getUsername());
			ps.setString(2, register_GS.getPassword());
			 
			//ps.executeUpdate();  no need that command it will error in consol
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) 
		           return true;
		     else 
		           return false;
			//conn.close();
			//System.out.println("Disconnected from database");
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
	}
