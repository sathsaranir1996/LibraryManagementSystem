package com.service;

	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;

	import com.model.booking;
	import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
	import com.util.dbConnect;

	public class viewCart {


		Connection conn = null;
		public ArrayList viewcart(booking booking)throws ClassNotFoundException, SQLException {
			//Connect database
			conn = (Connection) dbConnect.conn();
			String  username = booking.getUsername();
			
			String query1 = "SELECT ac.cartitemid, b.title,b.author,a.status,b.bookno FROM availabilitybook a,book b,add_to_cart ac WHERE (a.bookno = b.bookno) and (a.bookno = ac.bookno) and(ac.username =?)";
			String st = booking.getView();
			ArrayList al = null;
			ArrayList listView = new ArrayList();
//			Statement sta = (Statement) conn.createStatement();
			PreparedStatement preSt = (PreparedStatement) conn.prepareStatement(query1);
			preSt.setString(1, username);
			ResultSet  rs = preSt.executeQuery();
				while (rs.next()) {
	            al = new ArrayList();
	            
	            al.add(rs.getString(1));
	            al.add(rs.getString(2));
	            al.add(rs.getString(3));
	            al.add(rs.getString(4));
	            al.add(rs.getString(5));

	            listView.add(al);
				}
				
			conn.close();
			System.out.println("Disconnected from database");
			 
			return listView;	
			
		}


	}



