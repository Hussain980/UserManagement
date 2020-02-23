package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.config.DBConnect;
import com.pojo.Income;

public class IncomeDao {
	Connection con = DBConnect.getConnect();
	 public boolean addIncome(Income i)
	    {
	    	String sql = "insert into income (income,incomeType,incomeDate,email)values(?,?,?,?)";
	    	
	    	try
	        {
	    		PreparedStatement ps = con.prepareStatement(sql);
	    		
	    		ps.setDouble(1, i.getIncome());
	    		ps.setString(2, i.getIncomeType());
	    		ps.setString(3, i.getIncomeDate());
	    		ps.setString(4, i.getEmail());
	    		int in =ps.executeUpdate();
	    		if(in>0)
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
	 
	    public boolean updateIncome(Income i) {

			String sql = "update income set income=?,incomeType=? ,incomeDate=?,email=? where incomeId=?";

			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setDouble(1, i.getIncome());
				ps.setString(2, i.getIncomeType());
				ps.setString(3, i.getIncomeDate());
				ps.setString(4,i.getEmail());
				ps.setInt(5, i.getIncomeId());

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
	    
	    public boolean deleteIncome(int incomeId)
	    {
	    	String sql  =  "Delete from income where incomeId=?";
	    	try
	    	{
	    		PreparedStatement ps = con.prepareStatement(sql);
	    	   ps.setInt(1, incomeId);
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
	    
		
		public Income getIncomeByIncomeId(int incomeId){
			String sql="select * from income where incomeId=?";
			Income i = new Income();
			try {
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setInt(1, incomeId);
				ResultSet rs=ps.executeQuery();
				while (rs.next()) {
					i.setIncomeId(rs.getInt(1));
					i.setIncome(rs.getDouble(2));
					i.setIncomeType(rs.getString(3));
					i.setIncomeDate(rs.getString(4));
					i.setEmail(rs.getString(5));
				
				}

				return i;

			}catch (Exception e1) {
				e1.printStackTrace();
			}
			return null;
		}
		
	    
	    
	    public List<Income> getIncomeList()
	    {
	    	String sql = "Select * from income";
	    	List<Income> wl = new ArrayList<Income>();
	    	try
	    	{
	    		PreparedStatement ps = con.prepareStatement(sql);
	    		ResultSet rs = ps.executeQuery();
	    		while(rs.next())
	    		{
	    			Income i = new Income();
	    			i.setIncomeId(rs.getInt(1));
	    			i.setIncome(rs.getDouble(2));
	    			i.setIncomeType(rs.getString(3));
	    			i.setIncomeDate(rs.getString(4));
	    			i.setEmail(rs.getString(5));
	    			wl.add(i);
	    		}
	    		return wl;
	    		
	    	}
	    	catch(Exception e)
	    	{
	    		e.printStackTrace();
	    	}
	    	
			return null;
	    	
	    }
	    
}
