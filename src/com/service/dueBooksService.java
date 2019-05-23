package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Addpayment;
import com.util.dbConnect;



public class dueBooksService {
	Connection conn = null;

	public List<Addpayment> showDueBook(String username) {
		
		//Connect database
				conn = (Connection) dbConnect.conn();
				
				try {
					
					String query = "select *, DATEDIFF(due_date, CURDATE()) AS diff from payment where nic = (select nic from users where username = '"+username+"') AND return_date IS NULL";
				    PreparedStatement ps2 = (PreparedStatement) conn.prepareStatement(query);
				    ResultSet rs2 = ps2.executeQuery();
				    
				    int i = 0;
				    
				    List<Addpayment> al=new ArrayList<Addpayment>();
				    while(rs2.next()) {
				    	Addpayment mod = new Addpayment();
				    	mod.setId(rs2.getInt("id"));
				    	mod.setNic(rs2.getString("nic"));
				    	mod.setBookno(rs2.getString("bookno"));
				    	mod.setIssued_date(rs2.getString("issued_date"));
				    	mod.setDue_date(rs2.getString("due_date"));
				    	mod.setReturn_date(rs2.getString("return_date"));
				    	mod.setAmount(rs2.getString("amount"));
				    	mod.setDiff(rs2.getInt("diff"));
				    	al.add(mod);
				    	i++;
				    }
				    
				    conn.close();
				    
				    if(i == 0) {
				    	System.out.println("no records");
				    	return null;
				    }
				    else {
				    	System.out.println(al.toString());
				    	return al;
				    }
				}catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("Error in dueBooksService.java");
					e.printStackTrace();
					return null;
				}

					
					
	
				    
	}
	
public List<Addpayment> notify(String username) {
		
		//Connect database
				conn = (Connection) dbConnect.conn();
				
				try {
					
					String query = "select *, DATEDIFF(due_date, CURDATE()) AS diff from payment where nic = (select nic from users where username = '"+username+"') AND return_date IS NULL";
				    PreparedStatement ps2 = (PreparedStatement) conn.prepareStatement(query);
				    ResultSet rs2 = ps2.executeQuery();
				    
				    int i = 0;
				    
				    List<Addpayment> al=new ArrayList<Addpayment>();
				    while(rs2.next()) {
				    	Addpayment mod = new Addpayment();
				    	mod.setId(rs2.getInt("id"));
				    	mod.setNic(rs2.getString("nic"));
				    	mod.setBookno(rs2.getString("bookno"));
				    	mod.setIssued_date(rs2.getString("issued_date"));
				    	mod.setDue_date(rs2.getString("due_date"));
				    	mod.setReturn_date(rs2.getString("return_date"));
				    	mod.setAmount(rs2.getString("amount"));
				    	mod.setDiff(rs2.getInt("diff"));
				    	al.add(mod);
				    	i++;
				    }
				    
				    conn.close();
				    
				    if(i == 0) {
				    	System.out.println("no records");
				    	return null;
				    }
				    else {
				    	return al;
				    }
				}catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("Error in dueBooksService.java");
					e.printStackTrace();
					return null;
				}

					
					
	
				    
	}

public List<Addpayment> showAllBooks() {
	
	//Connect database
			conn = (Connection) dbConnect.conn();
			
			try {
				
				String query = "select *, DATEDIFF(due_date, CURDATE()) AS diff from payment WHERE return_date IS NULL";
			    PreparedStatement ps2 = (PreparedStatement) conn.prepareStatement(query);
			    ResultSet rs2 = ps2.executeQuery();
			    
			    int i = 0;
			    
			    List<Addpayment> al=new ArrayList<Addpayment>();
			    while(rs2.next()) {
			    	Addpayment mod = new Addpayment();
			    	mod.setId(rs2.getInt("id"));
			    	mod.setNic(rs2.getString("nic"));
			    	mod.setBookno(rs2.getString("bookno"));
			    	mod.setIssued_date(rs2.getString("issued_date"));
			    	mod.setDue_date(rs2.getString("due_date"));
			    	mod.setReturn_date(rs2.getString("return_date"));
			    	mod.setAmount(rs2.getString("amount"));
			    	mod.setDiff(rs2.getInt("diff"));
			    	al.add(mod);
			    	i++;
			    }
			    
			    conn.close();
			    
			    if(i == 0) {
			    	System.out.println("no records");
			    	return null;
			    }
			    else {
			    	return al;
			    }
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Error in dueBooksService.java");
				e.printStackTrace();
				return null;
			}			    
}

public void addPayment(int id, float pay, String date) {
	
	//Connect database
			conn = (Connection) dbConnect.conn();
			
			try {
				
				String query = "UPDATE payment SET `amount`= "+pay+",`return_date` = '"+date+"' WHERE `id` = " + id;
				PreparedStatement pstm = conn.prepareStatement(query);
				int i = pstm.executeUpdate();
				
			    conn.close();
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Error in dueBooksService.java");
				e.printStackTrace();
				
			}			    
}
}
