package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Addbook;
import com.util.dbConnect;

public class Deletebookdb {
	
	Connection conn = null;
	
	public void Deletebookdb(Addbook addbook) {
		
		conn = (Connection) dbConnect.conn();
		
		try {
			String query2 = "delete from book where bookno = ?";
			PreparedStatement ps2 = (PreparedStatement) conn.prepareStatement(query2);
			
			ps2.setString(1, addbook.getBookId());
			
			ps2.executeUpdate();
			ResultSet rs2 = ps2.executeQuery();
			System.out.println("Successfuly delete book");
			conn.close();
			System.out.println("Disconnected from database");
		
	}catch (SQLException e) {
		e.printStackTrace();
	}
		
		}

}
