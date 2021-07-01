package com.medics.medicHelp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.medics.medicHelp.exception.DuplicateId;
import com.medics.medicHelp.model.Drugs;
import com.medics.medicHelp.model.MedicalStores;

@Repository
public class MedicalStoreDaoImp implements MedicalStoreDao{
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public final static String collection_name="medicalStores";

	@Override
	public void addMedicalStoreInformation(MedicalStores medicalStores) {
		if(!mongoTemplate.collectionExists(MedicalStores.class)) {
			mongoTemplate.createCollection(MedicalStores.class);
		}
		try {
			mongoTemplate.save(medicalStores,collection_name);
		} catch (Exception e) {
			throw new DuplicateId("medical store allready exit");
		}
		
	}

	@Override
	public List<MedicalStores> getMedicalStoresDetails() {
		return mongoTemplate.findAll(MedicalStores.class);
	}

	@Override
	public void addDrugsDetails(String medicalStoreId, List<Drugs> drugsDetailsList) {
		MedicalStores medicalStores=this.getParticularMedicalStoreDetails(medicalStoreId);
		medicalStores.setDrugsList(drugsDetailsList);
		mongoTemplate.save(medicalStores);
		
	}

	/* find Particular MedicalStore Details */
	@Override
	public MedicalStores getParticularMedicalStoreDetails(String medicalStoreId){
		MedicalStores medicalStores=mongoTemplate.findById(medicalStoreId, MedicalStores.class);
		return medicalStores;
	}

}
