package com.medics.medicHelp.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class MedicalStores implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String medicalStoreId;
	private String medicalStoreName;
	private UserAddress userAddress;
	private List<Drugs> drugsList;
	
	public MedicalStores(String medicalStoreName, UserAddress userAddress, List<Drugs> drugsList) {
		this.medicalStoreName = medicalStoreName;
		this.userAddress = userAddress;
		this.drugsList = drugsList;
	}

	public MedicalStores() {
		
	}

	public String getMedicalStoreId() {
		return medicalStoreId;
	}

	public void setMedicalStoreId(String medicalStoreId) {
		this.medicalStoreId = medicalStoreId;
	}

	public UserAddress getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(UserAddress userAddress) {
		this.userAddress = userAddress;
	}

	public String getMedicalStoreName() {
		return medicalStoreName;
	}
	public void setMedicalStoreName(String medicalStoreName) {
		this.medicalStoreName = medicalStoreName;
	}
	public List<Drugs> getDrugsList() {
		return drugsList;
	}
	public void setDrugsList(List<Drugs> drugsList) {
		this.drugsList = drugsList;
	}
	
}
