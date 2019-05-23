package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.booking;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.util.dbConnect;

public class removequeue {
	
Connection conn = null;
	
	public void removequeue(booking booking)throws ClassNotFoundException, SQLException {
		//Connect database
		conn = (Connection) dbConnect.conn();
		try {
		String query = "DELETE FROM queue WHERE queueitemno =?";
	    PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query);
	    
	    ps.setInt(1, booking.getQueueitemno());
	    
        ps.executeUpdate();
		
		ResultSet rs = ps.executeQuery();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
