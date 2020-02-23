package com.pojo;

public class Expense {
	int expenseId;
	double expense;
	String expenseType;
	String expenseDate;
	String email;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString() {
		return "Expense [expenseId=" + expenseId + ", expense=" + expense + ", expenseType=" + expenseType
				+ ", expenseDate=" + expenseDate + ", userEmail=" + email + "]";
	}
	
}
