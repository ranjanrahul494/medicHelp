package com.medics.medicHelp.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

public class Drugs implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String drugName;
	private int quantity;
	private double price;
	
	public Drugs() {
	}
	
	public Drugs(String drugName, int quantity, double price) {
		this.drugName = drugName;
		this.quantity = quantity;
		this.price = price;
	}
	

	public String getDrugName() {
		return drugName;
	}
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
