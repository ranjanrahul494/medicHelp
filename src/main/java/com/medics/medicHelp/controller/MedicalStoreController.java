package com.medics.medicHelp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medics.medicHelp.model.Drugs;
import com.medics.medicHelp.model.MedicalStores;
import com.medics.medicHelp.service.MedicalStoreService;

@RestController
@RequestMapping("/medicalStore")
public class MedicalStoreController {
	@Autowired
	MedicalStoreService medicalStoreService;
	
	/* add medical store details */
	@PostMapping("/addMedicalStoreDetails")
	public String addMedicalStore(@RequestBody MedicalStores medicalStores) {
		medicalStoreService.addMedicalStoreInformation(medicalStores);
		return "Medical store details add successfully";
	}
	
	
	/* add list of Drugs details in particular Medical Store */
	@PostMapping("/addDrugsDetailsList/{medicalStoreId}")
	public String addDrugsListDetails(@RequestBody MedicalStores medicalStores,@PathVariable("medicalStoreId")  String medicalStoreId) {
		medicalStoreService.addDrugsDetails(medicalStoreId,medicalStores.getDrugsList());
		return "Drugs details add successfully";
	}
	
	/* get all medical store information */
	@GetMapping("getMedicalStoreDetails")
	public List<MedicalStores> getAllMedicalStoreInfo() {
		return medicalStoreService.getMedicalStoresDetails();
	}
	
}
