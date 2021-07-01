package com.medics.medicHelp.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

public class TransactionDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private int transactionId;
	private String amount;
	private String date;
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public TransactionDetails() {}
	public TransactionDetails(String amount, String date) {
		super();
		this.amount = amount;
		this.date = date;
	}
	public TransactionDetails(int transactionId, String amount, String date) {
		super();
		this.transactionId = transactionId;
		this.amount = amount;
		this.date = date;
	}
	
}
