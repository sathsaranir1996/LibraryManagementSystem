package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.register_GS;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.util.dbConnect;

public class searchbook {
		
	Connection conn = null;
		
		public ArrayList searchbook(register_GS reg) throws ClassNotFoundException, SQLException 
		{
			//Connect database
			conn = (Connection) dbConnect.conn();
			
			String se = reg.getSearch();
			
			ArrayList al=null;
			ArrayList search_list =new ArrayList();
			String query = "select av.bookno, b.title,b.author,av.status,b.description,b.copyno from book b,availabilitybook av where (av.bookno = b.bookno) and (b.title like '%"+se+"%' or b.author like '%"+se+"%')and(av.status like '%Available%')";
			
			Statement st = (Statement) conn.createStatement();
			ResultSet  rs = st.executeQuery(query);
			
				while (rs.next()) {
	            al = new ArrayList();

	            al.add(rs.getString(1)); 
	            al.add(rs.getString(2)); 
	            al.add(rs.getString(3));
	            al.add(rs.getString(4));
	            al.add(rs.getString(5));
	            al.add(rs.getInt(6));


	            search_list.add(al);
				}
				
			conn.close();
			System.out.println("Disconnected from database");
			
			return search_list;
			
			
		}

	

}
