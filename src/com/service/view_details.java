package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.register_GS;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.util.dbConnect;

public class view_details {

	Connection conn = null;
	public ArrayList view_details(register_GS ksm)throws ClassNotFoundException, SQLException {
		//Connect database
				conn = (Connection) dbConnect.conn();
				//variable ekak hadanne ehemai 
		String query3 =null;
		String  username = ksm.getUsername();
		
		query3 = "SELECT * FROM users where username ="+username+"";
		
		ArrayList al = null;
		ArrayList listView = new ArrayList();
		
		Statement sta = (Statement) conn.createStatement();
		ResultSet  rs = sta.executeQuery(query3);
		
			while (rs.next()) {
            al = new ArrayList();

            al.add(rs.getString(1));
            al.add(rs.getString(2));
            al.add(rs.getString(3));
            al.add(rs.getString(4));
            al.add(rs.getString(5));
            al.add(rs.getString(6));
            al.add(rs.getString(7));
            al.add(rs.getString(8));
            al.add(rs.getString(9));

//name	address	phone	birthday	nic	email	username	password	usertype

            listView.add(al);
			}
			
		conn.close();
		System.out.println("Disconnected from database");
		
		return listView;
		
	}
}
