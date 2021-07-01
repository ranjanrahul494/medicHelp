package com.medics.medicHelp.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class OrderDetails implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String orderId;
	private String userId;
	private String medicalStoreId;
	private double totalMedicinePrice;
	private List<Drugs> medicineList;
	public OrderDetails() {
		
	}
	public List<Drugs> getMedicineList() {
		return medicineList;
	}

	public void setMedicineList(List<Drugs> medicineList) {
		this.medicineList = medicineList;
	}

	public String getMedicalStoreId() {
		return medicalStoreId;
	}

	public void setMedicalStoreId(String medicalStoreId) {
		this.medicalStoreId = medicalStoreId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public double getTotalMedicinePrice() {
		return totalMedicinePrice;
	}

	public void setTotalMedicinePrice(double totalMedicinePrice) {
		this.totalMedicinePrice = totalMedicinePrice;
	}
	

}
