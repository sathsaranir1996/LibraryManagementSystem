package com.service;
	

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;

	import com.model.Addbook;
	import com.util.dbConnect;

	public class addbookavailability {
		Connection conn = null;

		public void addbookdb(Addbook addbook) {
			
			//Connect database
					conn = (Connection) dbConnect.conn();
					
					try {
						
						String query2 = "insert into availabilitybook(bookno,availablecopies,status) values(?,?,'Available')";
					    PreparedStatement ps2 = (PreparedStatement) conn.prepareStatement(query2);
					    
					    ps2.setString(1, addbook.getBookId());
					    ps2.setInt(2, addbook.getCopy_No());
						
					
						ps2.executeUpdate();
						ResultSet rs2 = ps2.executeQuery();
						
						System.out.println("Successfuly added book availability");
						conn.close();
						System.out.println("Disconnected from database");
					}catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

						
						
		
					    
		}
	}



