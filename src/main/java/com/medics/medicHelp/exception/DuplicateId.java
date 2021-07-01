package com.medics.medicHelp.exception;

public class DuplicateId extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicateId(String msg) {
		super(msg);
	}
}
