package com.medics.medicHelp.model;

import java.io.Serializable;

public class Medicine implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String medicineName;
	private int medicinequantity;
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	
	public int getMedicinequantity() {
		return medicinequantity;
	}
	public void setMedicinequantity(int medicinequantity) {
		this.medicinequantity = medicinequantity;
	}
	public Medicine() {
		
	}
	public Medicine(String medicineName, int medicinequantity) {
		super();
		this.medicineName = medicineName;
		this.medicinequantity = medicinequantity;
	}
	
}
