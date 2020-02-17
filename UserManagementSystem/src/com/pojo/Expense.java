package com.pojo;

public class Expense {
	int expenseId;
	double expense;
	String expenseType;
	String expenseDate;
	String userEmail;
	public int getExpenseId() {
		return expenseId;
	}
	public void setExpenseId(int expenseId) {
		this.expenseId = expenseId;
	}
	public double getExpense() {
		return expense;
	}
	public void setExpense(double expense) {
		this.expense = expense;
	}
	public String getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}
	public String getExpenseDate() {
		return expenseDate;
	}
	public void setExpenseDate(String expenseDate) {
		this.expenseDate = expenseDate;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	public String toString() {
		return "Expense [expenseId=" + expenseId + ", expense=" + expense + ", expenseType=" + expenseType
				+ ", expenseDate=" + expenseDate + ", userEmail=" + userEmail + "]";
	}
	
}
