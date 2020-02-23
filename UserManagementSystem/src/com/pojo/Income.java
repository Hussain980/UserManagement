package com.pojo;

public class Income {
	int incomeId;
	double income;
	String incomeType;
	String incomeDate;
	String email;
	public int getIncomeId() {
		return incomeId;
	}
	public void setIncomeId(int incomeId) {
		this.incomeId = incomeId;
	}
	public double getIncome() {
		return income;
	}
	public void setIncome(double income) {
		this.income = income;
	}
	public String getIncomeType() {
		return incomeType;
	}
	public void setIncomeType(String incomeType) {
		this.incomeType = incomeType;
	}
	public String getIncomeDate() {
		return incomeDate;
	}
	public void setIncomeDate(String incomeDate) {
		this.incomeDate = incomeDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString() {
		return "Income [incomeId=" + incomeId + ", income=" + income + ", incomeType=" + incomeType + ", incomeDate="
				+ incomeDate + ", userEmail=" + email + "]";
	}
	
	
}
