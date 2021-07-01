package com.medics.medicHelp.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medics.medicHelp.dao.MedicalStoreDao;
import com.medics.medicHelp.dao.OrderDetailsDao;
import com.medics.medicHelp.dao.UserDao;
import com.medics.medicHelp.model.Drugs;
import com.medics.medicHelp.model.MedicalStores;
import com.medics.medicHelp.model.Medicine;
import com.medics.medicHelp.model.OrderDetails;
import com.medics.medicHelp.model.User;

@Service
public class UserRelationServiceImp implements UserRelationService{
	@Autowired
	private UserDao userDao;
	@Autowired
	private MedicalStoreDao medicalStoreDao;
	@Autowired
	private OrderDetailsDao orderDetailsDao;
	private List<Drugs> orderDrugs;
	
	public Set<String> getMedicineStoreDetails(String userId) {

		User userDetails=userDao.getUserDetails(userId);
		Set<String> medicalStoreName=new HashSet<>();
		boolean flag=false;
		List<Medicine> medicineList=userDetails.getMedicine();
		for (MedicalStores medicalStores : medicalStoreDao.getMedicalStoresDetails()) {
			for (Medicine medicine : medicineList) {
				for (Drugs drugs : medicalStores.getDrugsList()) {
					if(medicine.getMedicineName().equals(drugs.getDrugName())) {
						flag=true;
						break;
					}else {
						flag=false;
					}
				}
				if (!flag)
					break;
			}
			if (flag) {
				medicalStoreName.add(medicalStores.getMedicalStoreName());
			}
		}
		
		return medicalStoreName;
	
	}
	
	public OrderDetails getOrderDetails(String orderId){
		OrderDetails orderDetails=orderDetailsDao.getOrderDetails(orderId);
		User userDetails=userDao.getUserDetails(orderDetails.getUserId());
		List<Drugs>getDrugsList=new ArrayList<Drugs>();
		orderDrugs=new ArrayList<Drugs>();
		boolean flag=false;
		double totalMedicinePrice=0;
		for (MedicalStores medicalStores : medicalStoreDao.getMedicalStoresDetails()) {
			if(medicalStores.getMedicalStoreId().equals(orderDetails.getMedicalStoreId())) {
				for (Medicine medicine : userDetails.getMedicine()) {
					for (Drugs drugs : medicalStores.getDrugsList()) {
						if(medicine.getMedicineName().equals(drugs.getDrugName())&& medicine.getMedicinequantity()<=drugs.getQuantity()) {
							totalMedicinePrice=totalMedicinePrice+drugs.getPrice()* medicine.getMedicinequantity();
							drugs.setQuantity(drugs.getQuantity()-medicine.getMedicinequantity());
							getDrugsList.add(drugs);
							drugs.setQuantity(medicine.getMedicinequantity());
							orderDrugs.add(drugs);
							flag=true;
							break;
						}else {
							
						}
					}
					
				}
			}
			if(flag) {
				medicalStoreDao.addMedicalStoreInformation(medicalStores);
				
				orderDetails.setMedicineList(getDrugsList);
				orderDetails.setTotalMedicinePrice(totalMedicinePrice);
				orderDetails.setMedicineList(orderDrugs);
				orderDetailsDao.updateOrderDetails(orderDetails, orderId);
				break;
			}
	
		}

		return orderDetails;
	
	}

}
