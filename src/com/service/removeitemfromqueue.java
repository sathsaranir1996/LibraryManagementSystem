package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.booking;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.util.dbConnect;

public class removeitemfromqueue {
	Connection conn = null;
	int availability1= 0;
	public void addqueue(booking booking)throws ClassNotFoundException, SQLException {
		//Connect database
		conn = (Connection) dbConnect.conn();
		
		String query = "DELETE FROM queue WHERE queueitemno =?";
	    PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query);
	    
	    ps.setInt(1, booking.getQueueitemno());
	    
        ps.executeUpdate();
		
		ResultSet rs = ps.executeQuery();
		
		String query2 = "SELECT * FROM availabilitybook where bookno =?";
		PreparedStatement ps2 = (PreparedStatement) conn.prepareStatement(query2);
		
		ps2.setString(1, booking.getBookid());
		ps2.executeUpdate();
		
		ResultSet rs2 = ps2.executeQuery();
		
		while (rs2.next()) 
			availability1 = rs2.getInt("availablecopies");
		availability1 = availability1 + 1;
		
		String query3 = "Update availabilitybook set availablecopies=? where bookno=?";
	    PreparedStatement ps3 = (PreparedStatement) conn.prepareStatement(query3);
	    
	    ps3.setInt(1,availability1);
	    ps3.setString(2, booking.getBookid());
	    
        ps3.executeUpdate();
		
		ResultSet rs6 = ps3.executeQuery();
	}
}
