package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.config.DBConnect;
import com.pojo.User;

public class UserDao {
	Connection con = DBConnect.getConnect();

	public boolean addUser(User u)
	{

		String sql = "insert into user values(?,?,?)";
		try
		{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, u.getName());
			ps.setString(2,u.getEmail());
			ps.setString(3, u.getPassword());
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

	public boolean updateUser(User u)
	{
		String sql ="update user set name=?,password=? where email=?";
		try
		{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, u.getName());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getEmail());
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

	public boolean deleteUser(String email)
	{
		String sql = "delete from user where email=?";
		try
		{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
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

	public User getUserByEmail(String email)
	{
		User u = new User();
		String sql = "select * from user where email=?";
		try
		{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				u.setName(rs.getString(1));
				u.setEmail(rs.getString(2));
				u.setPassword(rs.getString(3));
			}
		}
		catch(Exception e)
		{

		}
		return u;

	}

	public List<User> getUserList()
	{
		String sql = "select * from user";
		List<User> wl = new ArrayList<User>();
		try
		{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				User e= new User();
				e.setName(rs.getString(1));
				e.setEmail(rs.getString(2));
				e.setPassword(rs.getString(3));
				wl.add(e);
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
