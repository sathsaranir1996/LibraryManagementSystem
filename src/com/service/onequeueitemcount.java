package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.booking;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.util.dbConnect;

public class onequeueitemcount {
	
	Connection conn = null;
	public int ueuecount(booking booking)throws ClassNotFoundException, SQLException {
		conn = (Connection) dbConnect.conn();
		int count = 0;
		try {
		String query2 = "SELECT COUNT(queueitemno) FROM queue WHERE username =?";
		
	       PreparedStatement ps2 = (PreparedStatement) conn.prepareStatement(query2);
			
			ps2.setString(1, booking.getUsername());
			ps2.executeUpdate();
			
			ResultSet rs2 = ps2.executeQuery();
			
			while (rs2.next()) 
				count = rs2.getInt(1);
			conn.close();
			
		}
		
		catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
		return count;
	
	}
}
