package com.ElectroGrid.payment;

import jakarta.xml.bind.annotation.*;

//declaration of variables
@XmlRootElement
public class Payment 
{
	private int id;
	private String name;
	private int accNo;
	private String dueDate;
	private String amount;
	
	
//getters and setters	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "Payment [id=" + id + ",name=" + name + ", accNo=" + accNo + ", dueDate=" + dueDate + ", amount=" + amount + "]";
	}
	
	
	
	
	
	
}

	
	


