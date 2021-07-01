package com.medics.medicHelp.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.medics.medicHelp.model.Drugs;
import com.medics.medicHelp.model.MedicalStores;
import com.medics.medicHelp.model.UserAddress;

@Repository
public class MedicineRecord {
	public List<MedicalStores> medicineRecord() {
		
		List<Drugs> drugsList=new ArrayList<Drugs>();
		drugsList.add(new Drugs("a", 10, 12.0));
		drugsList.add(new Drugs("b", 61, 122.0));
		drugsList.add(new Drugs("c", 18, 132.0));
		drugsList.add(new Drugs("d", 68, 122.0));
		drugsList.add(new Drugs("e", 13, 132.0));
		List<Drugs> drugsList2=new ArrayList<Drugs>();
		drugsList2.add(new Drugs("a", 10, 12.0));
		drugsList2.add(new Drugs("f", 61, 122.0));
		drugsList2.add(new Drugs("c", 18, 132.0));
		
		List<MedicalStores> medicalStore=new ArrayList<MedicalStores>();
		medicalStore.add(new MedicalStores("abc",new UserAddress("rahul", "ban", "kar", 123), drugsList));
		medicalStore.add(new MedicalStores("adc",new UserAddress("ranjan", "ban", "kar", 123), drugsList2));
		medicalStore.add(new MedicalStores("gds",new UserAddress("deepesh", "ban", "kar", 123), drugsList));
		medicalStore.add(new MedicalStores("tnh",new UserAddress("suraj", "ban", "kar", 123), drugsList));
		System.out.println(medicalStore);
		return medicalStore;
	}
}
