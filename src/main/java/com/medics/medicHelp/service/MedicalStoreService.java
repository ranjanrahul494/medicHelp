package com.medics.medicHelp.service;

import java.util.List;

import com.medics.medicHelp.model.Drugs;
import com.medics.medicHelp.model.MedicalStores;

public interface MedicalStoreService {
	public void addMedicalStoreInformation(MedicalStores medicalStores);
	public List<MedicalStores> getMedicalStoresDetails();
	public void addDrugsDetails(String medicalStoreId, List<Drugs> drugsDetailsList);
}
