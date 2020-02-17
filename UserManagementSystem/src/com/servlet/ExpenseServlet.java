package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ExpenseDao;
import com.pojo.Expense;


@WebServlet("/ExpenseServlet")
public class ExpenseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	Expense ex = new Expense();
	ExpenseDao ed = new ExpenseDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
		String action  = request.getParameter("action");
		if(action!= null && action.equals("delete"))
		{
			int expenseId = Integer.parseInt(request.getParameter("expenseId"));
			boolean b = ed.deleteExpense(expenseId);
			if(b)
			{
				response.sendRedirect("ExpenseServlet");
			}

		}
		else if(action!= null && action.equals("edit"))
		{
			int expenseId = Integer.parseInt(request.getParameter("expenseId"));
			Expense ex = ed.getExpenseByExpenseId(expenseId);
			session.setAttribute("ex",ex);
			response.sendRedirect("updateExpense.jsp");
		}
		else
		{
			List<Expense> exList=ed.getExpenseList();
			session.setAttribute("exlist", exList);
			response.sendRedirect("expenseList.jsp");
		}


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double expense= Double.parseDouble(request.getParameter("expense"));
		String expenseType = request.getParameter("expenseType");
		String expenseDate = request.getParameter("expenseDate" );
		String userEmail= request.getParameter("userEmail" );

		ex.setExpense(expense);
		ex.setExpenseType(expenseType);
		ex.setExpenseDate(expenseDate);
		ex.setUserEmail(userEmail);
		String action  = request.getParameter("action");
		System.out.println(action);
		if(action!=null && action.equals("addExpense")) {
			boolean b = ed.addExpense(ex);
			if(b)
			{
				response.sendRedirect("index.jsp");
			}
			else {
				response.sendRedirect("error.jsp");
			}
		}
		else if(action!=null && action.equals("updateExpense")) {
			int id1=Integer.parseInt(request.getParameter("id"));
			ex.setExpenseId(id1);
			boolean b=ed.updateExpense(ex);
			if(b) {
				response.sendRedirect("ExpenseServlet");

			}
		}
	}

}


