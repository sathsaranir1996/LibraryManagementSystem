package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Addbook;
import com.util.dbConnect;

public class addbookdb {
	Connection conn = null;

	public void addbookdb(Addbook addbook) {
		
		//Connect database
				conn = (Connection) dbConnect.conn();
				
				try {
					String query1 = "insert into book(bookno,title,author,copyno,description) values(?,?,?,?,?)";
				    PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query1);
				    
				    ps.setString(1, addbook.getBookId());
					ps.setString(2, addbook.getBookTitle());
					ps.setString(3, addbook.getAuthor());
					ps.setInt(4, addbook.getCopy_No());
					ps.setString(5, addbook.getDescription());
					
				
					
					ps.executeUpdate();
					ResultSet rs = ps.executeQuery();
					
					String query2 = "insert into availabilitybook(bookno,availablecopies,status) values(?,?,'Available')";
				    PreparedStatement ps2 = (PreparedStatement) conn.prepareStatement(query2);
				    
				    ps2.setString(1, addbook.getBookId());
				    ps2.setInt(2, addbook.getCopy_No());
					
				
					ps2.executeUpdate();
					ResultSet rs2 = ps2.executeQuery();
					
					System.out.println("Successfuly added book");
					conn.close();
					System.out.println("Disconnected from database");
				}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

					
					
	
				    
	}
}
