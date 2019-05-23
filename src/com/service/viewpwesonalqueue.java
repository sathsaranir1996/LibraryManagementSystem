package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.booking;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.util.dbConnect;

public class viewpwesonalqueue {
	
	Connection conn = null;
	public ArrayList viewQueue(booking booking)throws ClassNotFoundException, SQLException {
		//Connect database
		conn = (Connection) dbConnect.conn();
		String  username = booking.getUsername();
		
		String query1 = "SELECT * FROME queue WHERE userid ="+username+"";
		String st = booking.getView();
		ArrayList al = null;
		ArrayList listView = new ArrayList();
		
		Statement sta = (Statement) conn.createStatement();
		ResultSet  rs = sta.executeQuery(query1);
		
			while (rs.next()) {
            al = new ArrayList();
            
            al.add(rs.getInt(1));
            al.add(rs.getString(2));
            al.add(rs.getInt(3));
            al.add(rs.getString(4));

            listView.add(al);
			}
			
		conn.close();
		System.out.println("Disconnected from database");
		 
		return listView;	
		
	}


}
