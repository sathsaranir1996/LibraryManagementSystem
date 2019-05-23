package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Addbook;
import com.util.dbConnect;

public class updatebookdb {
	Connection conn = null;
	
	public void updatebookdb(Addbook addbook) throws SQLException {
		
		conn = (Connection)dbConnect.conn();
		
		String bookno = addbook.getBookId();
		
		
			String query3 = "update book set copyno =? where bookno ="+bookno+"";
			PreparedStatement ps = null;
			try {
				ps = (PreparedStatement) conn.prepareStatement(query3);
			
			
			int no = addbook.getCopy_No();
			int addno = addbook.getAddcopy();
			
			int totleCopy = no + addno;
			
			System.out.println(no);
			
			System.out.println(addno);
			
			ps.setInt(1,totleCopy);
		
			ps.executeUpdate();
			ResultSet rs = ps.executeQuery();
			
			conn.close();
			System.out.println("Disconnected from database");
			System.out.println(totleCopy);
			}
	
			catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
