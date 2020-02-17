package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.pojo.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	User u = new User();
	UserDao ud = new UserDao();
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session  = request.getSession();
		String action  = request.getParameter("action");
		if(action!=null && action.equals("delete"))
		{
			String email = request.getParameter("email");
			boolean b = ud.deleteUser(email);
			if(b)
			{
				response.sendRedirect("UserServlet");
			}
			
		}
		else if(action!= null && action.equals("edit"))
		{
			String email = request.getParameter("email");
			User u = ud.getUserByEmail(email);
			session.setAttribute("u",u);
			response.sendRedirect("updateUser.jsp");
		}
		
		else
		{
			List<User> wl = ud.getUserList();
			session.setAttribute("wlist",wl);
			response.sendRedirect("userList.jsp");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		u.setName(name);
		u.setEmail(email);
		u.setPassword(password);
		System.out.println(u);
		String action  = request.getParameter("action");
		if(action!=null && action.equals("addUser"))
		{
			boolean i = ud.addUser(u);
			if(i)
			{
				response.sendRedirect("success.jsp");
			}
			else
			{
				response.sendRedirect("error.jsp");
			}
		}
			else if(action!=null && action.equals("updateUser"))
			{
				boolean b=ud.updateUser(u);
				if(b)
				{
					response.sendRedirect("UserServlet");

				}
			}
			
		}
	}


