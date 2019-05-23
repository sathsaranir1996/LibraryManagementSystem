package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.booking;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.util.dbConnect;

public class hupdatestatus {
	Connection conn = null;
	public void updatestatus(booking booking)throws ClassNotFoundException, SQLException {
		
		//Connect database
		conn = (Connection) dbConnect.conn();
		try {
	
			String query3 = "Update executeUpdate set status=? where bookno=?";
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query3);
    
				ps.setString(1,booking.getStatus());
				ps.setString(2, booking.getBookid());
    
				ps.executeUpdate();
	
				ResultSet rs1 = ps.executeQuery();
				System.out.println("sucsess");
	
	}
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		conn.close();
	}
}
