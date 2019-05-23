package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Addbook;
import com.util.dbConnect;

public class updateavailability {

Connection conn = null;
	
	public void updatebookdb(Addbook addbook) throws SQLException {
		
		conn = (Connection)dbConnect.conn();
		
		String bookno = addbook.getBookId();
		
			try {
				
			int value = 0;
			int no = addbook.getCopy_No();
			int addno = addbook.getAddcopy();
			
			String query = "select * from availabilitybook where bookno ="+bookno+"";
			PreparedStatement ps1 = (PreparedStatement) conn.prepareStatement(query);
		
			
			ResultSet rs1 = ps1.executeQuery();
			
				while (rs1.next()) 
					value = rs1.getInt("availablecopies");
				
				System.out.println(value +"bbb");
				
			int	finalvalue = value + addno;
			
			String query2 = "update availabilitybook set availablecopies =?,status='Available' where bookno ="+bookno+"";
			PreparedStatement ps2 = (PreparedStatement) conn.prepareStatement(query2);
			
			ps2.setInt(1,finalvalue);
			
			ps2.executeUpdate();
			ResultSet rs2 = ps2.executeQuery();
			
			System.out.println(addno);
			
			conn.close();
			System.out.println("Disconnected from database");
			System.out.println(finalvalue);
			}
			
	
			catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
