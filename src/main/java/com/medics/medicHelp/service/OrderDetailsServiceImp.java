package com.medics.medicHelp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medics.medicHelp.dao.OrderDetailsDao;
import com.medics.medicHelp.model.OrderDetails;

@Service
public class OrderDetailsServiceImp implements OrderDetailsService{
	@Autowired
	private OrderDetailsDao orderDetailsDao;
	@Override
	public void addOrderDetails(OrderDetails orderDetails,String medicalStoreId) {
		orderDetailsDao.addOrderDetails(orderDetails, medicalStoreId);
		
	}
	@Override
	public void updateOrderDetails(OrderDetails orderDetails, String orderId) {
		orderDetailsDao.updateOrderDetails(orderDetails, orderId);
		
	}

}
