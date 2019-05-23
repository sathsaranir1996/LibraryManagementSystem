package com.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;
import com.util.dbConnect;

public class viewbookdetails {
	
Connection conn = null;
	
	public ArrayList viewbookdetails() throws ClassNotFoundException, SQLException 
	{
		//Connect database
		conn = (Connection)dbConnect.conn();
		
		ArrayList al=null;
		ArrayList viewDetails =new ArrayList();
		String query = "select * from book where bookno=?";
		
		Statement st1 = (Statement) conn.createStatement();
		ResultSet  rs = st1.executeQuery(query);
		
			while (rs.next()) {
            al = new ArrayList();
            al.add(rs.getInt(1));
            al.add(rs.getString(2));
            al.add(rs.getString(3));
            al.add(rs.getInt(4));
            al.add(rs.getString(5));
            al.add(rs.getInt(6));
            
            viewDetails.add(al);
          
			}
			
		conn.close();
		System.out.println("Disconnected from database");
		
		return viewDetails;
		
	}

}
