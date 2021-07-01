package com.medics.medicHelp.model;

import java.io.Serializable;

public class UpdoadedExcel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String medicine ;

	public String getMedicine() {
		return medicine;
	}

	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}

	public UpdoadedExcel() {
		
	}

	public UpdoadedExcel(String medicine) {
		this.medicine = medicine;
	}
	
}
