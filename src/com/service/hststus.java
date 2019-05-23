package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.booking;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.util.dbConnect;

public class hststus {
	Connection conn = null;
	public String status(booking booking)throws ClassNotFoundException, SQLException {
	
		int availability = 0;
		String status = "Available";
		
		//Connect database
		conn = (Connection) dbConnect.conn();
		try {
	
	String query1 = "SELECT * FROM availabilitybook where bookno =?";
	PreparedStatement ps1 = (PreparedStatement) conn.prepareStatement(query1);
	
	ps1.setString(1, booking.getBookid());
	ps1.executeUpdate();
	
	ResultSet rs = ps1.executeQuery();
	
	while (rs.next()) 
		availability = rs.getInt("availablecopies");
	
	
	
	conn.close();
	
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			

}
		if(availability == 0) {
			status = "Not Available";	
		}
		
		else {
			status = "Available";
		}
		return status;
		
	}
}
