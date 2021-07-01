package com.medics.medicHelp.model;

import java.io.Serializable;
import java.util.List;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String firstName;
	private String medialName;
	private String lastName;
	private String email;
	@Id
	private String phoneNumber;
	private String password;
	private List<UserAddress> address;
	private List<TransactionDetails> transactionDetails;
	private List<Medicine> medicineList;
	
	public List<Medicine> getMedicine() {
		return medicineList;
	}
	public void setMedicine(List<Medicine> medicine) {
		this.medicineList = medicine;
	}
	private Binary image;
	public Binary getImage() {
		return image;
	}
	public void setImage(Binary image) {
		this.image = image;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMedialName() {
		return medialName;
	}
	public void setMedialName(String medialName) {
		this.medialName = medialName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<UserAddress> getAddress() {
		return address;
	}
	public void setAddress(List<UserAddress> address) {
		this.address = address;
	}
	public List<TransactionDetails> getTransactionDetails() {
		return transactionDetails;
	}
	public void setTransactionDetails(List<TransactionDetails> transactionDetails) {
		this.transactionDetails = transactionDetails;
	}
	
	public User() {}
	public User(String firstName, String medialName, String lastName, String email, String phoneNumber, String password,
			List<UserAddress> address, List<TransactionDetails> transactionDetails, List<Medicine> medicine,
			Binary image) {
		super();
		this.firstName = firstName;
		this.medialName = medialName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.address = address;
		this.transactionDetails = transactionDetails;
		this.medicineList = medicine;
		this.image = image;
	}
	
	

}
