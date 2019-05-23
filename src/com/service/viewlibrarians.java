package com.service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.register_GS;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.util.dbConnect;

public class viewlibrarians {

		Connection conn = null;
		public ArrayList viewlib(register_GS ksm)throws ClassNotFoundException, SQLException {
			//Connect database
					conn = (Connection) dbConnect.conn();
					//variable ekak hadanne ehemai 
			String query3 =null;
			String  username = ksm.getUsername();
			
			query3 = "SELECT name,address,phone FROM users where usertype ='Admin'";
			PreparedStatement preSt = (PreparedStatement) conn.prepareStatement(query3);
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
