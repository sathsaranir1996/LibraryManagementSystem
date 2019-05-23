package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.booking;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.util.dbConnect;

public class hupdatecopycount {
	Connection conn = null;
	public void updatecopycount(booking booking)throws ClassNotFoundException, SQLException {
		
		//Connect database
		conn = (Connection) dbConnect.conn();
		try {
	String query6 = "Update availabilitybook set availablecopies=? where bookno=?";
    PreparedStatement ps6 = (PreparedStatement) conn.prepareStatement(query6);
    
    ps6.setInt(1,booking.getCopycount());
    ps6.setString(2, booking.getBookid());
    
    ps6.executeUpdate();
	
	ResultSet rs6 = ps6.executeQuery();
	conn.close();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			

}
	}

}
