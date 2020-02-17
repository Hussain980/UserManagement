package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.config.DBConnect;
import com.pojo.User;

public class LoginDao {
	Connection con = DBConnect.getConnect();
	public User getUserLogin(String email, String Password)
	{
		User u = new User();
		String sql = "select email,password from user where email=? and password=?";
		try
		{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, Password);
			ResultSet rs = ps.executeQuery();
			System.out.println(rs);
			while(rs.next())
			{
				u.setEmail(rs.getString(1));
				u.setPassword(rs.getString(2));

			}
			return u;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;

	}
}
