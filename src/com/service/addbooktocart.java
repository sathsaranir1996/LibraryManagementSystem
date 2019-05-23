package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Addbook;
import com.util.dbConnect;

public class addbooktocart {
	Connection conn = null;

	public void addbookcart(Addbook addbook) throws SQLException {
		
		//Connect database
				conn = (Connection) dbConnect.conn();
				
				try {
					String query1 = "insert into add_to_cart(username,bookno) values(?,?)";
				    PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query1);
				    
				    ps.setString(1, addbook.getUsernam());
				    ps.setString(2, addbook.getBookId());
					
				
					ps.executeUpdate();
					ResultSet rs = ps.executeQuery();
				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
	}
					
				

}
