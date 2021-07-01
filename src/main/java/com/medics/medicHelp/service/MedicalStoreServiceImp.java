package com.medics.medicHelp.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medics.medicHelp.dao.MedicalStoreDao;
import com.medics.medicHelp.model.Drugs;
import com.medics.medicHelp.model.MedicalStores;

@Service
public class MedicalStoreServiceImp implements MedicalStoreService{
	@Autowired
	private MedicalStoreDao medicalStoreDao;
	
	@Override
	public void addMedicalStoreInformation(MedicalStores medicalStores) {
		medicalStoreDao.addMedicalStoreInformation(medicalStores);
		
	}

	@Override
	public List<MedicalStores> getMedicalStoresDetails() {
		return medicalStoreDao.getMedicalStoresDetails();
	}


	@Override
	public void addDrugsDetails(String medicalStoreId, List<Drugs> drugsDetailsList) {		
		drugsDetailsList.addAll(medicalStoreDao.getParticularMedicalStoreDetails(medicalStoreId).getDrugsList());
		//List drugDetails=new ArrayList();
		List newDrugsList=addQuantyOfExistingDrugs(drugsDetailsList);
		/* sort the list */
		newDrugsList.sort(Comparator.comparing(Drugs :: getDrugName));
		medicalStoreDao.addDrugsDetails(medicalStoreId,newDrugsList);
		
	}

	/* add quantity of drugs if that drugs is exist and return set of drugs */
	
	public static List addQuantyOfExistingDrugs(List<Drugs> drugList)
	{ 
	  final Set set1 = new HashSet(); 
	  final List newDrugList = new ArrayList();

	 for (int i = 0; i < drugList.size(); i++) {
		 for (int j = i+1; j < drugList.size(); j++) {
			if(drugList.get(i).getDrugName().equalsIgnoreCase(drugList.get(j).getDrugName())){
				int drugsQuantity= drugList.get(i).getQuantity();
				drugsQuantity=drugsQuantity+ drugList.get(j).getQuantity();
				drugList.get(i).setQuantity(drugsQuantity); 
			}	 
			if(set1.add(drugList.get(i).getDrugName())){
				newDrugList.add(drugList.get(i));
			}
		}
		
	}
	  return newDrugList;
	}

}
