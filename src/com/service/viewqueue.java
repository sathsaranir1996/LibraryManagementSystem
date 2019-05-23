package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.booking;
import com.model.register_GS;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.util.dbConnect;

public class viewqueue {

			Connection conn = null;
			public ArrayList viewqueue(booking ksm)throws ClassNotFoundException, SQLException {
				//Connect database
						conn = (Connection) dbConnect.conn();
						//variable ekak hadanne ehemai 
				String query3 =null;
				String  username = ksm.getUsername();
				
				query3 = "SELECT q.queueitemno,q.bookdate,b.title FROM book b,queue q where b.bookno = q.bookno and username =?";
				PreparedStatement preSt = (PreparedStatement) conn.prepareStatement(query3);
				preSt.setString(1, username);
				ArrayList al = null;
				ArrayList listView = new ArrayList();
				
				
				ResultSet  rs = preSt.executeQuery();
				
					while (rs.next()) {
		            al = new ArrayList();

		            al.add(rs.getString(1));
		            al.add(rs.getString(2));
		            al.add(rs.getString(3));

		//name	address	phone	birthday	nic	email	username	password	usertype

		            listView.add(al);
					}
					
				conn.close();
				System.out.println("Disconnected from database");
				
				return listView;
				
			}
		

	
}
