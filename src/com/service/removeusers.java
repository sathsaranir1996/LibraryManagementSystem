package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.register_GS;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.util.dbConnect;

public class removeusers {
		Connection conn = null;
		
		public void removeusers(register_GS reg)throws ClassNotFoundException, SQLException {
			//Connect database
			conn = (Connection) dbConnect.conn();
			
			String query = "DELETE FROM users WHERE username =?";
		    PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query);
		    
		    ps.setString(1, reg.getUsername());
		    
	        ps.executeUpdate();
			
			ResultSet rs = ps.executeQuery();
		}

}
