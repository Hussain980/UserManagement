package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.IncomeDao;
import com.pojo.Income;


@WebServlet("/IncomeServlet")
public class IncomeServlet extends HttpServlet {
	Income i = new Income();
	IncomeDao id = new IncomeDao();
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   HttpSession session = request.getSession();
					String action  = request.getParameter("action");
					if(action!=null && action.equals("delete"))
					{
						int incomeId = Integer.parseInt(request.getParameter("incomeId"));
						boolean b = id.deleteIncome(incomeId);
						if(b)
						{
							response.sendRedirect("IncomeServlet");
						}
						
					}
					else if(action!= null && action.equals("edit"))
					{
						int incomeId = Integer.parseInt(request.getParameter("incomeId"));
						Income i = id.getIncomeByIncomeId(incomeId);
						session.setAttribute("i",i);
						response.sendRedirect("updateIncome.jsp");
					}
					else
					{
						List<Income> wl = id.getIncomeList();
						session.setAttribute("wlist",wl);
						response.sendRedirect("incomeList.jsp");
					}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double income = Double.parseDouble(request.getParameter("income")) ;
		String incomeType = request.getParameter("incomeType");
		String incomeDate = request.getParameter("incomeDate" );
		String userEmail= request.getParameter("userEmail" );
		 i.setIncome(income);
	     i.setIncomeType(incomeType);
	     i.setIncomeDate(incomeDate);
	     i.setUserEmail(userEmail);
	     String action  = request.getParameter("action");
			System.out.println(action);
			if(action!=null && action.equals("addIncome"))
			{
				 boolean b = id.addIncome(i);
					if(b)
					{
						response.sendRedirect("success.jsp");
					}
					else {
						response.sendRedirect("error.jsp");
					}
			}
	    
			else if(action!=null && action.equals("updateIncome")) {
				int id1=Integer.parseInt(request.getParameter("id"));
				i.setIncomeId(id1);
				boolean b=id.updateIncome(i);
				if(b) {
					response.sendRedirect("IncomeServlet");

				}
			}
	}
	}


