package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.booking;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.util.dbConnect;

public class hgetcopycount2 {
	Connection conn = null;
	public int getcopy(booking booking)throws ClassNotFoundException, SQLException {
		
		//Connect database
		conn = (Connection) dbConnect.conn();
		int availability = 0;
		try {
	
	String query5 = "SELECT * FROM availabilitybook where bookno =?";
	PreparedStatement ps5 = (PreparedStatement) conn.prepareStatement(query5);
	
	ps5.setString(1, booking.getBookid());
	ps5.executeUpdate();
	
	ResultSet rs5 = ps5.executeQuery();
	
	while (rs5.next()) 
		availability = rs5.getInt("availablecopies");
	availability = availability +1;
	
	
	conn.close();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			

}
		return availability;
}
}
