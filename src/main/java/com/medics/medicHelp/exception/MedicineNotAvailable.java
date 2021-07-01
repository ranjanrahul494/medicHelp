package com.medics.medicHelp.exception;

import java.io.Serializable;

public class MedicineNotAvailable extends RuntimeException implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MedicineNotAvailable(String msg) {
		super(msg);
	}
}
