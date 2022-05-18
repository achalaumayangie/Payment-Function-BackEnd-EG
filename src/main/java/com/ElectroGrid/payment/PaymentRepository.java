package com.ElectroGrid.payment;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.sql.PreparedStatement;

public class PaymentRepository 
{
	
	
	Connection con = null;
	
	public PaymentRepository() 
	{
		
		
		
		//database connectivity 
		
		String url = "jdbc:mysql://localhost:3306/electrogrid";
		
		String username = "root";
		String password = "achala";
		
	//exception handling	
		try 
		{
			  
			  Class.forName("com.mysql.jdbc.Driver");
			  con=DriverManager.getConnection(url,username,password);
			  
		  }
		catch(Exception e) {
			  System.out.print(e);
		  }
		
		 
		
	}
	
	public List<Payment> getPayments()
	{
		List<Payment> Payments = new ArrayList<>();
		String sql = "select * from payment";
		
		//exception handling
		try {
			
			Statement st=con.createStatement();
			ResultSet rs= st.executeQuery(sql);
			while(rs.next()) {
				
				Payment p=new Payment();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setAccNo(rs.getInt(3));;
				p.setDueDate(rs.getString(4));
				p.setAmount(rs.getString(5));
				
				
				Payments.add(p);
			}
			
		}catch(Exception e) {
			System.out.print(e);
		}
		
		
		return Payments;
	}
	
	public Payment getPayment(int id) 
	{
		String sql = "select * from payment where id="+id;
		Payment p=new Payment();
		
		//exception handling
		try {
			
			Statement st=con.createStatement();
			ResultSet rs= st.executeQuery(sql);
			if(rs.next()) {
				
				
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setAccNo(rs.getInt(3));;
				p.setDueDate(rs.getString(4));
				p.setAmount(rs.getString(5));
				
				
				
			}
			
		}catch(Exception e) {
			System.out.print(e);
		}
		return p;
		
		
		
		
		
	}


	public void create(Payment p1) {
		String sql = "insert into payment values(?,?,?,?,?)";
		
		//exception handling
		
try {
			
	PreparedStatement st=con.prepareStatement(sql);
			
	st.setInt(1,p1.getId());
	st.setString(2, p1.getName());
	st.setInt(3, p1.getAccNo());
	st.setString(4, p1.getDueDate());
	st.setString(5,p1.getAmount());
	st.executeUpdate();
	
			
		}catch(Exception e) {
			System.out.print(e);
		}
		
	}
	
	public void update(Payment p1) {
		String sql = "update payment set name =?,accNo=?,dueDate =?,amount=?  where id=? ";
		
		
		//exception handling
try {
			
	PreparedStatement st=con.prepareStatement(sql);
			
	st.setString(1, p1.getName());
	st.setInt(2,p1.getAccNo());
	st.setString(3,p1.getDueDate());
	st.setString(4, p1.getAmount());
	st.setInt(5, p1.getId());
	
	st.executeUpdate();
	
			
		}catch(Exception e) {
			System.out.print(e);
		}
		
	}
	
	public void delete(int id) {
		String sql = "delete from payment where id=? ";
		
		//exception handling
		try {
					PreparedStatement st=con.prepareStatement(sql);
					st.setInt(1,id);
					st.executeUpdate();
					
				}catch(Exception e) {
					System.out.print(e);
				}	
	}

	
	
	
	

}