package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.booking;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.util.dbConnect;

public class removecart {
	Connection conn = null;
	
	public void removecart(booking booking)throws ClassNotFoundException, SQLException {
		//Connect database
		conn = (Connection) dbConnect.conn();
		try {
		String query = "DELETE FROM add_to_cart WHERE cartitemid =?";
	    PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query);
	    
	    ps.setInt(1, booking.getCartitemid());
	    
        ps.executeUpdate();
		
		ResultSet rs = ps.executeQuery();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
