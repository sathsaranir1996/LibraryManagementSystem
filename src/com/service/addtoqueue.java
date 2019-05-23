package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.booking;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.util.dbConnect;

public class addtoqueue {
	
	Connection conn = null;
	public void addqueue(booking booking)throws ClassNotFoundException, SQLException {
		
		//Connect database
		conn = (Connection) dbConnect.conn();
		int availability = 0;
		int availability1 = 0;
		String status;
		int count = 0;
		try {
		//=======================================================================================================================
			
			String query7 = "insert into queue(bookno,username,bookdate) values(?,?,?)";
		    PreparedStatement ps7 = (PreparedStatement) conn.prepareStatement(query7);
		   
			ps7.setString(1, booking.getBookid());
			ps7.setString(2, booking.getUsername());
			ps7.setString(3, booking.getSystemdate());
			
			ps7.executeUpdate();
			ResultSet rs7 = ps7.executeQuery();
		
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	    


}
