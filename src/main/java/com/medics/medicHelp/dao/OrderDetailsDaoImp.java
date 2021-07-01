package com.medics.medicHelp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.medics.medicHelp.exception.DuplicateId;
import com.medics.medicHelp.model.OrderDetails;

@Repository
public class OrderDetailsDaoImp implements OrderDetailsDao{
	@Autowired
	private MongoTemplate mongoTemplate;
	@Override
	public void addOrderDetails(OrderDetails orderDetails,String medicalStoreId) {
		if (!mongoTemplate.collectionExists(OrderDetails.class)) {
			mongoTemplate.createCollection(OrderDetails.class);
		}
		try {
			orderDetails.setMedicalStoreId(medicalStoreId);
			mongoTemplate.save(orderDetails, "orderDetails");
		} catch (Exception e) {
			throw new DuplicateId("user allready exit");
		}
		
	}
	@Override
	public OrderDetails getOrderDetails(String orderId) {
		return mongoTemplate.findById(orderId, OrderDetails.class);
	}
	@Override
	public void updateOrderDetails(OrderDetails orderDetails, String orderId) {
		mongoTemplate.save(orderDetails, "orderDetails");
		
	}

}
