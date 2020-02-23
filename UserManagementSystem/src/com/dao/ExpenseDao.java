package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.config.DBConnect;
import com.pojo.Expense;

public class ExpenseDao {
	Connection con = DBConnect.getConnect();
	public boolean addExpense(Expense ex)
	{
		String sql = "insert into expense(expense,expenseType,expenseDate,email)values(?,?,?,?)";
		try
		{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDouble(1, ex.getExpense());
			ps.setString(2, ex.getExpenseType());
			ps.setString(3, ex.getExpenseDate());
			ps.setString(4, ex.getEmail());
			int i = ps.executeUpdate();
			if(i>0)
			{
				return true;
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
		
	}
	
	 public boolean updateExpense(Expense ex) {

			String sql = "update expense set expense=?,expenseType=? ,expenseDate=?,email=? where expenseId=?";

			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setDouble(1, ex.getExpense());
				ps.setString(2, ex.getExpenseType());
				ps.setString(3, ex.getExpenseDate());
				ps.setString(4,ex.getEmail());
				ps.setInt(5, ex.getExpenseId());

				int i1=ps.executeUpdate();
				System.out.println(i1);
				if(i1>0) {
					return true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
	    
	   public boolean deleteExpense(int expenseId)
	    {
	    	String sql  =  "Delete from expense where expenseId=?";
	    	try
	    	{
	    		PreparedStatement ps = con.prepareStatement(sql);
	    	   ps.setInt(1, expenseId);
	    	   int i= ps.executeUpdate();
	    	   if(i>0)
	    	   {
	    		   return true;
	    	   }
	    		
	    		
	    	}
	    	catch(Exception e)
	    	{
	    		e.printStackTrace();
	    	}
			return false;
	    	
	    }
	   
		public Expense getExpenseByExpenseId(int expenseId){
			String sql="select * from expense where expenseId=?";
			Expense ex = new Expense();
			try {
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setInt(1,expenseId);
				ResultSet rs=ps.executeQuery();
				while (rs.next()) {
					ex.setExpenseId(rs.getInt(1));
					ex.setExpense(rs.getDouble(2));
					ex.setExpenseType(rs.getString(3));
					ex.setExpenseDate(rs.getString(4));
					ex.setEmail(rs.getString(5));
				
				}

				return ex;

			}catch (Exception e1) {
				e1.printStackTrace();
			}
			return null;
		}
		
	    
	
	public List<Expense> getExpenseList()
	{
		String sql="select * from expense";
		List<Expense> exlist=new ArrayList<Expense>();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) 
			{
				Expense ex=new Expense();
				ex.setExpenseId(rs.getInt(1));
				ex.setExpense(rs.getDouble(2));
				ex.setExpenseType(rs.getString(3));
				ex.setExpenseDate(rs.getString(4));
				ex.setEmail(rs.getString(5));
				exlist.add(ex);
			}
			return exlist;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
